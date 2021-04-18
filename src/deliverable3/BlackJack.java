/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverable3;

import java.util.Scanner;

/**
 *
 * @author hieud
 */
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Asian BlackJack!!!");
        System.out.println("Please select 1 or 2:");

        Scanner sc;
        Scanner sc2;
        Scanner sc3;
        Scanner sc4;

        System.out.println("1. Read the rules");
        System.out.println("2. Start the game");

        while (true) {
            sc = new Scanner(System.in);
            sc2 = new Scanner(System.in);
            if (sc.nextInt() == 1) {
                System.out.println("Asian BlackJack rules:");
                System.out.println("1. Number cards have values same as their number. IE: a TWO has value of 2.");
                System.out.println("2. Face cards (JACK, QUEEN, KING) have values of 10.");
                System.out.println("3. ACE can have value of either 1 or 10 or 11.");
                System.out.println("4. If one's hand is less than 16 or higher than 21(busted), that hand lose.");
                System.out.println("5. In order to win, one's hand total value must be higher than other's and still satisfy the above condition.");
                System.out.println("6. If you are busted, your hand is not automatically shown. You have to wait after dealer finishes hitting.");
                System.out.println("7. After dealer finishes hitting, all hands will be shown. Winner takes bet money. Loser loses bet money.");
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println("Press s to start the game");
                if (sc2.nextLine().equalsIgnoreCase("s")) {
                    break;
                }
            } else {
                break;
            }
        }

        Player player = new Player();
        Dealer dealer = new Dealer();

        while (true) {
            sc = new Scanner(System.in);

            System.out.print("Enter player's money amount: ");
            double amount = sc.nextDouble();
            if (amount > 0) {
                player.setAmount(amount);
                break;
            } else {
                System.out.println("You have no money!!! Try again!!!");
            }
        }

        dealer.setAmount(player.getAmount() * 10);

        while (player.getAmount() > 0) {
            double bet = 0;
            while (true) {
                sc2 = new Scanner(System.in);
                System.out.println("\n" + "Current money amount: " + player.getAmount());
                System.out.print("Enter bet amount: ");
                bet = sc.nextDouble();
                if (bet <= player.getAmount()) {
                    break;
                } else {
                    System.out.println("Insufficient fund!!! Try again!!!");
                }
            }
            System.out.println("\nShuffling the deck!");
            System.out.println("");
            Deck deck = new Deck();
            deck.createDeck();
            deck.shuffle();
            Hand playerHand = new Hand();
            Hand dealerHand = new Hand();
            player.setHand(playerHand);
            dealer.setHand(dealerHand);
            player.hit(deck);
            dealer.hit(deck);
            player.hit(deck);
            dealer.hit(deck);
            System.out.println("\n----------------------");
            System.out.println("Dealer hand:");
            System.out.println(dealer.getHand().getCard(0).toString());
            System.out.println("Hidden");
            System.out.println("----------------------");
            System.out.println("\n----------------------");
            System.out.println("Your hand:");
            System.out.println(player.toString());
            System.out.println("----------------------");

            while (true) {
                sc3 = new Scanner(System.in);
                System.out.println("Would you like to hit (1) or stay (2): ");
                if (sc3.nextInt() == 1) {
                    player.hit(deck);
                    System.out.println("\n----------------------");
                    System.out.println("You draw a : " + player.getHand().getNewDrawnCard().toString());
                    System.out.println("Total Value: " + player.calculate());
                    System.out.println("----------------------");
                } else {
                    break;
                }
            }
            if (player.getHand().size() == 2) {
                if (dealer.calculate() <= 17) {
                    dealer.hit(deck);
                }

            } else {
                if (dealer.calculate() <= 15) {
                    dealer.hit(deck);
                }
            }
            System.out.println("\n----------------------");
            System.out.println("\nDealer's hand:");
            System.out.println(dealer.toString());
            System.out.println("----------------------");

            if (dealer.calculate() == player.calculate() || (dealer.calculate() > 21 && player.calculate() > 21)) {
                System.out.println("It's a draw!!!");
                System.out.println("Current money amount: " + player.getAmount() + "\n");
            }
            if (player.calculate() <= 21 && player.calculate() > dealer.calculate()) {
                System.out.println("You won!!!");
                player.addAmount(bet);
                System.out.println("Current money amount: " + player.getAmount() + "\n");
            }
            if (dealer.calculate() <= 21 && dealer.calculate() > player.calculate()) {
                System.out.println("You lost!!!");
                player.removeAmount(bet);
                System.out.println("Current money amount: " + player.getAmount() + "\n");
            }
            if ((player.calculate() <= 21 && player.calculate() > 15) && dealer.calculate() > 21) {
                System.out.println("You won!!!");
                player.addAmount(bet);
                System.out.println("Current money amount: " + player.getAmount() + "\n");
            }
            if (player.calculate() > 21 && (dealer.calculate() <= 21 && dealer.calculate() > 15)) {
                System.out.println("You lost!!!");
                player.removeAmount(bet);
                System.out.println("Current money amount: " + player.getAmount() + "\n");
            }
            if (player.getAmount() == 0) {
                System.out.println("You have no money!!! Goodbye!!!");
            }

            sc4 = new Scanner(System.in);

            System.out.println("Would you like to play again? Yes (y) or No (n)");
            if (sc4.nextLine().equalsIgnoreCase("n")) {
                System.out.println("Goodbye!");
                player.setAmount(0);
            } else {
                System.out.println("\nNew round!!!");
            }

        }

    }
}
