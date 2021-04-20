/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverable3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author hieud
 */
public class AsianBlackJackTest {
    
    public AsianBlackJackTest() {
    }

    @Test
    public void testDeal() {
    }

    @Test
    public void testDeclareWinner() {
        Player player = new Player();
        Dealer dealer = new Dealer();
        Card card1 = new Card(Value.SEVEN, Suit.HEARTS);
        Card card2 = new Card(Value.TEN, Suit.SPADES);
        Card card3 = new Card(Value.KING, Suit.HEARTS);
        Card card4 = new Card(Value.QUEEN, Suit.DIAMONDS);
        player.setHand(new Hand());
        player.getHand().getHand().add(card1);
        player.getHand().getHand().add(card2);
        dealer.getHand().getHand().add(card3);
        dealer.getHand().getHand().add(card4);
        player.setAmount(1000);
        double bet = 100;
        double expResult = 900;
        AsianBlackJack game = new AsianBlackJack(player, dealer); 
        game.declareWinner(100);
        assertEquals(expResult,player.getAmount());
        
    }
    
}
