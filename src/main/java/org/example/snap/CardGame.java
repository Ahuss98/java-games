package org.example.snap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class CardGame {

    public ArrayList<Card> deckOfCards;
    Player player1 = new Player();
    Player player2 = new Player();

    public CardGame(String name){
        player1.setName(name);
        this.deckOfCards = new ArrayList<>();
        populateDeck();

    }

    public CardGame(String name, String name2){
        player1.setName(name);
        player2.setName(name2);
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

    public Card dealCard() {
        if (deckOfCards.isEmpty()) {
            System.out.println("No cards left in the deck!");
            return null;
        }
        return deckOfCards.removeFirst();
    }
    public ArrayList<Card> sortDeckInNumberOrder() {
        deckOfCards.sort(Comparator.comparing(Card::getValue));
        return deckOfCards;
    }
    public ArrayList<Card> sortDeckIntoSuits(){
        deckOfCards.sort(Comparator.comparing(Card::getSuit).thenComparing(Card::getValue));
        return deckOfCards;
    }
    public ArrayList<Card> shuffleDeck(){
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }
}
