package interviewready.game;

public class GameState {
    boolean isOver;
    Player winner;
    String firstChar;
    public GameState(boolean isOver
            , String firstChar) {
        this.isOver=isOver;
        if(isOver){
            winner=new Player(firstChar);
        }
        this.firstChar=firstChar;
    }

    public boolean isOver() {
        return isOver;
    }

    public String getWinner(){
        return winner.getSymbol();
    }
}
