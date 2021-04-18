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
        System.out.println("Welcome to Asian BlackJack!!!\n");
        System.out.println("If you are busted, your hand is not automatically shown!!!");
        System.out.println("You might want to read the rule first as this is different from normal BlackJack!\n");
        System.out.println("Please select 1 or 2:");
        
        //creating scanner for user input
        Scanner sc;
        Scanner sc2;
        Scanner sc3;
        Scanner sc4;

        System.out.println("1. Read the rules");
        System.out.println("2. Start the game");
        
        //prompt user for input to read rules or start game
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
                System.out.println("6. If you are busted, your hand is not automatically shown. You have to wait after dealer finish their turn.");
                System.out.println("7. After dealer finish their turn, all hands will be shown. Winner takes bet money. Loser loses bet money.");
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println("Press s to start the game");
                if (sc2.nextLine().equalsIgnoreCase("s")) {
                    break;
                }
            } else {
                break;
            }
        }
        
        //create new player
        Player player = new Player();
        
        //create new dealer
        Dealer dealer = new Dealer();

        //keep promptin user to get proper money input
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
        
        //set dealer's money amount
        dealer.setAmount(player.getAmount() * 10);
        
        //keep playing the game until user end the game or user's money amount equals 0
        while (player.getAmount() > 0) {
            double bet = 0;
            //keep prompting to get proper user's bet amount
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
            
            //create new deck
            Deck deck = new Deck();
            deck.createDeck();
            
            //shuffle deck
            deck.shuffle();
            
            //create new hands
            Hand playerHand = new Hand();
            Hand dealerHand = new Hand();
            
            //assign hand to user
            player.setHand(playerHand);
            
            //assign hand to dealer
            dealer.setHand(dealerHand);
            
            //player and dealer draw card
            player.hit(deck);
            dealer.hit(deck);
            player.hit(deck);
            dealer.hit(deck);
            
            //print dealer's one card on hand
            System.out.println("\n----------------------");
            System.out.println("Dealer hand:");
            System.out.println(dealer.getHand().getCard(0).toString());
            System.out.println("Hidden");
            System.out.println("----------------------");
            
            //print user's hand
            System.out.println("\n----------------------");
            System.out.println("Your hand:");
            System.out.println(player.toString());
            System.out.println("----------------------");
            
            //keep prompting user to hit or stay
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
            
            //user draw cards based on user hand
            if (player.getHand().size() == 2) {
                if (dealer.calculate() <= 17) {
                    dealer.hit(deck);
                }
            } else {
                if (dealer.calculate() <= 15) {
                    dealer.hit(deck);
                }
            }
            
            //print dealer's hand
            System.out.println("\n----------------------");
            System.out.println("\nDealer's hand:");
            System.out.println(dealer.toString());
            System.out.println("----------------------");
            
            
            //decide who wins
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
            
            
            //promp if user wants to play again
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
