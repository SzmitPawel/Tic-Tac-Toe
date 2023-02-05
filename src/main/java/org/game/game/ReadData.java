package org.game.game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadData {

    // read player choice Game Menu, start new game or exit
    public static char readGameMenu ()  throws InputMismatchException, NumberFormatException {

        Scanner scanner = new Scanner(System.in);

        String choice = scanner.nextLine().toUpperCase();

        // check if line is a Digit
        boolean isNumeric = choice.chars().allMatch(Character::isDigit);

        if (isNumeric) {
            throw new NumberFormatException();
        }

        if (!choice.equals("N") && !choice.equals("X")) {
            throw new InputMismatchException();
        }

        return choice.charAt(0);
    }

    public static int readGameOptions ()  throws InputMismatchException, NumberFormatException {

        Scanner scanner = new Scanner(System.in);

        String gameOption = scanner.nextLine().toUpperCase();

        // check if line is a Digit
        boolean isNumeric = gameOption.chars().allMatch(Character::isDigit);

        // change String to int
        int options = Integer.valueOf(gameOption);

        if (options < 1 || options > 5) {
            throw new InputMismatchException();
        } else if (!isNumeric) {
            throw new NumberFormatException();
        }

        return options;
    }


    // read player choose 'X' or 'Y'
    public static char readSymbol () throws InputMismatchException, NumberFormatException {

        Scanner scanner = new Scanner(System.in);

        String symbol = scanner.nextLine().toUpperCase();

        if (!symbol.equals("X") && !symbol.equals("O")) {
            throw new InputMismatchException();
        }

        return symbol.charAt(0);
    }

    // read line of board
    public static int readLineAndColumn (final int sizeOfBoard) throws InputMismatchException, NumberFormatException {

        Scanner scanner = new Scanner(System.in);
        String position = scanner.nextLine();

        // check if line is a Digit
        boolean isNumeric = position.chars().allMatch(Character::isDigit);

        // change String to int
        int boardPosition = Integer.valueOf(position);


        if (boardPosition < 0 || boardPosition > sizeOfBoard - 1) {
            throw new InputMismatchException();
        } else if (!isNumeric) {
            throw new NumberFormatException();
        }

        return boardPosition;
    }

    public static int readBoardSize () {
        Scanner scanner = new Scanner(System.in);
        String position = scanner.nextLine();

        // check if column is a Digit
        boolean isNumeric = position.chars().allMatch(Character::isDigit);

        // change String to int
        int boardSize = Integer.valueOf(position);


        if (boardSize < 3 || boardSize > 10) {
            throw new InputMismatchException();
        } else if (!isNumeric) {
            throw new NumberFormatException();
        }

        return boardSize;
    }

    public static int readToWin () {
        Scanner scanner = new Scanner(System.in);
        String position = scanner.nextLine();

        // check if column is a Digit
        boolean isNumeric = position.chars().allMatch(Character::isDigit);

        // change String to int
        int boardSize = Integer.valueOf(position);


        if (boardSize < 2 || boardSize > 6) {
            throw new InputMismatchException();
        } else if (!isNumeric) {
            throw new NumberFormatException();
        }

        return boardSize;
    }

    public static String readPlayerName() {
        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.nextLine();

        return playerName;
    }
}