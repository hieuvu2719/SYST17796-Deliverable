/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverable3;

/**
 *
 * @author hieud
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //create new player and dealer
        Player player = new Player();
        Dealer dealer = new Dealer();

        //create new game
        AsianBlackJack game = new AsianBlackJack(player, dealer);
        game.intro(System.in);
        game.setMoneyAmount(System.in);
        while (player.getAmount() > 0) {
            game.bet(System.in);
            game.deal();
            game.hit(System.in);
            game.declareWinner(player.getBet());
            game.reset(System.in);
        }

    }

}
