package org.game.core;

import org.game.game.ReadData;
import org.game.print.Print;

import java.util.InputMismatchException;

public class Menu {

    int boardSize = 3;
    int toWin = 3;

    public void runMenu() {

        int menuChoice = 0;

        do {
            try {
                Print.printMenu();
                menuChoice = ReadData.readGameMenu();

            } catch (NumberFormatException e) {
                Print.wrongInputNotLetter();
            } catch (InputMismatchException e) {
                Print.wrongMenuChoice();
            }

            if (menuChoice == 'N') {
                gameOptions();
            }
        } while (menuChoice != 'X');
    }

    private void gameOptions() {

        int menuChoice = 0;
        GameEngine gameEngine = new GameEngine(this.boardSize, this.toWin);

        do {
            try {
                Print.newGameOption();
                menuChoice = ReadData.readGameOptions();

                if (menuChoice == 1) {
                    gameEngine.runGame(2);
                }

                if (menuChoice == 2) {
                    gameEngine.runGame(1);
                }

                if (menuChoice == 3) {
                    Print.printBoardSize();
                    gameEngine.setSizeOfBoard(ReadData.readBoardSize());
                }

                if (menuChoice == 4) {
                    Print.printToWin();
                    gameEngine.setToWin(ReadData.readToWin());
                }

            } catch (NumberFormatException e) {
                Print.wrongInputNotDigit();
            } catch (InputMismatchException e) {
                Print.wrongMenuChoice();
            }

        } while (menuChoice != 5);
    }
}
