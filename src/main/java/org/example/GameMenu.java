package org.example;

import org.example.hangman.DisplayGuess;
import org.example.hangman.HangmanMenu;
import org.example.snap.Player;
import org.example.snap.Snap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameMenu {
    private int numbOfPlayers;
    Scanner scanner = new Scanner(System.in);
    Snap newGame;


    public GameMenu() {
        setNumbOfPlayers();
        startGameWithPlayers(numbOfPlayers);
    }

    public void setNumbOfPlayers() {
        while (true) {
            try {
                System.out.println("How many Players? 1/2");
                numbOfPlayers = scanner.nextInt();
                scanner.nextLine();

                if (numbOfPlayers == 1 || numbOfPlayers == 2) {
                    break;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter a number (1 or 2).");
                scanner.nextLine();
            }
        }
    }

    public void startGameWithPlayers(int numbOfPlayers) {
        if (numbOfPlayers == 1) {
            Player player = new Player();
            scanner.nextLine();
            System.out.println("Please enter your name");
            player.setName(scanner.nextLine());

            System.out.println("what game would you like to play? \n1.Snap \n2.Hangman");
            int selected = scanner.nextInt();
            if (selected == 1) {
                newGame = new Snap(player);
                newGame.playSnap(player);
            } else if (selected == 2) {
                HangmanMenu newGame = new HangmanMenu();
            }
        } else {
            Player player1 = new Player();
            Player player2 = new Player();
            scanner.nextLine();
            System.out.println("Please enter the name of Player1");
            player1.setName(scanner.nextLine());
            System.out.println("Please enter the name of the second Player2");
            player2.setName(scanner.nextLine());

            System.out.println("what game would you like to play? \n1.Snap \n2.Hangman");
            int selected = scanner.nextInt();
            if (selected == 1) {
                newGame = new Snap(player1, player2);
                newGame.playSnap(player1, player2);
            } else if (selected == 2) {
                HangmanMenu newGame = new HangmanMenu();
            }
        }
    }
}
