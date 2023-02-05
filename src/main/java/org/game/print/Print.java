package org.game.print;

import org.game.players.Players;

public class Print {

    public static void printMenu() {
        System.out.println("Game menu ");
        System.out.println("        n - Start a New Game");
        System.out.println("        x - End the Game");
        System.out.print("Please choice: ");
    }

    public static void newGameOption() {
        System.out.println("Game Options");
        System.out.println("        1 - Player vs Player");
        System.out.println("        2 - Player vr Computer");
        System.out.println("        3 - Set Board size <default 3x3>");
        System.out.println("        4 - Set how many fields to win <default 3>");
        System.out.println("        5 - Exit");
        System.out.print("Please choice: ");
    }

    public static void printBoardSize() {
        System.out.println("Board size");
        System.out.println("        3 - 3 x 3");
        System.out.println("        4 - 4 x 4");
        System.out.println("        5 - 5 x 5");
        System.out.println("        6 - 6 x 6");
        System.out.println("        7 - 7 x 7");
        System.out.println("        8 - 8 x 8");
        System.out.println("        9 - 9 x 9");
        System.out.println("       10 - 10 x 10");
        System.out.print("Please choice: ");
    }

    public static void printToWin() {
        System.out.println("Set how many fields you need to win");
        System.out.println("min: 2    max: 6");
        System.out.print("Please choice: ");
    }

    public static void chooseSymbol(final Players player) {
        System.out.println("'X' or 'O'");
        System.out.print(player.getPlayerName() + " choice your symbol -> ");
    }

    public static void PositionIsTaken() {
        System.out.println("Position is taken!");
        System.out.println("Please try again.");
        System.out.println();
    }

    public static void printWinner(final String winner) {
        System.out.println("The winner is " + winner);
        System.out.println();
    }

    public static void enterLine() {
        System.out.print("Enter a line -> ");
    }

    public static void enterColumn() {
        System.out.print("Enter a column -> ");
    }

    public static void wrongInputNotDigit() {
        System.out.println("Input is not digit!");
        System.out.println("Please try again.");
        System.out.println();
    }

    public static void wrongPosition() {
        System.out.println("Wrong position!");
        System.out.println("Please try again.");
    }

    public static void wrongInputNotLetter() {
        System.out.println("Input is not letter!");
        System.out.println("Please try again.");
        System.out.println();
    }

    public static void wrongSymbol() {
        System.out.println("Wrong symbol");
        System.out.println("Choice 'X' or 'O'");
        System.out.println();
    }

    public static void wrongMenuChoice() {
        System.out.println("Wrong input!");
        System.out.println();
    }

    public static void enterPlayerName(final Players player){
        System.out.println("Welcome " + player.getPlayerName());
        System.out.print("Set your name: ");
    }
}
