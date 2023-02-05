package org.game.game;

import org.game.players.Players;

public class Winner {

    private State state;
    private Players player1;
    private Players player2;

    private final char[][] board;

    public Winner(final State state, final Players player1, final Players player2) {
        this.state = state;
        this.player1 = player1;
        this.player2 = player2;

        this.board = this.state.getGameBoard();
    }

    public String showWinner() {

        String winner = "";

        if (calculateWinner(this.player1) && calculateWinner(this.player2)) {
            winner = "Nobody";
        } else if (calculateWinner(this.player1)) {
            winner = player1.getPlayerName();
        } else if (calculateWinner(this.player2)) {
            winner = player2.getPlayerName();
        } else winner = "";


        return winner;
    }

    private boolean calculateWinner(final Players player) {

        if (horizontal(player) || vertical(player) || diagonal(player)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean horizontal (final Players player){

        int counter = 0;
        boolean before = false;
        char symbol = player.getSymbol();

        for (var i = 0; i < this.board.length; i++) {
            for (var j = 0; j < this.board.length; j++) {

                if (this.board[i][j] == symbol && !before) {
                    counter++;
                    before = true;
                } else if (this.board[i][j] == symbol && before) {
                    counter++;
                } else {
                    counter = 0;
                    before = false;
                }

                if (counter == this.state.getToWin()) {
                    break;
                }
            }

            if (counter == this.state.getToWin()) {
                break;
            } else {
                counter = 0;
                before = false;
            }
        }
        return counter == state.getToWin() ? true : false;
    }

    private boolean vertical(final Players player){

        int counter = 0;
        boolean before = false;
        char symbol = player.getSymbol();

        // find vertical winner
        for (var j = 0; j < this.board.length; j++) {
            for (var i = 0; i < this.board.length; i++) {

                if (this.board[i][j] == symbol && !before) {
                    counter++;
                    before = true;
                } else if (this.board[i][j] == symbol && before) {
                    counter++;
                } else {
                    counter = 0;
                    before = false;
                }

                if (counter == this.state.getToWin()) {
                    before = false;
                    break;
                }
            }

            if (counter == this.state.getToWin()) {
                break;
            } else {
                counter = 0;
                before = false;
            }
        }
        return counter == this.state.getToWin() ? true : false;
    }

    private boolean diagonal(final Players player) {

        int counterL = 0;
        int counterR = 0;

        char symbol = player.getSymbol();

        for (var i = 0; i < this.board.length; i++) {
            for (var j = 0; j < this.board.length; j++) {
                if (this.board[i][j] == symbol) {
                    counterL = leftToRightDiagonal(player,i,j);
                    counterR = rightToLeftDiagonal(player,i,j);
                }
                if (counterL == state.getToWin() || counterR == state.getToWin()) {
                    break;
                }
            }
            if (counterL == state.getToWin() || counterR == state.getToWin()) {
                break;
            }
        }

        if (counterL == state.getToWin() || counterR == state.getToWin()) {
            return true;
        } else {
            return false;
        }
    }

    private int rightToLeftDiagonal (final Players player, final int di, final int dj) {

        int i = di;
        int j = dj;

        char symbol = player.getSymbol();

        int counter = 0;

        while (i < this.board.length && j >= 0) {
            if (this.board[i][j] == symbol) {
                counter++;
                i++;
                j--;
            } else {
                break;
            }
        }
        return counter;
    }

    private int leftToRightDiagonal (final Players player, final int di, final int dj){

        int i = di;
        int j = dj;

        int counter = 0;

        char symbol = player.getSymbol();

        while (i < this.board.length && j < this.board.length) {
            if (this.board[i][j] == symbol) {
                counter++;
                i++;
                j++;
            } else {
                break;
            }
        }
        return counter;
    }
}