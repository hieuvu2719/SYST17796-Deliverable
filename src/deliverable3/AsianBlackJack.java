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
public class AsianBlackJack {

    private Player player;
    private Dealer dealer;

    public AsianBlackJack(Player player,Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
    }
    
    //show introduction to the game
    public void intro() {
        System.out.println("Welcome to Asian BlackJack!!!\n");
        System.out.println("Even if you are busted, your still have a chance!!!");
        System.out.println("Your hand will be shown only after dealer finish their turn!!!");
        System.out.println("You might want to read the rule first as this is different from normal BlackJack!\n");
        Scanner sc;
        int select = 0;
        boolean confirm = false;
        //prompt user for input to read rules or start game
        while (true) {
            System.out.println("Please select 1 or 2:");
            System.out.println("1. Read the rules");
            System.out.println("2. Start the game");
            sc=new Scanner(System.in);
            if (sc.hasNextInt()) {
                select = sc.nextInt();
                if (select == 1) {
                    System.out.println("Asian BlackJack rules:");
                    System.out.println("1. Number cards have values same as their number. IE: a TWO has value of 2.");
                    System.out.println("2. Face cards (JACK, QUEEN, KING) have values of 10.");
                    System.out.println("3. ACE can have value of either 1 or 10 or 11.");
                    System.out.println("4. A hand can have maximum five cards.");
                    System.out.println("5. If one's hand is less than 16 or higher than 21(busted), that hand lose.");
                    System.out.println("6. In order to win, one's hand total value must be higher than other's and still satisfy the above condition.");
                    System.out.println("7. If you are busted, your hand is not automatically shown. You have to wait after dealer finish their turn.");
                    System.out.println("8. After dealer finish their turn, all hands will be shown. Winner takes bet money. Loser loses bet money.");
                    System.out.println("------------------------------------------------------------------------------------------");
                    while (!confirm) {
                        sc = new Scanner(System.in);
                        System.out.println("Press s to start the game");
                        if (sc.nextLine().equalsIgnoreCase("s")) {
                            confirm = true;
                        } else {
                            System.out.println("Invalid input!!!");
                        }
                    }
                    break;
                }
                if (select == 2) {
                    break;
                } else {
                    System.out.println("Invalid input!!! Try again!!!");
                }
            } else {
                System.out.println("Invalid input!!! Try again!!!");
            }
        }


    }

    //set player money amount
    public void setMoneyAmount() {
        Scanner sc;
        while (true) {
            sc = new Scanner(System.in);
            System.out.print("Enter player's money amount: ");
            if (sc.hasNextDouble()) {
                double amount = sc.nextDouble();
                if (amount > 0) {
                    player.setAmount(amount);
                    break;
                } else {
                    System.out.println("You have no money!!! Try again!!!");
                }
            } else {
                System.out.println("Invalid input!!! Try again!!!");
            }
        }
    }
    
    
    //set bet money
    public void bet(){
        Scanner sc;
        double bet = 0;
            //keep prompting to get proper user's bet amount
            while (true) {
                sc = new Scanner(System.in);
                System.out.println("\n" + "Current money amount: " + player.getAmount());
                System.out.print("Enter bet amount: ");
                if (sc.hasNextDouble()) {
                    bet = sc.nextDouble();
                    if (bet <= player.getAmount()) {
                        break;
                    } else {
                        System.out.println("Insufficient fund!!! Try again!!!");
                    }
                } else {
                    System.out.println("Invalid input!!! Try again!!!");
                }
            }
        player.setBet(bet);
            
    }
    
    //dealer deal cards
    public void deal(){
        dealer.setAmount(player.getAmount() * 10);
        
        //keep playing the game until user end the game or user's money amount equals 0            
            System.out.println("\nDealer is getting a new deck and shuffling it!");
            System.out.println("");

            //dealer get new deck and shuffle the deck    
            Deck deck = new Deck();
            deck.create();
            dealer.setDeck(deck);
            dealer.shuffle();

            Hand playerHand = new Hand();
            Hand dealerHand = new Hand();
            player.setHand(playerHand);
            dealer.setHand(dealerHand);

            dealer.deal(player, deck);

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
    }
    
    //hit or stay
    public void hit() {
            Scanner sc;
            int select = 0;
            //keep prompting user to hit or stay
            while (true) {
                System.out.println("Would you like to hit (1) or stay (2): ");
                sc = new Scanner(System.in);
                if (sc.hasNextInt()) {
                    select = sc.nextInt();
                    if (select == 1) {
                        player.hit(dealer.getDeck());
                        System.out.println("\n----------------------");
                        System.out.println("You draw a : " + player.getHand().getNewDrawnCard().toString());
                        System.out.println("Total Value: " + player.calculate());
                        System.out.println("----------------------");
                        if (player.getHand().size() == 5) {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Invalid input!!! Try again!!!");
                }
            }

            //dealer draw cards based on user hand
            if (player.getHand().size() == 2) {
                while (dealer.calculate() <= 17) {
                    dealer.hit(dealer.getDeck());
                }
            }
            if (player.getHand().size() >= 3) {
                while (dealer.calculate() <= 15) {
                    dealer.hit(dealer.getDeck());
                }
            }

    

            //print dealer's hand
            System.out.println("\n----------------------");
            System.out.println("Dealer hand:");
            System.out.println(dealer.toString());
            System.out.println("----------------------");
    }
            
    //reset game
    public void reset(){
            if(player.getAmount()>0){
            Scanner sc;
            System.out.println("Would you like to play again? Yes (y) or No (n)");
            sc = new Scanner(System.in);
            if (sc.nextLine().equalsIgnoreCase("n")) {
                System.out.println("Goodbye!");
                player.setAmount(0);
            } else {
                System.out.println("\nNew round!!!");
            }
        }
            else{
                System.out.println("You have no money!!! Goodbye!");
                
            }
    }
    
    //validate black jack
    public boolean blackJack(Player player){
        boolean blackJack = false;
        if(player.getHand().size()==2 && player.getHand().getCard(0).getValue().name().equalsIgnoreCase("ace") 
           && player.getHand().getCard(1).getValue().name().equalsIgnoreCase("ace")){
           blackJack = true; 
        }
        return blackJack;
    }
    
    //validate lucky 5
    public boolean luckyFive(Player player) {
        boolean luckyFive = false;
        if (player.getHand().size() == 5 && player.calculate()<=21) {
            luckyFive = true;
        }
        return luckyFive;
    }    
    
    //declare winners
    public void declareWinner(double bet) {
        //decide who wins
        if(blackJack(player)==true && blackJack(dealer)==true){
            System.out.println("It's a draw!!!");
            System.out.println("Current money amount: " + player.getAmount() + "\n");
        }
        if(blackJack(player)==true && blackJack(dealer)==false){
            System.out.println("You won double!!! Black Jack double the bet!!!");
            player.addAmount(bet*2);
            System.out.println("Current money amount: " + player.getAmount() + "\n");
        }
        if(blackJack(player)==false && blackJack(dealer)==true){
            System.out.println("You Lost double!!! Black Jack double the bet!!!");
            player.removeAmount(bet*2);
            System.out.println("Current money amount: " + player.getAmount() + "\n");
        }
            else{
                if(luckyFive(player)==true && luckyFive(dealer)==true){
                    System.out.println("It's a draw!!!");
                    System.out.println("Current money amount: " + player.getAmount() + "\n");             
                }
                if(luckyFive(player)==true && luckyFive(dealer)==false){
                    System.out.println("You won double!!! Lucky Five double the bet!!!");
                    player.addAmount(bet * 2);
                    System.out.println("Current money amount: " + player.getAmount() + "\n");
                }
                if(luckyFive(player)==false && luckyFive(dealer)==true){
                    System.out.println("You lost double!!! Lucky Five double the bet!!!");
                    player.removeAmount(bet * 2);
                    System.out.println("Current money amount: " + player.getAmount() + "\n");
                }
                    if (dealer.calculate() == player.calculate() || (dealer.calculate() > 21 && player.calculate() > 21) || (dealer.calculate() > 21 && player.calculate() < 15)) {
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
                    if (dealer.calculate() <= 21 && (player.calculate() > 21 || player.calculate() < 15)) {
                        System.out.println("You lost!!!");
                        player.removeAmount(bet);
                        System.out.println("Current money amount: " + player.getAmount() + "\n");
                    }
        }
    }
}
