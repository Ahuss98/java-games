package org.example.snap;
import java.util.Scanner;

public class GameMenu {
    private int numbOfPlayers;
    Scanner scanner = new Scanner(System.in);
    Snap newGame ;

    public GameMenu(){
        setNumbOfPlayers();
        startGameWithPlayers(numbOfPlayers);
    }

    public void setNumbOfPlayers() {
        System.out.println("How many Players? 1/2");
        int input = scanner.nextInt();
        if(input == 1){
            numbOfPlayers = 1;
        } else if (input == 2) {
            numbOfPlayers = 2;
        }
    }

    public void startGameWithPlayers(int numbOfPlayers){
        if(numbOfPlayers == 1){
            scanner.nextLine();
            System.out.println("Please enter your name");
            String name = scanner.nextLine();
            newGame = new Snap(name);
            newGame.playSnap(name);
        } else {
            scanner.nextLine();
            System.out.println("Please enter the name of Player1");
            String player1 = scanner.nextLine();
            System.out.println("Please enter the name of the second Player2");
            String player2 = scanner.nextLine();

            newGame = new Snap(player1,player2);
            newGame.playSnap(player1,player2);
        }
    }
}
