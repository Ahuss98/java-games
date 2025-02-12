package org.example.snap;
import java.util.Scanner;

public class Snap extends CardGame{
    private Card lastCard;
    private boolean isGameOver;
    Scanner scanner ;
    boolean isFirstCard = true;

    public Snap(String name) {
        super(name);
        isGameOver = false;
        scanner = new Scanner(System.in);
        populateDeck();
        shuffleDeck();
    }

    public Snap(String name1 , String name2){
        super(name1,name2);
        isGameOver = false;
        scanner = new Scanner(System.in);
        populateDeck();
        shuffleDeck();
    }
}
