import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import org.example.hangman.Words;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class WordsTest {
    @Test
    @DisplayName("testing if selectRandomWord return a valid word")
        void selectRandomWord_retunsValidWord(){
            String selectedWord = Words.selectRandomWord();
            assertTrue(Words.words.contains(selectedWord));


    }

}
