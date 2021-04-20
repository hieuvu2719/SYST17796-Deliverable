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
    
    //test method blackJack()
    @Test
    public void testBlackJack(){
        Player player = new Player();
        Dealer dealer = new Dealer();
        AsianBlackJack game = new AsianBlackJack(player, dealer);
        Hand hand = new Hand();
        player.setHand(hand);
        player.getHand().getHand().add(new Card(Value.ACE,Suit.HEARTS));
        player.getHand().getHand().add(new Card(Value.ACE,Suit.CLUBS));
        boolean expResult = true;
        boolean result = game.blackJack(player);
        assertEquals(expResult, result);
    }
    
    //test method luckyFive()
        @Test
        public void testLuckyFive(){
        Player player = new Player();
        Dealer dealer = new Dealer();
        AsianBlackJack game = new AsianBlackJack(player, dealer);
        Hand hand = new Hand();
        player.setHand(hand);
        player.getHand().getHand().add(new Card(Value.TWO,Suit.HEARTS));
        player.getHand().getHand().add(new Card(Value.THREE,Suit.CLUBS));
        player.getHand().getHand().add(new Card(Value.FOUR,Suit.HEARTS));
        player.getHand().getHand().add(new Card(Value.TWO,Suit.CLUBS));
        player.getHand().getHand().add(new Card(Value.TWO,Suit.SPADES));
        boolean expResult = true;
        boolean result = game.luckyFive(player);
        assertEquals(expResult, result);
    }
}
