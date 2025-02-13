package org.example.hangman;

public class DisplayGuess {
    String currentWord = Words.selectRandomWord();

    public void displayWordLength(){
        for(int i = 0; i < currentWord.length(); i++){
            System.out.print("_ ");
        }

    }
}
