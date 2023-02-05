package org.game.board;

import org.game.game.State;
import org.game.players.Players;

public class Board {

    static public void printBoard (final State state, final Players player){

        char[][] board = state.getGameBoard();

        System.out.println();
        System.out.println("Move: " + player.getPlayerName() + "     Symbol: " + player.getSymbol());

        // print horizontal coordinates
        System.out.print("  ");
        for (var i = 0; i < board.length; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        // print vertical coordinates and board
        for (var i = 0; i < board.length; i++) {
                System.out.print(i + "|");
            for (var j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    }
}