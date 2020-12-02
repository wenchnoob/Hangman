package com.Util;

public enum Lives {
    six(new String[] {
            "       ---------      ",
            "       |       |      ",
            "               |      ",
            "               |      ",
            "               |      ",
            "               |      ",
            "               |      ",
            "               |      ",
            "    _____      |      ",
            "      |________|      ",
            "                      "

    }),

    five(new String[] {
            "       ---------      ",
            "       |       |      ",
            "       0       |      ",
            "               |      ",
            "               |      ",
            "               |      ",
            "               |      ",
            "               |      ",
            "    _____      |      ",
            "      |________|      ",
            "                      "
    }),

    four(new String[] {
            "       ---------      ",
            "       |       |      ",
            "       0       |      ",
            "       |       |      ",
            "       |       |      ",
            "               |      ",
            "               |      ",
            "               |      ",
            "    _____      |      ",
            "      |________|      ",
            "                      "
    }),

    three(new String[] {
            "       ---------      ",
            "       |       |      ",
            "       0       |      ",
            "      \\|       |      ",
            "       |       |      ",
            "               |      ",
            "               |      ",
            "               |      ",
            "    _____      |      ",
            "      |________|      ",
            "                      "
    }),

    two(new String[] {
            "       ---------      ",
            "       |       |      ",
            "       0       |      ",
            "      \\|/      |      ",
            "       |       |      ",
            "               |      ",
            "               |      ",
            "               |      ",
            "    _____      |      ",
            "      |________|      ",
            "                      "
    }),

    one(new String[] {
            "       ---------      ",
            "       |       |      ",
            "       0       |      ",
            "      \\|/      |      ",
            "       |       |      ",
            "      /        |      ",
            "               |      ",
            "               |      ",
            "    _____      |      ",
            "      |________|      ",
            "                      "
    }),

    zero(new String[] {
            "       ---------      ",
            "       |       |      ",
            "       0       |      ",
            "      \\|/      |      ",
            "       |       |      ",
            "      / \\      |      ",
            "               |      ",
            "               |      ",
            "    _____      |      ",
            "      |________|      ",
            "       Rip (X.X)      "
    });

    String[] hangman;

    Lives(String[] hangman) { this.hangman = hangman; }

    public String get() {
        var sb = new StringBuilder();
        for(String s: hangman) sb.append(s + "\n");
        return sb.toString();
    }
}
