import org.example.snap.CardGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardGameTest {
    private CardGame cardGame;

    @BeforeEach
    void setup() {
        cardGame = new CardGame("ahmed");
    }

    @Test
    @DisplayName("Test populateDeck() should create a deck with 52 cards")
    void populateDeck_CreatesFullDeck_DeckSizeIs52() {
        assertEquals(52, cardGame.deckOfCards.size());
    }

    @Test
    @DisplayName("Test getDeck describes every card in the deck")
    void getDeck_DisplaysCorrectInformation() {
        cardGame.getDeck();
    }
    @Test
    @DisplayName("returns a different card depending on how many time dealCard has been called")
    void dealCard_returnsCorrectCard(){
        assertEquals("hearts", cardGame.dealCard().getSuit());
        assertEquals(3, cardGame.dealCard().getValue());
        cardGame.dealCard();
        cardGame.dealCard();
        cardGame.dealCard();
        assertEquals(7,cardGame.dealCard().getValue());
    }

    @Test
    @DisplayName("returns null when deck is empty")
    void dealCard_dealEveryCard_returnsNull(){
        for(int i = 0; i <= 52 ; i++){
            cardGame.dealCard();
        }
        assertNull(cardGame.dealCard());
    }
    @Test
    @DisplayName("sort the deck by value of cards")
    void sortDeckInNumberOrder_sortEveryCardByValue_returnDeckOfCards(){
        cardGame.sortDeckInNumberOrder();
        cardGame.getDeck();
        assertEquals(2,cardGame.dealCard().getValue());
        cardGame.dealCard();
        cardGame.dealCard();
        cardGame.dealCard();
        assertEquals(3,cardGame.dealCard().getValue());
        cardGame.dealCard();
        cardGame.dealCard();
        cardGame.dealCard();
        assertEquals(4,cardGame.dealCard().getValue());
    }
    @Test
    @DisplayName("sort the deck by value of cards and suit")
    void sortDeckIntoSuits_sortEveryCardBySuitThenValue_returnDeckOfCards(){
        cardGame.sortDeckIntoSuits();
        cardGame.getDeck();
        assertEquals(2,cardGame.dealCard().getValue());
        assertEquals("clubs",cardGame.dealCard().getSuit());
        cardGame.dealCard();
        cardGame.dealCard();
        cardGame.dealCard();
        assertEquals(7,cardGame.dealCard().getValue());
        assertEquals("clubs",cardGame.dealCard().getSuit());
        cardGame.dealCard();
        cardGame.dealCard();
        cardGame.dealCard();
        assertEquals(12,cardGame.dealCard().getValue());
        assertEquals("clubs",cardGame.dealCard().getSuit());
    }
    @Test
    @DisplayName("sort the deck by value of cards")
    void shuffleDeck_randomCardOrder_returnDeckOfCards(){
        cardGame.shuffleDeck();
        cardGame.getDeck();
    }
}
