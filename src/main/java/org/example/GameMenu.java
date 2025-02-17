package org.example;

import org.example.hangman.HangmanMenu;
import org.example.snap.Player;
import org.example.snap.Snap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameMenu {
    private int numbOfPlayers;
    Scanner scanner = new Scanner(System.in);
    Snap newGame;
    Player player1;
    Player player2;


    public GameMenu() {
        setNumbOfPlayers();
        setPlayerNames(numbOfPlayers);
        startGameWithPlayers(numbOfPlayers);
    }

    public GameMenu(int numbOfPlayers) {
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

    public void setPlayerNames(int setNumbOfPlayers) {
        if (numbOfPlayers == 1) {
            player1 = new Player();
            System.out.println("Please enter your name");
            player1.setName(scanner.nextLine());
        } else {
            player1 = new Player();
            player2 = new Player();
            System.out.println("Please enter the name of Player1");
            player1.setName(scanner.nextLine());
            System.out.println("Please enter the name of the second Player2");
            player2.setName(scanner.nextLine());
        }
    }

    public void startGameWithPlayers(int numbOfPlayers) {
        if (numbOfPlayers == 1) {
            while (true) {
                try {
                    System.out.println("what game would you like to play? \n1.Snap \n2.Hangman");
                    int selected = scanner.nextInt();
                    scanner.nextLine();
                    if (selected == 1) {
                        newGame = new Snap(player1);
                        break;
                    } else if (selected == 2) {
                        HangmanMenu newGame = new HangmanMenu();
                        break;
                    } else {
                        throw new InputMismatchException();
                    }

                } catch (InputMismatchException e) {
                    System.out.println("❌ Invalid input! Please enter a number (1 or 2).");
                    scanner.nextLine();
                }
            }


        } else {
            while (true) {
                try {
                    System.out.println("what game would you like to play? \n1.Snap \n2.Hangman");
                    int selected = scanner.nextInt();
                    scanner.nextLine();
                    if (selected == 1) {
                        newGame = new Snap(player1, player2);
                        break;
                    } else if (selected == 2) {
                        HangmanMenu newGame = new HangmanMenu();
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
    }
}
