package com.Util;

import java.util.Scanner;

public class Input {
    public static String get(String message) {
        var in = new Scanner(System.in);
        System.out.print(message + ": ");
        String input = in.nextLine();
        input = clean(input.strip());
        if (input.length() > 0) return input;
        else return get("Please try again (Please input at least one character, use the prior prompt as your guide");
    }

    public static String clean(String input) {
        var cleaned = new StringBuilder(input.length());
        input.chars().filter(c -> c == 32 || Character.isAlphabetic(Character.valueOf((char)c))).forEach(element -> cleaned.append((char)element));
        return cleaned.toString().toLowerCase();
    }

    public static char getChar(){
        return get("Please input a character guess").charAt(0);
    }
}
