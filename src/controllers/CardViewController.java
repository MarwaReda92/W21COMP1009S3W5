package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import models.*; //anything in this package should be included here, let them talk
import models.DeckOfCards;

import java.net.URL;
import java.util.ResourceBundle;

public class CardViewController implements Initializable { //initializable being implemented means not only are we
    // creating a cardview controller class, we are also creating an instance of the initializable interface which
    // means anythign that an initializable object can do, we can do

    @FXML //is telling the java class that it can interact with the  item in the view
    private Label faceNameLabel;

    @FXML
    private Label suitLabel;

    @FXML
    private Label faceValueLabel;

    private DeckOfCards deckOfCards; //inside of the class but outside of the method


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { //this is like in the main method where we
        //extended the application class and we were forced to have the method Start
        deckOfCards = new DeckOfCards();
        Card card = deckOfCards.dealTopCard(); //this will take the first card at the  top of the deck and place it into card
        faceNameLabel.setText(card.getFaceName()); //the card object will give us back the faceName and update the label
        suitLabel.setText(card.getSuit());
        faceValueLabel.setText(Integer.toString(card.getFaceValue())); //using the  int wrapper class to convert int to String
    }
}
