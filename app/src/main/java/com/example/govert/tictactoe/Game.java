package com.example.govert.tictactoe;

import static com.example.govert.tictactoe.GameState.DRAW;
import static com.example.govert.tictactoe.GameState.IN_PROGRESS;
import static com.example.govert.tictactoe.GameState.PLAYER_ONE_WIN;
import static com.example.govert.tictactoe.GameState.PLAYER_TWO_WIN;

public class Game {
    final private int BOARD_SIZE = 3;
    private TileState[][] board;
    private boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    private boolean gameOver;

    public Game() {
        board = new TileState[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = TileState.BLANK;

        playerOneTurn = true;
        gameOver = false;
    }

    public TileState choose(int row, int column) {
        TileState StateOfTile = board[row][column];
        if(StateOfTile.BLANK == TileState.BLANK) {
            if(playerOneTurn) {
                board[row][column] = TileState.CROSS;
                playerOneTurn = false;
                return TileState.CROSS;
            }
            else {
                board[row][column] = TileState.CIRCLE;
                playerOneTurn = true;
                return TileState.CIRCLE;
            }
        }
        else {
            return TileState.INVALID;
        }
    }

    public GameState won() {
//        check player 1 win
//        check rows
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0].equals(board[i][1])
                    && board[i][0].equals(board[i][2])
                    && board[i][0].equals(TileState.CROSS)) {
                return PLAYER_ONE_WIN;
            }
        }
//        check columns
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[0][i].equals(board[1][i])
                    && board[0][i].equals(board[2][i])
                    && board[0][i].equals(TileState.CROSS)) {
                return PLAYER_ONE_WIN;
            }
//            check player 2 win
//            check rows
        }
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0].equals(board[i][1])
                    && board[i][0].equals(board[i][2])
                    && board[i][0].equals(TileState.CIRCLE)) {
                return PLAYER_TWO_WIN;
            }
        }
//        check columns
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[0][i].equals(board[1][i])
                    && board[0][i].equals(board[2][i])
                    && board[0][i].equals(TileState.CIRCLE)) {
                return PLAYER_TWO_WIN;
            }
        }
//        check for draw
        int counter = 0;
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                if(!(board[i][j] == TileState.BLANK))
                    counter += 1;
                    if(counter == 9)
                        return DRAW;

        return IN_PROGRESS;
    }
}
