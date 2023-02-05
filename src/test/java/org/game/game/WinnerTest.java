package org.game.game;

import org.game.players.Players;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class WinnerTest {


    private static Winner winner;
    private static Players player1;
    private static Players player2;

    @BeforeAll
    static void beforeAll() {
        player1 = new Players("Player 1");
        player1.setSymbol('X');

        player2 = new Players("Player 2");
        player2.setSymbol('O');
    }
    @Nested
    @DisplayName("Tests for 3x3 board")
    class TestsFor3x3Board {
        @Test
        void calculateWinnerDiagonalLeftToRightBoard3x3ToWin3ForX() {
            // give
            State state = new State(3, 3);
            Winner winner = new Winner(state, player1, player2);

            state.setLineAndColumn(0, 0, player1); // X - -
            state.setLineAndColumn(1, 1, player1); // - X -
            state.setLineAndColumn(2, 2, player1); // - - X

            String expectedResult = "Player 1";

            // when
            String result = winner.showWinner();

            // then
            assertEquals(expectedResult, result);
        }

        @Test
        void calculateWinnerDiagonalRightToLeftBoard3x3ToWin3ForX() {
            // give
            State state = new State(3, 3);
            Winner winner = new Winner(state, player1, player2);

            state.setLineAndColumn(0, 2, player1); // - - X
            state.setLineAndColumn(1, 1, player1); // - X -
            state.setLineAndColumn(2, 0, player1); // X - -

            String expectedResult = "Player 1";

            // when
            String result = winner.showWinner();

            // then
            assertEquals(expectedResult, result);
        }

        @Test
        void calculateWinnerHorizontalBoard3x3ToWin3ForX() {
            // give
            State state = new State(3, 3);
            Winner winner = new Winner(state, player1, player2);

            state.setLineAndColumn(0, 0, player1); // X X X
            state.setLineAndColumn(0, 1, player1); // - - -
            state.setLineAndColumn(0, 2, player1); // - - -

            String expectedResult = "Player 1";

            // when
            String result = winner.showWinner();

            // then
            assertEquals(expectedResult, result);
        }

        @Test
        void calculateWinnerVerticalBoard3x3ToWin3ForX() {
            // give
            State state = new State(3, 3);
            Winner winner = new Winner(state, player1, player2);

            state.setLineAndColumn(0, 1, player1); // - X -
            state.setLineAndColumn(1, 1, player1); // - X -
            state.setLineAndColumn(2, 1, player1); // - X -

            String expectedResult = "Player 1";

            // when
            String result = winner.showWinner();

            // then
            assertEquals(expectedResult, result);
        }

        @Test
        void calculateWinnerDiagonalLeftToRightBoard3x3ToWin3ForO() {
            // give
            State state = new State(3, 3);
            Winner winner = new Winner(state, player1, player2);

            state.setLineAndColumn(0, 0, player2); // O - -
            state.setLineAndColumn(1, 1, player2); // - O -
            state.setLineAndColumn(2, 2, player2); // - - O

            String expectedResult = "Player 2";

            // when
            String result = winner.showWinner();

            // then
            assertEquals(expectedResult, result);
        }

        @Test
        void calculateWinnerDiagonalRightToLeftBoard3x3ToWin3ForO() {
            // give
            State state = new State(3, 3);
            Winner winner = new Winner(state, player1, player2);

            state.setLineAndColumn(0, 2, player2); // - - O
            state.setLineAndColumn(1, 1, player2); // - O -
            state.setLineAndColumn(2, 0, player2); // O - -

            String expectedResult = "Player 2";

            // when
            String result = winner.showWinner();

            // then
            assertEquals(expectedResult, result);
        }

        @Test
        void calculateWinnerHorizontalBoard3x3ToWin3ForO() {
            // give
            State state = new State(3, 3);
            Winner winner = new Winner(state, player1, player2);

            state.setLineAndColumn(1, 0, player2); // - - -
            state.setLineAndColumn(1, 1, player2); // O O O
            state.setLineAndColumn(1, 2, player2); // - - -

            String expectedResult = "Player 2";

            // when
            String result = winner.showWinner();

            // then
            assertEquals(expectedResult, result);
        }

        @Test
        void calculateWinnerVerticalBoard3x3ToWin3ForO() {
            // give
            State state = new State(3, 3);
            Winner winner = new Winner(state, player1, player2);

            state.setLineAndColumn(0, 2, player2); // - - O
            state.setLineAndColumn(1, 2, player2); // - - O
            state.setLineAndColumn(2, 2, player2); // - - O

            String expectedResult = "Player 2";

            // when
            String result = winner.showWinner();

            // then
            assertEquals(expectedResult, result);
        }

        @Test
        void calculateWinnerDrawBoard3x3ToWin3ForXO() {
            // give
            State state = new State(3, 3);
            Winner winner = new Winner(state, player1, player2);

            state.setLineAndColumn(0, 2, player1); // O - X
            state.setLineAndColumn(1, 2, player1); // O - X
            state.setLineAndColumn(2, 2, player1); // O - X

            state.setLineAndColumn(0, 0, player2);
            state.setLineAndColumn(1, 0, player2);
            state.setLineAndColumn(2, 0, player2);

            String expectedResult = "Nobody";

            // when
            String result = winner.showWinner();

            // then
            assertEquals(expectedResult, result);
        }
    }
    @Nested
    @DisplayName("Tests for 6x6 board")
    class TestsFor6x6Board {
        @Test
        void calculateWinnerDiagonalLeftToRightBoard6x6ToWin4ForX() {
            // give
            State state = new State(6, 4);
            Winner winner = new Winner(state, player1, player2);

            state.setLineAndColumn(0, 0, player1); // X - - - - -
            state.setLineAndColumn(1, 1, player1); // - X - - - -
            state.setLineAndColumn(2, 2, player1); // - - X - - -
            state.setLineAndColumn(3, 3, player1); // - - - X - -
            // - - - - - -
            // - - - - - -

            String expectedResult = "Player 1";

            // when
            String result = winner.showWinner();

            // then
            assertEquals(expectedResult, result);
        }

        @Test
        void calculateWinnerDiagonalRightToLeftBoard6x6ToWin4ForX() {
            // give
            State state = new State(6, 4);
            Winner winner = new Winner(state, player1, player2);

            // - - - - - -
            // - - - - - -
            state.setLineAndColumn(2, 3, player1); // - - - X - -
            state.setLineAndColumn(3, 2, player1); // - - X - - -
            state.setLineAndColumn(4, 1, player1); // - X - - - -
            state.setLineAndColumn(5, 0, player1); // X - - - - -

            String expectedResult = "Player 1";

            // when
            String result = winner.showWinner();

            // then
            assertEquals(expectedResult, result);
        }
    }

    @Nested
    @DisplayName("Tests for 10x10 Board")
    class TestsFor10x10Board {
        @Test
        void calculateWinnerHorizontalBoard10x10ToWin5ForX() {
            // give
            State state = new State(10, 5);
            Winner winner = new Winner(state, player1, player2);

            // - - - - - - - - - -
            // - - - - - - - - - -
            state.setLineAndColumn(2, 3, player1); // - - - X - - - - - -
            state.setLineAndColumn(3, 3, player1); // - - - X - - - - - -
            state.setLineAndColumn(4, 3, player1); // - - - X - - - - - -
            state.setLineAndColumn(5, 3, player1); // - - - X - - - - - -
            state.setLineAndColumn(6, 3, player1); // - - - X - - - - - -
            // - - - - - - - - - -
            // - - - - - - - - - -
            // - - - - - - - - - -

            String expectedResult = "Player 1";

            // when
            String result = winner.showWinner();

            // then
            assertEquals(expectedResult, result);
        }

        @Test
        void calculateWinnerVerticalBoard10x10ToWin5ForO() {
            // give
            State state = new State(10, 5);
            Winner winner = new Winner(state, player1, player2);

            // - - - - - - - - - -
            // - - - - - - - - - -
            // - - - - - - - - - -
            state.setLineAndColumn(3, 3, player1); // - - - X - - - - - -
            state.setLineAndColumn(4, 3, player1); // - - - X - - - - - -
            state.setLineAndColumn(5, 3, player1); // - - - X - O - - - -
            state.setLineAndColumn(6, 3, player1); // - - - X - O - - - -
            state.setLineAndColumn(5, 5, player2); // - - - - - O - - - -
            state.setLineAndColumn(6, 5, player2); // - - - - - O - - - -
            state.setLineAndColumn(7, 5, player2); // - - - - - O - - - -
            state.setLineAndColumn(8, 5, player2);
            state.setLineAndColumn(9, 5, player2);

            String expectedResult = "Player 2";

            // when
            String result = winner.showWinner();

            // then
            assertEquals(expectedResult, result);
        }

        @Test
        void calculateWinnerDrawBoard10x10ToWin5ForXO() {
            // give
            State state = new State(10, 5);
            Winner winner = new Winner(state, player1, player2);

            // - - - - - - - - - -
            // - - - - - - - - - -
            state.setLineAndColumn(2, 3, player1); // - - - X - - - - - -
            state.setLineAndColumn(3, 3, player1); // - - - X - - - - - -
            state.setLineAndColumn(4, 3, player1); // - - - X - - - - - -
            state.setLineAndColumn(5, 3, player1); // - - - X - O - - - -
            state.setLineAndColumn(6, 3, player1); // - - - X - O - - - -
            state.setLineAndColumn(5, 5, player2); // - - - - - O - - - -
            state.setLineAndColumn(6, 5, player2); // - - - - - O - - - -
            state.setLineAndColumn(7, 5, player2); // - - - - - O - - - -
            state.setLineAndColumn(8, 5, player2);
            state.setLineAndColumn(9, 5, player2);

            String expectedResult = "Nobody";

            // when
            String result = winner.showWinner();

            // then
            assertEquals(expectedResult, result);
        }
    }
}
