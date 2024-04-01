package interviewready.api;

import interviewready.board.TicTacToeBoard;
import interviewready.game.Board;
import interviewready.game.Move;

public class GameEngine {

    public Board start(String type) {
        if ("TicTacToe".equals(type)) {
            return new TicTacToeBoard();
        } else {
            throw new IllegalArgumentException();
        }


    }


    public void move(Board board, Move move) {

        if (board instanceof TicTacToeBoard) {
            board.move(move);

        } else {
            throw new IllegalArgumentException();
        }

    }

}
