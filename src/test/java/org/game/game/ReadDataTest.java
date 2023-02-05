package org.game.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ReadDataTest {

    @Nested
    @DisplayName("Read Board size")
    class ReadBoardSize {
        @ParameterizedTest
        @ValueSource(strings = {"2","11","-1","0"})
        void readBoardSize(String input) {
            // give
            ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            // when & then
            assertThrows(InputMismatchException.class, () -> ReadData.readBoardSize());
        }

        @ParameterizedTest
        @ValueSource (strings = {"xyz","XYZ"})
        void readBoardSizeNotDigit(String input) {
            // give
            ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            // when & then
            assertThrows(NumberFormatException.class, () -> ReadData.readBoardSize());
        }
    }

    @Nested
    @DisplayName("Read toWin")
    class ToWin {
        @ParameterizedTest
        @ValueSource(strings = {"1","7","-1","0"})
        void readToWinLessThan2AndMoreThan6(String input) {
            // give
            ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            // when & then
            assertThrows(InputMismatchException.class, () -> ReadData.readToWin());
        }

        @ParameterizedTest
        @ValueSource (strings = {"xyz","XYZ"})
        void readToWinNotDigit(String input) {
            // give
            ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            // when & then
            assertThrows(NumberFormatException.class, () -> ReadData.readToWin());
        }

    }

    @Nested
    @DisplayName("Read Symbol")
    class ReadSymbol {
        @ParameterizedTest
        @ValueSource (strings = {"C","c","wsx","WSX","123","1","6","-1","0"})
        void readSymbol(String input) {
            // give
            ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            // when & then
            assertThrows(InputMismatchException.class, () -> ReadData.readSymbol());
        }
    }

    @Nested
    @DisplayName("Read Line and Column")
    class ReadLine {
        @ParameterizedTest
        @ValueSource (strings = {"abc","ABC","c","C"})
        void readLineNotDigit(String input) {
            // give
            ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            int sizeOfBoard = 3;

            //when & then
            assertThrows(NumberFormatException.class, () -> ReadData.readLineAndColumn(sizeOfBoard));
        }

        @ParameterizedTest
        @ValueSource (strings = {"4","-1"})
        void readLineCheckSizeOfBoard(String input) {
            // give
            ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            int sizeOfBoard = 3;

            //when & then
            assertThrows(InputMismatchException.class, () -> ReadData.readLineAndColumn(sizeOfBoard));
        }
    }

    @Nested
    @DisplayName("Game Menu")
    class GameMenu {
        @ParameterizedTest
        @ValueSource (strings = {"123","0","6"})
        void readGameMenuNumbers(String input) {
            // give
            ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            // when & then
            assertThrows(NumberFormatException.class, () -> ReadData.readGameMenu());
        }

        @ParameterizedTest
        @ValueSource (strings = {"z","Z","xyz","XYZ"})
        void readGameMenuNotNorX(String input) {
            // give
            ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            // when & then
            assertThrows(InputMismatchException.class, () -> ReadData.readGameMenu());
        }
    }

    @Nested
    @DisplayName("Game Options")
    class GameOptions {
        @ParameterizedTest
        @ValueSource (strings = {"0","-1","6"})
        void readGameMenuNumbersForDigits(String input) {
            // give
            ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            // when & then
            assertThrows(InputMismatchException.class, () -> ReadData.readGameOptions());
        }

        @ParameterizedTest
        @ValueSource (strings = {"a","A","xyz"})
        void readGameMenuNumbersForLetters(String input) {
            // give
            ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            // when & then
            assertThrows(NumberFormatException.class, () -> ReadData.readGameOptions());
        }
    }
}