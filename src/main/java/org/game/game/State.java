package org.game.game;

import org.game.players.Players;

public class State {

    private char[][] board;

    private int toWin;
    private int boardSize;

    public State(final int boardSize, final int toWin) {

       this.boardSize = boardSize;
       this.toWin = toWin;

       setBoardSize();
    }

    public char[][] getGameBoard() {
        return board;
    }

    public int getToWin() {
        return this.toWin;
    }

    private void setBoardSize() {

        // set board with new size
        this.board = new char[this.boardSize][this.boardSize];

        // create empty board
        for (var i = 0; i < this.board.length; i++) {
            for (var j = 0; j < this.board.length; j++) {
                this.board[i][j] = ' ';
            }
        }
    }

    public void setLineAndColumn (final int line, final int column, final Players player) {
        this.board[line][column] = player.getSymbol();
    }

    public boolean isFreeMove() {

        boolean result = false;

        for (var i = 0; i < this.board.length; i++) {
            for (var j = 0; j < this.board.length; j++) {
                if (this.board[i][j] == ' ') {
                    result =  true;
                    break;
                } else {
                    result = false;
                }
            }
            if (result) {
                break;
            }
        }
        return result;
    }
}