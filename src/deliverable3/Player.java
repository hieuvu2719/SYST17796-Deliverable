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
public class Player {

    private Hand hand;
    private double moneyAmount;
    private double bet;

    public Player() {
    }

    public Player(Hand hand, double moneyAmount, double bet) {
        this.bet = bet;
        this.hand = hand;
        this.moneyAmount = moneyAmount;
    }

    /**
     *
     * @return the bet
     */
    public double getBet() {
        return bet;
    }

    /**
     *
     * @param bet the bet to set
     */
    public void setBet(double bet) {
        this.bet = bet;
    }

    /**
     *
     * @return the hand
     */
    public Hand getHand() {
        return hand;
    }

    /**
     *
     * @param hand the hand to set
     */
    public void setHand(Hand hand) {
        this.hand = hand;
    }

    //draw a card from deck
    public void hit(Deck deck) {
        hand.addCard(deck);
    }

    //calculate toatal value of hand
    public int calculate() {
        return hand.calculate();
    }

    /**
     *
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        moneyAmount = amount;
    }

    /**
     *
     * @return the moneyAmount
     */
    public double getAmount() {
        return moneyAmount;
    }

    //remove money from user's fund
    public void removeAmount(double amount) {
        moneyAmount -= amount;
    }

    //add money to user's fund
    public void addAmount(double amount) {
        moneyAmount += amount;
    }

    @Override
    public String toString() {
        return hand.toString() + "\nTotal Value: " + this.hand.calculate();
    }
}
