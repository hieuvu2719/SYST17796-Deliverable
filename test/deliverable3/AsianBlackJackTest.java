/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverable3;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author hieud
 */
public class AsianBlackJackTest {

    public AsianBlackJackTest() {
    }

    //test method blackJack() good
    @Test
    public void testBlackJackGood() {
        Player player = new Player();
        Dealer dealer = new Dealer();
        AsianBlackJack game = new AsianBlackJack(player, dealer);
        Hand hand = new Hand();
        player.setHand(hand);
        player.getHand().getHand().add(new Card(Value.ACE, Suit.HEARTS));
        player.getHand().getHand().add(new Card(Value.ACE, Suit.DIAMONDS));
        boolean expResult = true;
        boolean result = game.blackJack(player);
        assertEquals(expResult, result);
    }

    //test method blackJack() bad
    @Test
    public void testBlackJackBad() {
        Player player = new Player();
        Dealer dealer = new Dealer();
        AsianBlackJack game = new AsianBlackJack(player, dealer);
        Hand hand = new Hand();
        player.setHand(hand);
        player.getHand().getHand().add(new Card(Value.ACE, Suit.HEARTS));
        player.getHand().getHand().add(new Card(Value.TWO, Suit.CLUBS));
        boolean expResult = false;
        boolean result = game.blackJack(player);
        assertEquals(expResult, result);
    }

    //test method blackJack() boundary
    @Test
    public void testBlackJackBoundary() {
        Player player = new Player();
        Dealer dealer = new Dealer();
        AsianBlackJack game = new AsianBlackJack(player, dealer);
        Hand hand = new Hand();
        player.setHand(hand);
        player.getHand().getHand().add(new Card(Value.ACE, Suit.HEARTS));
        player.getHand().getHand().add(new Card(Value.ACE, Suit.CLUBS));
        boolean expResult = true;
        boolean result = game.blackJack(player);
        assertEquals(expResult, result);
    }

    //test method luckyFive() good
    @Test
    public void testLuckyFiveGood() {
        Player player = new Player();
        Dealer dealer = new Dealer();
        AsianBlackJack game = new AsianBlackJack(player, dealer);
        Hand hand = new Hand();
        player.setHand(hand);
        player.getHand().getHand().add(new Card(Value.TWO, Suit.HEARTS));
        player.getHand().getHand().add(new Card(Value.THREE, Suit.CLUBS));
        player.getHand().getHand().add(new Card(Value.FOUR, Suit.HEARTS));
        player.getHand().getHand().add(new Card(Value.TWO, Suit.CLUBS));
        player.getHand().getHand().add(new Card(Value.TWO, Suit.SPADES));
        boolean expResult = true;
        boolean result = game.luckyFive(player);
        assertEquals(expResult, result);
    }

    //test method luckyFive() good
    @Test
    public void testLuckyFiveBoundary() {
        Player player = new Player();
        Dealer dealer = new Dealer();
        AsianBlackJack game = new AsianBlackJack(player, dealer);
        Hand hand = new Hand();
        player.setHand(hand);
        player.getHand().getHand().add(new Card(Value.TEN, Suit.HEARTS));
        player.getHand().getHand().add(new Card(Value.THREE, Suit.CLUBS));
        player.getHand().getHand().add(new Card(Value.FOUR, Suit.HEARTS));
        player.getHand().getHand().add(new Card(Value.TWO, Suit.CLUBS));
        player.getHand().getHand().add(new Card(Value.TWO, Suit.SPADES));
        boolean expResult = true;
        boolean result = game.luckyFive(player);
        assertEquals(expResult, result);
    }

    //test method luckyFive() boundary
    @Test
    public void testLuckyFiveBad() {
        Player player = new Player();
        Dealer dealer = new Dealer();
        AsianBlackJack game = new AsianBlackJack(player, dealer);
        Hand hand = new Hand();
        player.setHand(hand);
        player.getHand().getHand().add(new Card(Value.JACK, Suit.HEARTS));
        player.getHand().getHand().add(new Card(Value.TEN, Suit.CLUBS));
        player.getHand().getHand().add(new Card(Value.FOUR, Suit.HEARTS));
        player.getHand().getHand().add(new Card(Value.TWO, Suit.CLUBS));
        player.getHand().getHand().add(new Card(Value.TWO, Suit.SPADES));
        boolean expResult = false;
        boolean result = game.luckyFive(player);
        assertEquals(expResult, result);
    }

    //test method reset()
    @Test
    public void testReset() {
        String input = "n";
        InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        Player player = new Player();
        Dealer dealer = new Dealer();
        AsianBlackJack game = new AsianBlackJack(player, dealer);
        game.reset(stream);
        double expResult = 0;
        double result = player.getAmount();
        assertEquals(expResult, result, 0.001);

    }

    //test method deal()
    @Test
    public void testDeal() {
        Player player = new Player();
        Dealer dealer = new Dealer();
        player.setHand(new Hand());
        dealer.setHand(new Hand());
        AsianBlackJack game = new AsianBlackJack(player, dealer);
        game.deal();
        int expResult = 2;
        int result = player.getHand().size();
        assertEquals(expResult, result);

    }

    // test method declareWinner()
    @Test
    public void testDeclareWinner() {
        Player player = new Player();
        Dealer dealer = new Dealer();
        AsianBlackJack game = new AsianBlackJack(player, dealer);
        player.setBet(50);
        player.setAmount(1000);
        player.setHand(new Hand());
        player.getHand().getHand().add(new Card(Value.ACE, Suit.HEARTS));
        player.getHand().getHand().add(new Card(Value.ACE, Suit.DIAMONDS));
        dealer.setHand(new Hand());
        dealer.getHand().getHand().add(new Card(Value.TEN, Suit.HEARTS));
        dealer.getHand().getHand().add(new Card(Value.QUEEN, Suit.DIAMONDS));
        game.declareWinner(50);
        double expResult = 1100;
        double result = player.getAmount();
        assertEquals(expResult, result, 0.001);
    }

}
