package org.game.core;

import org.game.board.Board;
import org.game.game.ReadData;
import org.game.game.State;
import org.game.game.Winner;
import org.game.players.Players;
import org.game.print.Print;

import java.util.InputMismatchException;

public class GameEngine {
    private State state;
    private Players player1;
    private Players player2;

    private Players computer;
    private Winner winner;

    private int sizeOfBoard;
    private int toWin;

    GameEngine(int boardSize, int toWin) {

        this.sizeOfBoard = boardSize;
        this.toWin = toWin;

        this.player1 = new Players("Player 1");
        this.player2 = new Players("Player 2");
        this.computer = new Players("Computer");
    }

    public void runGame(final int howManyPlayers) {

        if (howManyPlayers == 1) {

            prepareGamePlayerVsComputer();

            do {

                movePlayer(this.player1);
                moveComputer(this.computer);

            } while (winnerIs());
        }

        if (howManyPlayers == 2) {

            prepareGamePlayerVsPlayer();

            do {

                movePlayer(this.player1);
                movePlayer(this.player2);

            } while (winnerIs());
        }
    }

    private void readSymbol(final Players player1, final Players player2) {
        do {
            try {
                Print.chooseSymbol(player1);
                player1.setSymbol(ReadData.readSymbol());

                if (player1.getSymbol() == 'X') {
                    player2.setSymbol('O');
                } else {
                    player2.setSymbol('X');
                }
                break;

            } catch (InputMismatchException e) {
                Print.wrongSymbol();
            }
        } while (true);
    }

    private void movePlayer(final Players player) {

        int line = 0;
        int column = 0;

        // print game board
        Board.printBoard(this.state, player);

        do {
            // read move player
            line = readPlayerLine();
            column = readPlayerColumn();

            // check does position on game board is taken
            if (this.doesPositionIsTaken(line, column)) {
                Print.PositionIsTaken();
            } else {
                this.state.setLineAndColumn(line, column, player);
                break;
            }
        } while (true);
    }

    private void moveComputer(final Players computer) {

        int line = 0;
        int column = 0;

        do {
            line = computer.randomMoveForComputer(this.sizeOfBoard);
            column = computer.randomMoveForComputer(this.sizeOfBoard);

            if (!state.isFreeMove()) {
                break;
            } else if (this.doesPositionIsTaken(line, column)) {
                line = computer.randomMoveForComputer(this.sizeOfBoard);
                column = computer.randomMoveForComputer(this.sizeOfBoard);
            } else {
                this.state.setLineAndColumn(line, column, computer);
                break;
            }

        } while (true);

        Board.printBoard(this.state, computer);
    }

    private boolean winnerIs() {

        String winner = this.winner.showWinner();

        if (winner.isEmpty()) {
            return true;
        } else {
            Print.printWinner(winner);
            return false;
        }
    }

    private int readPlayerLine() {

        boolean exception;
        int line = 0;

        do {
            try {
                Print.enterLine();
                line = ReadData.readLineAndColumn(this.sizeOfBoard);

                exception = false;

            } catch (NumberFormatException e) {
                Print.wrongInputNotDigit();
                exception = true;
            } catch (InputMismatchException e) {
                Print.wrongPosition();
                exception = true;
            }
        }while (exception);

        return line;
    }

    private int readPlayerColumn() {

        boolean exception;
        int column = 0;

        do {
            try {

                Print.enterColumn();
                column = ReadData.readLineAndColumn(this.sizeOfBoard);

                exception = false;

            } catch (NumberFormatException e) {
                Print.wrongInputNotDigit();
                exception = true;
            } catch (InputMismatchException e) {
                Print.wrongPosition();
                exception = true;
            }
        }while (exception);

        return column;
    }

    private boolean doesPositionIsTaken(final int line, final int column) {

        char[][] board = this.state.getGameBoard();

        // check does position on game board is taken
        if (board[line][column] == 'X' || board[line][column] == 'O') {
            return true;
        } else {
            return false;
        }
    }

    private void setPlayerName(final Players player){

        if (player.getPlayerName().equals("Player 1") || player.getPlayerName().equals("Player 2")) {

            Print.enterPlayerName(player);
            String playerName = ReadData.readPlayerName();
            player.setPlayerName(playerName);

        }

    }

    private void prepareGamePlayerVsComputer() {
        this.state = new State(this.sizeOfBoard, this.toWin);
        this.winner = new Winner(this.state, this.player1, this.computer);

        setPlayerName(this.player1);

        readSymbol(this.player1, this.computer);
    }

    private void prepareGamePlayerVsPlayer() {
        setPlayerName(player1);
        setPlayerName(player2);

        this.state = new State(this.sizeOfBoard, this.toWin);
        this.winner = new Winner(this.state, this.player1, this.player2);

        readSymbol(this.player1, this.player2);
    }

    public void setSizeOfBoard(int sizeOfBoard) {
        this.sizeOfBoard = sizeOfBoard;
    }

    public void setToWin(int toWin) {
        this.toWin = toWin;
    }

}