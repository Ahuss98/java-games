package HangmanTests;

import org.example.hangman.DisplayGuess;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DisplayGuessTests {
    private DisplayGuess displayGuess;

    @BeforeEach
    void setUp() {
        displayGuess = new DisplayGuess("apple");
    }

    @Test
    @DisplayName("Test Constructor: Ensure correct word is set")
    void testConstructor_withWordApple_returnsTrue() {
        assertEquals("apple", displayGuess.getCurrentWord());
    }

    @Test
    @DisplayName("Test arrayFiller: Ensure wordArr is filled with underscores")
    void testArrayFiller_returnsAnEmptyArrayOfUnderscores() {
        String[] expected = {"_ ", "_ ", "_ ", "_ ", "_ "};
        assertArrayEquals(expected, displayGuess.wordArr);
    }

    @Test
    @DisplayName("Test guessLetterCheck: Correct guess should return true")
    void testCorrectGuess_guessingLetterA_returnsTrue() {
        assertTrue(displayGuess.guessLetterCheck("a"));
        assertTrue(displayGuess.correctLetterGuess.contains("a"));
    }

    @Test
    @DisplayName("Test guessLetterCheck: Incorrect guess should return false")
    void testIncorrectGuess_guessingLetterZ_returnsFalse() {
        assertFalse(displayGuess.guessLetterCheck("z"));
        assertTrue(displayGuess.allGuesses.contains("z"));
    }


    @Test
    @DisplayName("Test guessLetterCheck: Invalid input should throw exception")
    void testInvalidGuess_withGuessesThatDontMatchValidator_throwsException() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> displayGuess.guessLetterCheck("")),
                () -> assertThrows(IllegalArgumentException.class, () -> displayGuess.guessLetterCheck(null)),
                () -> assertThrows(IllegalArgumentException.class, () -> displayGuess.guessLetterCheck("ab"))
        );
    }

    @Test
    @DisplayName("Test displayWordLength: Word array updates correctly")
    void testDisplayWordLength_guessingP_fillsArrayAtCorrectIndexes() {
        displayGuess.guessLetterCheck("p");
        displayGuess.displayWordLength();
        assertAll(
                () -> assertEquals("p", displayGuess.wordArr[1]),
                () -> assertEquals("p", displayGuess.wordArr[2]),
                () -> assertEquals("_ ", displayGuess.wordArr[3])
        );
    }

    @Test
    @DisplayName("Test GetNewWord: Ensure new word is selected")
    void testGetNewWord() {
        displayGuess.GetNewWord();
        assertNotNull(displayGuess.getCurrentWord());
    }

}
