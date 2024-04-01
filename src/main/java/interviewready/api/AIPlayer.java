package interviewready.api;

import interviewready.board.TicTacToeBoard;
import interviewready.game.Board;
import interviewready.game.Cell;
import interviewready.game.Move;
import interviewready.game.Player;

public class AIPlayer {


    public Move suggestMove(Player computer, Board board) {
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    return new Move(new Cell(i, j), computer);
                }
            }
        }
        throw new IllegalArgumentException();
    }
}
