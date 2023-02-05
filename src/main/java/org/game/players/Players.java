package org.game.players;

import java.util.Random;

public class Players {
    private String playerName;
    private char symbol;

    public Players(String playerName) {
        this.playerName = playerName;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int randomMoveForComputer(final int sizeOfBoard){
        Random random = new Random();

        return random.nextInt(sizeOfBoard);
    }
}
