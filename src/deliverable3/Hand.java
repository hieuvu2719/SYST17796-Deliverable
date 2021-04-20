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
public class Hand {

    private ArrayList<Card> hand = new ArrayList<>();
    public Hand(){}
    

    //add card from the deck to hand
    public void addCard(Deck deck) {
        hand.add(deck.get(0));
        deck.remove(0);
    }
    
    /**
     *
     * @param i
     * @return card from hand
     */
    public Card getCard(int i) {
        return hand.get(i);
    }
    
    /**
     *
     * @return the hand
     */
    public ArrayList<Card> getHand(){
        return hand;
    }
    
    //return just drawn card from hand
    public Card getNewDrawnCard() {
        return hand.get(hand.size() - 1);
    }
    
    //return number of cards on hand
    public int size() {
        return hand.size();
    }

    //calculate total value of hand
    public int calculate() {
        int totalValue = 0;
        int numAce = 0;
        for (Card card : hand) {
            switch (card.getValue()) {
                case TWO:
                    totalValue += 2;
                    break;
                case THREE:
                    totalValue += 3;
                    break;
                case FOUR:
                    totalValue += 4;
                    break;
                case FIVE:
                    totalValue += 5;
                    break;
                case SIX:
                    totalValue += 6;
                    break;
                case SEVEN:
                    totalValue += 7;
                    break;
                case EIGHT:
                    totalValue += 8;
                    break;
                case NINE:
                    totalValue += 9;
                    break;
                case TEN:
                    totalValue += 10;
                    break;
                case JACK:
                    totalValue += 10;
                    break;
                case QUEEN:
                    totalValue += 10;
                    break;
                case KING:
                    totalValue += 10;
                    break;
                case ACE:
                    numAce += 1;
                    break;
            }
        }
        for (int i = 0; i < numAce; i++) {
            if (totalValue <= 10) {
                totalValue += 11;
            } else if (totalValue == 11) {
                totalValue += 10;
            } else if (totalValue > 11) {
                totalValue += 1;
            }
        }
        return totalValue;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < hand.size(); i++) {
            result += hand.get(i).toString() + "\n";
        }
        return result;
    }

}
