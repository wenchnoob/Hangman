package com;

import com.Dictionary.DictionaryManager;
import com.Game.Game;
import com.Util.Input;

public class Main {

    public static void main(String[] args) {
        String plan;
        var dm = new DictionaryManager();

        do {
            System.out.println();
            System.out.println();
            plan = Input.get("Input 'p' or 'play' to play a game of hang man." +
                    "\nInput 'a' or 'add' to add words to the dictionary of playable words." +
                    "\nInput 'r' or 'remove' to remove something from the dictionay." +
                    "\nInput 'q' or 'quit' to quit the application." +
                    "\nWhat would you like to do?");
            System.out.println();

            if (plan.equals("p") || plan.equals("play")) new Game().play();
            if (plan.equals("a") || plan.equals("add")) dm.add();
            if (plan.equals("r") || plan.equals("remove")) dm.remove();

        } while(!plan.equals("q") && !plan.equals("quit"));

        System.out.println("Bye, have a good day! :)");
    }
}
