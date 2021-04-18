/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverable3;

import java.util.ArrayList;

/**
 *
 * @author hieud
 */
public class Deck {

    private ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
    }

    
    //create a deck of 52 cards
    public void createDeck() {
        for (Suit cardSuit : Suit.values()) {
            for (Value cardValue : Value.values()) {
                deck.add(new Card(cardValue, cardSuit));
            }
        }
    }
    
    //shuffle the deck
    public void shuffle() {
        ArrayList<Card> shuffledDeck = new ArrayList<>();
        int j = 0;
        int size = deck.size();
        for (int i = 0; i < size; i++) {
            j = (int) (Math.random() * deck.size());
            shuffledDeck.add(deck.get(j));
            deck.remove(j);
        }
        this.deck = shuffledDeck;
    }

    //remove card from deck
    public void remove(int i) {
        deck.remove(i);
    }
    
    //get card from deck
    public Card get(int i) {
        return deck.get(i);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < deck.size(); i++) {
            result += deck.get(i).toString() + "\n";
        }
        return result;
    }

}
