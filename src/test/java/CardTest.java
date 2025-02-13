import org.example.snap.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {
    private Card suitSymbolCard;
    private Card suitValueCard;

    @BeforeEach
    void setup() {
        suitSymbolCard = new Card("diamonds", "K");
        suitValueCard = new Card("diamonds", 12);
    }

    @Test
    @DisplayName("Test constructor with  suit, symbol")
    void constructor_WithSymbol_InitializesCorrectly() {
        assertAll(
                () -> assertEquals("diamonds", suitSymbolCard.getSuit()),
                () -> assertEquals("K", suitSymbolCard.getSymbol()),
                () -> assertEquals(13, suitSymbolCard.getValue())
        );
    }

    @Test
    @DisplayName("Test constructor with suit, value")
    void constructor_WithValue_InitializesCorrectly() {
        assertAll(
                () -> assertEquals("diamonds", suitValueCard.getSuit()),
                () -> assertEquals("Q", suitValueCard.getSymbol()),
                () -> assertEquals(12, suitValueCard.getValue())
        );
    }

    @Test
    @DisplayName("Test if symbol is reassigned with valid input")
    void setSymbolIfValid_ValidInput_ReassignsSymbol() {
        suitSymbolCard.setSymbolIfValid("4");
        assertEquals("4", suitSymbolCard.getSymbol());
    }

    @Test
    @DisplayName("Test invalid symbol input should not change symbol")
    void setSymbolIfValid_InvalidInput_DoesNotReassignSymbol() {
        String originalSymbol = suitSymbolCard.getSymbol();
        suitSymbolCard.setSymbolIfValid("Z");
        assertEquals(originalSymbol, suitSymbolCard.getSymbol());
    }

    @Test
    @DisplayName("Test findValueOfSymbol method for correct value")
    void findValueOfSymbol_ValidInput_ReturnsCorrectValue() {
        assertAll(
                () -> assertEquals(4, suitSymbolCard.findValueOfSymbol("4")),
                () -> assertEquals(11, suitSymbolCard.findValueOfSymbol("J")),
                () -> assertEquals(12, suitSymbolCard.findValueOfSymbol("Q")),
                () -> assertEquals(13, suitSymbolCard.findValueOfSymbol("K")),
                () -> assertEquals(14, suitSymbolCard.findValueOfSymbol("A"))
        );
    }

    @Test
    @DisplayName("Test findValueOfSymbol method for invalid input")
    void findValueOfSymbol_InvalidInput_ReturnsPlaceholder() {
        assertEquals(999, suitSymbolCard.findValueOfSymbol("Z"));
    }

    @Test
    @DisplayName("Test findSymbolOfValue method for correct symbol")
    void findSymbolOfValue_ValidInput_ReturnsCorrectSymbol() {
        assertAll(
                () -> assertEquals("J", suitSymbolCard.findSymbolOfValue(11)),
                () -> assertEquals("Q", suitSymbolCard.findSymbolOfValue(12)),
                () -> assertEquals("K", suitSymbolCard.findSymbolOfValue(13)),
                () -> assertEquals("A", suitSymbolCard.findSymbolOfValue(14))
        );
    }

    @Test
    @DisplayName("Test findSymbolOfValue method for invalid input")
    void findSymbolOfValue_InvalidInput_ReturnsNumber() {
        assertEquals("7", suitSymbolCard.findSymbolOfValue(7));
    }

    @Test
    @DisplayName("Test describeClass outputs expected string")
    void describeClass_DisplaysCorrectInformation() {
        System.out.println(suitSymbolCard.toString());
        System.out.println(suitValueCard.toString());
    }
}
