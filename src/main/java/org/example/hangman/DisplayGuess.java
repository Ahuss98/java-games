package org.example.hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class DisplayGuess {
    Scanner scanner = new Scanner(System.in);

    public String getCurrentWord() {
        return currentWord;
    }

    String currentWord;
    ArrayList<String> guessedLetter;

    public DisplayGuess(String word){
        this.currentWord = word;
        this.guessedLetter = new ArrayList<>();
    }

    public void displayWordLength(){
        System.out.println(currentWord);
        for(int i = 0; i < currentWord.length(); i++){
            boolean hasDisplayedCharechter = false;

            if(!hasDisplayedCharechter){
            for(String letter: guessedLetter){
                if(String.valueOf(currentWord.charAt(i)).equals(letter)){
                    System.out.print(letter + " ");
                    hasDisplayedCharechter = true;
                }
            }
            }
            if(!hasDisplayedCharechter){
                System.out.print("_ ");
                hasDisplayedCharechter = false;
            }
        }
    }

    public void GetNewWord(){
        currentWord = Words.selectRandomWord();
    }

    public boolean guessLetterCheck(String guess){
        if(currentWord.contains(guess)){
            guessedLetter.add(guess);
            return currentWord.contains(guess);
        }
        return currentWord.contains(guess);
    }
}
