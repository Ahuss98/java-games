package org.example.snap;

public class Card {
    private String suit;
    private String symbol;
    private int value;

    public Card(String suit, String symbol) {
        setSuitIfValid(suit);
        setSymbolIfValid(symbol);
        this.value = findValueOfSymbol(symbol);
    }

    public Card(String suit, int value) {
        setSuitIfValid(suit);
        this.symbol = findSymbolOfValue(value);
        setValueIfValid(value);
    }

    public int getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuitIfValid(String suit) {
        String[] validSuits = {"hearts", "diamonds", "spades", "clubs"};
        boolean isValid = false;

        for (String validSuit : validSuits) {
            if (validSuit.equals(suit)) {
                this.suit = suit;
                isValid = true;
                break;
            }
        }
        if (!isValid) {
            System.out.println("Please enter a valid suit: hearts, diamonds, spades, or clubs");
        }
    }

    public void setSymbolIfValid(String symbol) {
        String[] validSymbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        boolean isValid = false;
        for (String validSymbol : validSymbols) {
            if (validSymbol.equals(symbol)) {
                isValid = true;
                this.symbol = symbol;

                break;
            }
        }
        if (!isValid) {
            System.out.println("Please enter a valid symbol: 2,3,4,5,6,7,8,9,10,J,Q,K,A");
        }
    }

    public void setValueIfValid(int value) {
        int[] validValues = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        boolean isValid = false;
        for (int validValue : validValues) {
            if (validValue == value) {
                isValid = true;
                this.value = value;

                break;
            }
        }
        if (!isValid) {
            System.out.println("Please enter a valid value: 2,3,4,5,6,7,8,9,10,11,12,13,14");
        }
    }

    public int findValueOfSymbol(String symbol) {
        if (symbol.matches("[a-zA-Z]+")) {
            return switch (symbol) {
                case "J" -> 11;
                case "Q" -> 12;
                case "K" -> 13;
                case "A" -> 14;
                default -> 999;
            };
        } else {
            return Integer.parseInt(symbol);
        }
    }

    public String findSymbolOfValue(int value) {
        if (value >= 11 && value <= 14) {
            return switch (value) {
                case 11 -> "J";
                case 12 -> "Q";
                case 13 -> "K";
                case 14 -> "A";
                default -> "not a valid number";
            };
        } else {
            return String.valueOf(value);
        }
    }

    @Override
    public String toString() {
        return "The " + getSymbol() + " of " + getSuit();
    }
}
