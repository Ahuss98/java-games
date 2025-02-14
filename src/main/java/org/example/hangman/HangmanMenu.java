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
        while(incorrectGuesses < 5 || correctGuesses < currentWord.length()){
            newHangman.displayWordLength();
            System.out.println("guess a letter");
            System.out.println("correct guesses: " +  correctGuesses + "out of: " + currentWord.length());
            System.out.println("incorrect guesses: " + incorrectGuesses);
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
