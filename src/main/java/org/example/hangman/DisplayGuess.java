package org.example.hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DisplayGuess {
    Scanner scanner = new Scanner(System.in);
    String currentWord;
    ArrayList<String> correctLetterGuess;
    ArrayList<String> allGuesses;
    String[] wordArr;

    public String getCurrentWord() {
        return currentWord;
    }

    public DisplayGuess(String word){
        this.currentWord = word;
        this.correctLetterGuess = new ArrayList<>();
        this.allGuesses = new ArrayList<>();
        wordArr = new String[currentWord.length()];
        arrayFiller();
    }

    public void arrayFiller(){
        Arrays.fill(wordArr, 0, currentWord.length(), "_ ");
    }

    public void displayWordLength(){
        System.out.println(currentWord);


        for (int i = 0; i < currentWord.length(); i++) {
            String currentLetter = String.valueOf(currentWord.charAt(i));

            if (correctLetterGuess.contains(currentLetter)) {
                wordArr[i] = currentLetter;
            }
        }

        allGuesses.addAll(correctLetterGuess);
        System.out.println(Arrays.toString(wordArr));
    }

    public void GetNewWord(){
        currentWord = Words.selectRandomWord();
    }

    public boolean guessLetterCheck(String guess){
        if(currentWord.contains(guess) && !allGuesses.contains(guess)){
            correctLetterGuess.add(guess);
            return currentWord.contains(guess);
        } else if (!allGuesses.contains(guess)) {
            allGuesses.add(guess);
            return currentWord.contains(guess);
        }
        System.out.println("cant guess same letter again");
        return false;
    }
}
