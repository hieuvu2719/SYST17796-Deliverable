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
        game.intro();
        game.setMoneyAmount();
        while (player.getAmount() > 0) {
            game.bet();
            game.deal();
            game.hit();
            game.declareWinner(player.getBet());
            game.reset();
        }

    }

}
