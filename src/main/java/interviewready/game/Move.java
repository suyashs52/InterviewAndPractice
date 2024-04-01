package interviewready.game;

public class Move {
    Cell cell;

    Player player;

    public Move(Cell cell,Player player){
        this.cell=cell;
        this.player=player;
    }

    public Cell getCell() {
        return this.cell;

    }

    public Player getPlayer() {
        return player;
    }
}
