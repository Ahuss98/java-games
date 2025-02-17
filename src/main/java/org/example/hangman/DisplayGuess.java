package org.example.hangman;

import java.util.ArrayList;
import java.util.Arrays;

public class DisplayGuess {
    String currentWord;
    public ArrayList<String> correctLetterGuess;
    public ArrayList<String> allGuesses;
    public String[] wordArr;

    public String getCurrentWord() {
        return currentWord;
    }

    public DisplayGuess(String word) {
        this.currentWord = word;
        this.correctLetterGuess = new ArrayList<>();
        this.allGuesses = new ArrayList<>();
        wordArr = new String[currentWord.length()];
        arrayFiller();
    }

    public void arrayFiller() {
        Arrays.fill(wordArr, 0, currentWord.length(), "_ ");
    }

    public void displayWordLength() {
        for (int i = 0; i < currentWord.length(); i++) {
            String currentLetter = String.valueOf(currentWord.charAt(i));

            if (correctLetterGuess.contains(currentLetter)) {
                wordArr[i] = currentLetter;
            }
        }

        allGuesses.addAll(correctLetterGuess);
        System.out.println(Arrays.toString(wordArr));
    }

    public void GetNewWord() {
        currentWord = Words.selectRandomWord();
    }

    public boolean guessLetterCheck(String guess) {
        if (guess == null || guess.length() != 1) {
            throw new IllegalArgumentException("Invalid guess! Please enter a single letter.");
        }
        if (currentWord.contains(guess) && !allGuesses.contains(guess)) {
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
