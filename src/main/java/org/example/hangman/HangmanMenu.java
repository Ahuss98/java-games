package org.example.hangman;

import java.util.Scanner;

public class HangmanMenu {
    String currentWord;
    public DisplayGuess newHangman;
    public String guess;
    int incorrectGuesses;
    int correctGuesses;
    Scanner scanner = new Scanner(System.in);

    public HangmanMenu() {
        playGame();
    }

    public void playGame() {
        currentWord = Words.selectRandomWord();
        newHangman = new DisplayGuess(currentWord);
        System.out.println("🔥 Welcome to Hangman! Press type a letter to guess. Type 'exit' to quit.");
        while (incorrectGuesses < 5 && correctGuesses < currentWord.length()) {
            newHangman.displayWordLength();
            System.out.println("guess a letter");
            System.out.println("incorrect guesses: " + incorrectGuesses + " /  " + 5);
            displayHangman(incorrectGuesses);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("exit")) {
                System.out.println("Thanks for playing");
                break;
            }
            try {
                if (newHangman.guessLetterCheck(input)) {
                    System.out.println("correct!");
                    correctGuesses++;
                } else {
                    System.out.println("incorrect!");
                    incorrectGuesses++;
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        winLosschecker();
    }

    public void winLosschecker() {
        if (correctGuesses >= currentWord.length()) {
            System.out.println("congratulations you win!!");
        }
        if (incorrectGuesses >= 5) {
            displayHangman(incorrectGuesses);
            System.out.println("you lose!!");
        }

    }

    public void displayHangman(int stage) {
        String[] hangmanStages = {
                """
                   
                   
                   
                   
                   
                   ___|___
                """,
                """
                   
                   |
                   |
                   |
                   |
                   |
                   ___|___
                """,
                """
                   _______
                   |
                   |
                   |
                   |
                   |
                   ___|___
                """,
                """
                   _______
                   |/     |
                   |     (_)
                   |
                   |
                   |
                   ___|___
                """,
                """
                   _______
                   |/     |
                   |     (_)
                   |     \\|/
                   |      
                   |
                   ___|___
                """,
                """
                   _______
                   |/     |
                   |     (_)
                   |     \\|/
                   |      |
                   |     / \\
                   ___|___
                """
        };
        System.out.println(hangmanStages[stage]);
    }
}

