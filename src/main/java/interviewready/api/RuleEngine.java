package interviewready.api;

import interviewready.board.TicTacToeBoard;
import interviewready.game.Board;
import interviewready.game.GameState;
import interviewready.game.Player;

public class RuleEngine {

//single responsibility principle : do 1 thing at a time

    public GameState getState(Board board) {
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            String firstChar = "-";
            boolean rowCompleted = true;

            for (int i = 0; i < 3; i++) {
                firstChar = board1.getCell(i, 0);
                rowCompleted = firstChar != null;
                if (firstChar != null) {
                    for (int j = 0; j < 3; j++) {
                        if (!firstChar.equals(board1.getCell(i, j))) {
                            rowCompleted = false;
                            break;
                        }
                    }
                }

                if (rowCompleted) {
                    break;
                }

            }

            if (rowCompleted)
                return new GameState(true, firstChar);

            boolean colComplete = true;
            for (int i = 0; i < 3; i++) {
                firstChar = board1.getCell(0, i);
                colComplete = firstChar != null;

                if (firstChar != null) {

                    for (int j = 1; j < 3; j++) {
                        if (!firstChar.equals(board1.getCell(i, j))) {
                            colComplete = false;
                            break;
                        }
                    }
                }

                if (colComplete) {
                    break;
                }
            }
            if (colComplete)
                return new GameState(true, firstChar);


            firstChar = board1.getCell(0, 0);
            boolean diagCompleted = firstChar != null;
            for (int i = 1; i < 3; i++) {
                if (firstChar != null && !firstChar.equals(board1.getCell(i, i))) {
                    diagCompleted = false;
                    break;
                }


            }

            if (diagCompleted)
                return new GameState(true, firstChar);

            firstChar = board1.getCell(0, 2);

            diagCompleted = firstChar != null;
            for (int i = 1; i < 3; i++) {
                if (firstChar != null && !firstChar.equals(board1.getCell(i, 2 - i))) {
                    diagCompleted = false;
                    break;
                }


            }

            if (diagCompleted)
                return new GameState(true, firstChar);

            int countOfFilledCells = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board1.getCell(i, j) != null) {
                        countOfFilledCells++;
                    }
                }
            }

            if (countOfFilledCells == 9) {
                return new GameState(true, "-");
            } else {
                return new GameState(false, "-");
            }


        }
        return new GameState(false, "");
    }
}
