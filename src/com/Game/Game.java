package com.Game;

import com.Dictionary.DictionaryManager;
import com.Util.Input;
import com.Util.Lives;


import java.util.Arrays;
import java.util.HashSet;

public class Game {
    private final char[] word;
    private final HashSet<Character> guessed;
    private final String target;
    private final String description;
    private boolean solved = false;
    private int life = 6;


    public Game() {
        DictionaryManager dm = new DictionaryManager();
        var randomEntry = dm.random();
        target = (String)randomEntry.getKey();
        description = (String)randomEntry.getValue();
        word = new char[target.length()];
        Arrays.fill(word, '_');
        guessed = new HashSet<>();
    }

    public void play() {
        do {
            displayFrame();
            char guess;
            do { guess = Input.getChar(); } while (guessed.contains(guess));
            guessed.add(guess);
            if(!checkChar(guess)) life--;
            if(checkSolved()) solved = true;
        } while (!solved && life > 0);

        if(solved) {
            System.out.println();
            System.out.println("Congratulations you have won the game. The word was: " + target);
        } else {
            displayFrame();
            System.out.println("Unfortunately you have lost. You got this far: " + charArrToStr(word));
        }
    }

    public boolean checkSolved() {
        for (char c: word) if (c == '_') return false;
        return true;
    }

    public boolean checkChar(char guess) {
        boolean found = false;
        for (int i = 0; i < target.length(); i++) {
            if (guess == target.charAt(i)) {
                word[i] = guess;
                found = true;
            }
        }
        return found;
    }

    public void displayFrame() {
        System.out.println();
        System.out.printf("%s%s\n", "Description: ", description);
        System.out.printf("%s%s\n%s\n%s", "Current know letters: ", charArrToStr(word),
                "Current chances: " + life, Lives.values()[Math.abs(life-6)].get());
        System.out.print("Guessed Letters: ");
        for(Character c: guessed) System.out.print(c + ", ");
        System.out.println();
    }

    public String charArrToStr(char[] arr) {
        if(solved) return new String(arr);
        var sb = new StringBuilder();
        for (char c: arr) sb.append(c).append(" ");
        return sb.toString().trim();
    }
}
