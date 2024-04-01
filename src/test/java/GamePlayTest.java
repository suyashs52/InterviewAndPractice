import interviewready.api.AIPlayer;
import interviewready.api.GameEngine;
import interviewready.api.RuleEngine;
import interviewready.game.Board;
import interviewready.game.Cell;
import interviewready.game.Move;
import interviewready.game.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class GamePlayTest {

    GameEngine gameEngine;
    Board board;
    AIPlayer aiPlayer;

    RuleEngine ruleEngine;

    @Before //run before every test
    public void setUp() {
        gameEngine = new GameEngine();
        board = gameEngine.start("TicTacToe");
        aiPlayer = new AIPlayer();
        ruleEngine = new RuleEngine();
    }

    //we will test behaviour not the class Behaviour Driven Test

    @Test
    public void checkForRowWin() {

        int row, col;

        Scanner sc = new Scanner(System.in);
        int next = 0;
        int moves[][] = new int[][]{{1, 0}, {1, 1}, {1, 2}};
        while (!ruleEngine.getState(board).isOver()) {
            Player computer = new Player("0"), human = new Player("X");
            System.out.println("Make a Move!");
            System.out.println(board);
            row = moves[next][0];
            col = moves[next][1];
            next++;
            Move oppMove = new Move(new Cell(row, col), human);
            gameEngine.move(board, oppMove);
            System.out.println(board);
            if (!ruleEngine.getState(board).isOver()) {
                Move computerMove = aiPlayer.suggestMove(computer, board);
                gameEngine.move(board, computerMove);
            }
        }

        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(),"X");

    }
}
