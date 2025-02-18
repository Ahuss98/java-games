package org.example.hangman;

import org.example.GameMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HangmanMenu {
    String currentWord;
    public DisplayGuess newHangman;
    int incorrectGuesses;
    int correctGuesses;
    Scanner scanner = new Scanner(System.in);

    public HangmanMenu() {
        playGame();
    }

    public void playGame() {
        currentWord = Words.selectRandomWord();
        newHangman = new DisplayGuess(currentWord);
        incorrectGuesses = 0;
        correctGuesses = 0;
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
                    System.out.println("✅correct!");
                    correctGuesses++;
                } else {
                    System.out.println("❌incorrect!");
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
            System.out.println("🎉congratulations you win!!");
            playAgain();
        }
        if (incorrectGuesses >= 5) {
            displayHangman(incorrectGuesses);
            System.out.println("😓you lose!!");
            playAgain();
        }

    }

    public void playAgain() {
        while (true) {
            System.out.println("Type: \n 1.Play again \n 2.Select new players and a new game \n 3.Exit");
            try {
                int input = scanner.nextInt();
                if (input == 1) {
                    currentWord = Words.selectRandomWord();
                    playGame();
                    break;
                } else if (input == 2) {
                    GameMenu newGameMenu = new GameMenu();
                    break;
                } else if (input == 3) {
                    System.out.println("Thanks for playing");
                    break;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("please select a number between 1-3");
                scanner.nextLine();
            }
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

