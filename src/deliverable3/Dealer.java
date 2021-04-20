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
public class Dealer extends Player {
    private Deck deck;
    public Dealer() {
    }
    
    /**
     *
     * @param deck the deck to set
     */
    public void setDeck(Deck deck){
        this.deck=deck;
    }
    
    /**
     *
     * @return the deck
     */
    public Deck getDeck(){
        return deck;
    }
    
    /**
     * shuffle deck
     */
    public void shuffle(){
        deck.shuffle();
    }
    
    
    //deal cards
    public void deal(Player player, Deck deck){
        player.hit(deck);
        this.hit(deck);
        player.hit(deck);
        this.hit(deck);
    }
}
