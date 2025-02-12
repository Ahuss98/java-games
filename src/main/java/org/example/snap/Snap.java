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
    public void playSnap(String name){
        System.out.println("🔥 Welcome to Snap! Press ENTER to draw a card. Type 'exit' to quit.");

        while(!isGameOver){
            System.out.println("press enter to draw a new card");
            String input = scanner.nextLine();
            if(input.equals("exit")){
                System.out.println("Thanks for playing");
                break;
            }

            Card newCard = dealCard();
            System.out.println(newCard.toString());

            noMoreCardsChecker(newCard);
            winChecker(newCard, name);
        }
    }
    public void winChecker(Card newCard,String name){
        if(!isFirstCard){
            if(newCard != null && lastCard.getSymbol().equals(newCard.getSymbol())){
                long startTime = System.currentTimeMillis();
                while ((System.currentTimeMillis() - startTime) < 2000) {
                    System.out.println( name + " type 'snap' as fast as you can");
                    String input = scanner.nextLine().trim();
                    if (input.equalsIgnoreCase("snap") && (System.currentTimeMillis() - startTime) < 2000) {
                        System.out.println("🎉 SNAP!!! " + name + " WINS!");
                        playAgain();
                        return;
                    } else if ((System.currentTimeMillis() - startTime) < 2000){
                        System.out.println("❌ Wrong input! Try again.");
                    } else {
                        System.out.println("⌛ Too slow! You lost.");
                        playAgain();
                    }
                }
            } else {
                lastCard = newCard;
            }
        } else {
            lastCard = newCard;
            isFirstCard = false;
        }
    }

    public void noMoreCardsChecker(Card newCard){
        if (newCard == null){
            System.out.println("no cards left");
            playAgain();
        }
    }
    public void playAgain(){
        System.out.println("type 'play' to play again");
        String input = scanner.nextLine();
        if(input.equals("play")){
            populateDeck();
            shuffleDeck();
            playSnap(name);
        } else {
            System.out.println("Thanks for playing");
            isGameOver = true;
        }
    }
}
