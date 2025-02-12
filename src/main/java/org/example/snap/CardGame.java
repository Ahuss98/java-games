package org.example.snap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class CardGame {

    public ArrayList<Card> deckOfCards;
    public String name;
    public String name2;

    public CardGame(String name){
        this.name = name;
        this.deckOfCards = new ArrayList<>();
        populateDeck();

    }

    public CardGame(String name, String name2){
        this.name = name;
        this.name2 = name2;
        this.deckOfCards = new ArrayList<>();
        populateDeck();
    }

    public void populateDeck(){
        String[] validSuits = {"hearts","diamonds","spades","clubs"};
        for(int i = 0; i <4 ; i++){
            for(int j = 2; j <= 14 ; j++){
                deckOfCards.add(new Card(validSuits[i], j));
            }
        }
    }

    public void getDeck(){
        for(Card card:deckOfCards){
            System.out.println(card.toString());
        }
    }
}
