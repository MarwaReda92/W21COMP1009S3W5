package models;

import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;

public class Card {
    //Instance variables - the attributes we will model in the class
    private String faceName, suit; //face name is Ace/jack etc
    private int faceValue;
    private Image cardImage; //instance variable so each card can represent itself as an image

    /**
     * The goal of the constructor is to allocate memory for the object. When this is called it will
     * reserve space and return a "pointer" to the object.
     * <p>
     * A constructor does not have a "return" type and it must match the name of the class
     */

    public Card(String face, String suit, int faceValue) //constructor with 3 arguments
    {
        setFaceName(face);
        setSuit(suit);
        setFaceValue(faceValue);
        setCardImage();
    }

    /**
     * This method will use the face name and suit to establish the correct image to load
     */
    private void setCardImage() {
        String filePath = String.format("images/%s_of_%s.png", faceName, suit); //this string.format is like printf
        //it will place the strings from faceName and suit and pass it into the string
        //the images/ will force java to find the images in the right directory
        cardImage = new Image(filePath);
    }

    public Image getCardImage() {
        return cardImage;
    }

    public String getFaceName() {
        return faceName;
    }

    /**
     * This returns a list of all the valid face names - static so it can be used in other classes
     */
    public static List<String> getFaceNames() { //static so that it is common to the Card class, do not need an instance of the class to call this method
        return Arrays.asList("2", "3", "4", "5", "6", "7", "8",
                "9", "10", "jack", "queen", "king", "ace");
    }

    /**
     * This will ensure that the face name represents a valid face name.
     *
     * @param faceName - two, three, four,...,ten, jack, queen, king, ace
     */
    public void setFaceName(String faceName) {
        faceName = faceName.toLowerCase();

        List<String> validFaceNames = getFaceNames();
        if (validFaceNames.contains(faceName))
            this.faceName = faceName;
        else
            throw new IllegalArgumentException(faceName + " is not valid, choose from: " + validFaceNames);
    }

    public String getSuit() {
        return suit;
    }

    /**
     * This method will validate the the argument is hearts, diamonds, spades or clubs
     * and set the instance variable
     *
     * @param suit
     */
    public void setSuit(String suit) {
        suit = suit.toLowerCase();
        List<String> validSuits = getSuits();
        if (validSuits.contains(suit))
            this.suit = suit;
        else
            throw new IllegalArgumentException(suit + " is not valid, valid options are: " + validSuits);
    }

    public static List<String> getSuits() {
        return Arrays.asList("hearts", "diamonds", "spades", "clubs");
    }

    public int getFaceValue() {
        return faceValue;
    }

    /**
     * This represents the card value is between 2-14 and sets the instance variable
     *
     * @param faceValue (values 2-14)
     */
    public void setFaceValue(int faceValue) {
        if (faceValue >= 2 && faceValue <= 14)
            this.faceValue = faceValue;
        else
            throw new IllegalArgumentException("face value must be 2-14 inclusive");
    }

    public String toString() {
        return faceName + " of " + suit;
    }
}
