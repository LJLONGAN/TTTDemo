package Game;

public class Demo {
    public static void main(String[] args){
        GameBoard game = new GameBoard();
        game.getBoard();
        boolean run = true;
        while(run){
            game.gameLoop();
            run = game.getWinner();
        }//end while
    }//end main
}
