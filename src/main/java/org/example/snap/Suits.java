package org.example.snap;

public enum Suits {
    HEARTS("♥"), DIAMONDS("♦"), SPADES("♠"), CLUBS("♣");
    private final String symbol;

     Suits(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
