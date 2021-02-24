package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    private ArrayList<Card> deck;

    /**
    * The constructor will create the instance of the DeckOfCards
    * class and intialize it with all the Card objects
    * */
    public DeckOfCards(){
        deck = new ArrayList<>();
        //get lists of valid suits and face names
        List<String> suits = Card.getSuits();
        List<String> faceNames = Card.getFaceNames();
        //loop over all the suits and names to create Card objects
        for(String suit : suits){
            for (int i = 0; i < ((List<?>) faceNames).size(); i++) {
                Card card = new Card(faceNames.get(i), suit, i+2);
                deck.add(card);
            }
        }
    }

    /**
     *  This method returns the number of cards in the deck
     */

    public int getNumOfCardsInDeck(){
        return deck.size();
    }

    /**
     * This method will return the top card from the deck. If the desk is empty
     * it will return null
     */
    public Card dealTopCard(){
        if(deck.size() > 0)
            return deck.remove(0);
        return null;
    }

    /**
     * This method will shuffle the deck
     */
    public void shuffle(){
        Collections.shuffle(deck);
    }
}
