package org.example.snap;
import org.example.GameMenu;

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
        playSnap(player1,player2);
    }

    public Snap(Player player1 , Player player2){
        super(player1.getName(), player2.getName());
        this.player1 = player1;
        this.player2 = player2;
        isGameOver = false;
        scanner = new Scanner(System.in);
        populateDeck();
        shuffleDeck();
        playSnap(this.player1,this.player2);
    }

    public void playSnap(Player player1,Player player2){
        System.out.println("🔥 Welcome to Snap! Press ENTER to draw a card. Type 'exit' to quit.");
        String currentPlayer = player1.getName();
        while(!isGameOver){
            System.out.println("press enter to draw a new card");
            String input = scanner.nextLine();

            if(input.equals("exit")){
                System.out.println("Thanks for playing");
                break;
            }
            if (currentPlayer.equals(player1.getName())){
                playerTurn(player1);
                if(player2 != null){
                currentPlayer = player2.getName();
                }
            } else {
                playerTurn(player2);
                currentPlayer = player1.getName();
            }

        }
    }

    public void playerTurn(Player player){
        Card card = dealCard();
        System.out.println(player.getName() + "'s card is " + card.toString());
        noMoreCardsChecker(card);
        winChecker(card, player);
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
        System.out.println("type \n 1.to play again \n 2.select a new game with same players\n 3.to select players and select game");
        int input = scanner.nextInt();
        if(input == 1){
            populateDeck();
            shuffleDeck();
            playSnap(player1,player2);
        } else if (input == 2) {
            if(player2 == null){
            GameMenu newGameMenu = new GameMenu(1);
            } else {
            GameMenu newGameMenu = new GameMenu(2);
            }
        } else if (input == 3) {
            GameMenu newGameMenu = new GameMenu();
        } else {
            System.out.println("Thanks for playing");
            isGameOver = true;
        }
    }
}
