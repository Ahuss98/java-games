package org.example.snap;
import java.util.Scanner;

public class Snap extends CardGame{
    private Card lastCard;
    private boolean isGameOver;
    Scanner scanner ;
    boolean isFirstCard = true;
    Player player1;
    Player player2;

    public Snap(Player player) {
        super(player.getName());
        this.player1 = player;
        isGameOver = false;
        scanner = new Scanner(System.in);
        populateDeck();
        shuffleDeck();
    }

    public Snap(Player player1 , Player player2){
        super(player1.getName(), player2.getName());
        this.player1 = player1;
        this.player2 = player2;
        isGameOver = false;
        scanner = new Scanner(System.in);
        populateDeck();
        shuffleDeck();
    }
    public void playSnap(Player player){
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
            winChecker(newCard, player);
        }
    }

    public void playSnap(Player player1, Player player2){
        String currentPlayer = player1.getName();
        Card player1Card;
        Card player2Card;
        System.out.println("🔥 Welcome to Snap! Press ENTER to draw a card. Type 'exit' to quit.");

        while(!isGameOver){
            System.out.println("press enter to draw a new card");
            String input = scanner.nextLine();

            if(input.equals("exit")){
                System.out.println("Thanks for playing");
                break;
            }

            if (currentPlayer.equals(player1.getName())){
                player1Card = dealCard();
                System.out.println(player1.getName() + "'s card is " + player1Card.toString());

                noMoreCardsChecker(player1Card);
                winChecker(player1Card, player1);

                currentPlayer = player2.getName();
            } else {
                player2Card = dealCard();
                System.out.println(player2.getName() + "'s card is " + player2Card.toString());

                noMoreCardsChecker(player2Card);
                winChecker(player2Card, player2);

                currentPlayer = player1.getName();
            }

        }

    }
    public void winChecker(Card newCard,Player player){
        if(!isFirstCard){
            if(newCard != null && lastCard.getSymbol().equals(newCard.getSymbol())){
                long startTime = System.currentTimeMillis();
                while ((System.currentTimeMillis() - startTime) < 2000) {
                    System.out.println( player.getName() + " type 'snap' as fast as you can");
                    String input = scanner.nextLine().trim();
                    if (input.equalsIgnoreCase("snap") && (System.currentTimeMillis() - startTime) < 2000) {
                        System.out.println("🎉 SNAP!!! " + player.getName() + " WINS!");
                        playAgain(player1,player2);
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
            playSnap(player1);
        } else {
            System.out.println("Thanks for playing");
            isGameOver = true;
        }
    }
    public void playAgain(Player player1,Player player2){
        System.out.println("type 'play' to play again");
        String input = scanner.nextLine();
        if(input.equals("play")){
            populateDeck();
            shuffleDeck();
            playSnap(player1,player2);
        } else {
            System.out.println("Thanks for playing");
            isGameOver = true;
        }
    }
}
