package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.*; //anything in this package should be included here, let them talk
import models.DeckOfCards;

import java.io.IOException;
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

    @FXML
    private ImageView imageView;

    private DeckOfCards deckOfCards; //inside of the class but outside of the method


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { //this is like in the main method where we
        //extended the application class and we were forced to have the method Start
        deckOfCards = new DeckOfCards();
        deckOfCards.shuffle(); //shuffles the deck so a random card will show
        getNextCard(); //our initial method instantiates a deck of cards then deals the top card
    }

    @FXML
    private void getNextCard(){ //anytime we push the button we can get the next card
        Card card = deckOfCards.dealTopCard(); //this will take the first card at the  top of the deck and place it into card
        faceNameLabel.setText(card.getFaceName()); //the card object will give us back the faceName and update the label
        suitLabel.setText(card.getSuit());
        faceValueLabel.setText(Integer.toString(card.getFaceValue())); //using the  int wrapper class to convert int to String
        imageView.setImage(card.getCardImage());
    }

    @FXML
    private void changeToHandOfCards(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/handOfCardsView.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();//this line gets the Stage information

        stage.setScene(scene);
        stage.setTitle("Your Hand of Cards");
        stage.show();

    }


}
