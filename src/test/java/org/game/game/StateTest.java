package org.game.game;

import org.game.board.Board;
import org.game.players.Players;
import org.game.print.Print;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateTest {

    @Test
    void setBoardSize() {
        // give
        State state = new State(4,3);

        // when
        int boardSize = state.getGameBoard().length;

        // then
        assertEquals(4,boardSize);
    }

    @Test
    void setLineAndColumn00() {
        // give
        State state = new State(4,3);
        Players players = new Players("Player");
        players.setSymbol('X');

        // when
        state.setLineAndColumn(0,0,players);
        char[][] result = state.getGameBoard();
        char expectedResult = 'X';

        // then
        assertEquals(expectedResult, result[0][0]);
    }

    @Test
    void setLineAndColumn99() {
        // give
        State state = new State(10,3);
        Players players = new Players("Player");
        players.setSymbol('O');
        char expectedResult = 'O';

        // when
        state.setLineAndColumn(9,9,players);
        char[][] result = state.getGameBoard();

        // then
        assertEquals(expectedResult, result[9][9]);
    }

    @Test
    void getToWin() {
        // give
        State state = new State(3,3);
        int expectedResult = 3;

        // when
        int result = state.getToWin();

        // then
        assertEquals(expectedResult,result);
    }

    @Test
    void isFreeMove() {
        // give
        State state = new State(3,3);
        Players player = new Players("Player 1");
        player.setSymbol('X');

        state.setLineAndColumn(0,0,player);
        state.setLineAndColumn(0,1,player);
        state.setLineAndColumn(0,2,player);

        state.setLineAndColumn(1,0,player);
        state.setLineAndColumn(1,1,player);
        state.setLineAndColumn(1,2,player);

        state.setLineAndColumn(2,0,player);
        state.setLineAndColumn(2,1,player);

        // when & then
        assertTrue(state.isFreeMove());
    }
}
