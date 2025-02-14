package org.example.hangman;

import java.util.Scanner;

public class HangmanMenu {
    String currentWord;
    public DisplayGuess newHangman;
    public String guess;
    int incorrectGuesses ;
    int correctGuesses;
    Scanner scanner = new Scanner(System.in);

    public HangmanMenu(){
        currentWord = Words.selectRandomWord();
        newHangman = new DisplayGuess(currentWord);
        playGame();
    }

    public void playGame(){
        while(incorrectGuesses< currentWord.length() || correctGuesses < currentWord.length()){
            newHangman.displayWordLength();
            System.out.println("guess a letter");
            String input = scanner.nextLine();
            if(newHangman.guessLetterCheck(input)){
                System.out.println("correct!");
                correctGuesses ++;
            } else {
                System.out.println("incorrect!");
                incorrectGuesses++;
            }
//            newHangman.displayWordLength();
        }
    }

}
