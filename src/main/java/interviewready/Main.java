package interviewready;

import interviewready.api.AIPlayer;
import interviewready.api.GameEngine;
import interviewready.api.RuleEngine;
import interviewready.game.Board;
import interviewready.game.Cell;
import interviewready.game.Move;
import interviewready.game.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        Board board = gameEngine.start("TicTacToe");
        AIPlayer aiPlayer=new AIPlayer();
        RuleEngine ruleEngine=new RuleEngine();
        int row, col;

        Scanner sc = new Scanner(System.in);

        while (!ruleEngine.getState(board).isOver()) {
            Player computer = new Player("0"), human = new Player("X");
            System.out.println("Make a Move!");
            System.out.println(board);
            row = sc.nextInt();
            col = sc.nextInt();

            Move oppMove = new Move(new Cell(row, col),human);
            gameEngine.move(board, oppMove);
            System.out.println(board);
            if (!ruleEngine.getState(board).isOver()) {
                Move computerMove = aiPlayer.suggestMove(computer, board);
                gameEngine.move(board, computerMove);
            }
        }

        System.out.println("Game Result =" + ruleEngine.getState(board));
        System.out.println(board);
    }
}
