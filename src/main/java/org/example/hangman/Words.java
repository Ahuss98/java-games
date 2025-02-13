package org.example.hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Words {
    public static ArrayList<String> words = new ArrayList<>(Arrays.asList("Velocity", "Nimbus", "Quasar", "Ephemeral", "Labyrinth",
            "Zephyr", "Eclipse", "Obsidian", "Serendipity", "Cascade"));

    public static String selectRandomWord(){
        Random rand = new Random();
        int randomNum = rand.nextInt(words.size());
        return words.get(randomNum);

    }
}
