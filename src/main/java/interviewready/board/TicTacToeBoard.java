package interviewready.board;

import interviewready.game.Board;
import interviewready.game.Cell;
import interviewready.game.Move;

public class TicTacToeBoard extends Board {

    String cells[][] =new String[3][3];
    public void setCell(Cell cell, String symbol) {
        cells[cell.getRow()][cell.getCol()]=symbol;
    }

    public String[][] getCells() {
        return cells;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                 sb.append(cells[i][j]==null?"-":cells[i][j]);
            }
        }
        return sb.toString();
    }

    @Override
    public void move(Move move) {
        setCell(move.getCell(),move.getPlayer().getSymbol());
    }

    public String getCell(int i, int j) {
        return cells[i][j];
    }
}
