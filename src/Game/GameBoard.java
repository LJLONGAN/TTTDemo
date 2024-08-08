package Game;

import java.util.Random;

import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;

public class GameBoard {
    private final char[][] gameBoard;
    private boolean playerX;
    private String winner;

    public GameBoard(){
        gameBoard = new char[][] {
                {' ',' ',' '},
                {' ',' ',' '},
                {' ',' ',' '}
        };
        Random random = new Random();
        playerX = random.nextBoolean();
        if(playerX){
            System.out.println("X goes first!");
        } else {
            System.out.println("O goes first!");
        }//end if/else
        winner = null;
    }//ctr

    public void getBoard(){
        System.out.println(
                        gameBoard[0][0] + " | " + gameBoard[0][1] + " | " + gameBoard[0][2] + "\n" +
                        "---------\n" +
                        gameBoard[1][0] + " | " + gameBoard[1][1] + " | " + gameBoard[1][2] + "\n" +
                        "---------\n" +
                        gameBoard[2][0] + " | " + gameBoard[2][1] + " | " + gameBoard[2][2]
        );
    }//end getBoard

    public void setX(int y, int x){
        //sets char X to array y, element x
        y--;
        x--;
        gameBoard[y][x] = 'X';
    }//end setX

    public void setO(int y, int x){
        //sets char O to array y, element x
        y--;
        x--;
        gameBoard[y][x] = 'O';
    }//end setO

    public boolean checkArray(int y, int x){
        //checks gameBoard[y][x] if space is taken and returns true if open
        y--;
        x--;
        char someChar = gameBoard[y][x];
        return !(someChar == 'X' || someChar == 'O');
    }//end checkArray

    public void gameLoop(){
        if(playerX){
            System.out.println("X's turn!");
            while(playerX){
                System.out.print("Row: ");
                int y = GetData.getInt(0,4);
                System.out.print("Col: ");
                int x = GetData.getInt(0,4);
                if(checkArray(y,x)) {
                    setX(y, x);
                    playerX = !playerX;
                } else {
                    System.out.println("Not a open space, please choose a different space.");
                }//end if/else
            }//end
        } else {
            System.out.println("O's turn!");
            while(!playerX){
                System.out.print("Row: ");
                int y = GetData.getInt(0,4);
                System.out.print("Col: ");
                int x = GetData.getInt(0,4);
                if(checkArray(y,x)) {
                    setO(y, x);
                    playerX = !playerX;
                } else {
                    System.out.println("Not a open space, please choose a different space.");
                }//end if/else
            }//end while
        }//end if/else
        getBoard();
    }//end turn

    public boolean getWinner(){
        //checks each row for winner
        for(int y = 0; y < gameBoard.length; y++)
            for(int x = 0; x < 1; x++){
                if ((!(gameBoard[y][x] == ' ') && gameBoard[y][x] == gameBoard[y][x+1]) &&
                        gameBoard[y][x+1] == gameBoard[y][x+2]){
                    winner = String.valueOf(gameBoard[y][x]);
                    System.out.println(winner + " IS THE WINNER!");
                    return false;
                }//end if
        }//end nested for

        //checks each col for winner
        for(int y = 0; y < 1; y++)
            for(int x = 0; x < gameBoard.length; x++){
                if (!(gameBoard[y][x] == ' ') && gameBoard[y][x] == gameBoard[y+1][x] &&
                        gameBoard[y+1][x] == gameBoard[y+2][x]){
                    winner = String.valueOf(gameBoard[y][x]);
                    System.out.println(winner + " IS THE WINNER!");
                    return false;
                }//end if
        }//end nested for

        //checks each dia for winner
        for(int y = 0; y < gameBoard.length; y += 2)
            for(int x = 2; x > 1; x--){
                if (!(gameBoard[y][0] == ' ') && gameBoard[y][0] == gameBoard[1][1] &&
                        gameBoard[1][1] == gameBoard[x-y][2]){
                    winner = String.valueOf(gameBoard[1][1]);
                    System.out.println(winner + " IS THE WINNER!");
                    return false;
                }//end if
        }//end nested for

        //checks for cat's game
        char[] gameArray = new char[9];
        int k = 0;
        for(int y = 0; y < gameBoard.length; y++) {
            for(int x = 0; x < gameBoard.length; x++){
                gameArray[k] = gameBoard[y][x];
                k++;
            }
        }//end nested for
        sort(gameArray);
        int cat = binarySearch(gameArray, ' ');
        if(cat == -1){
            winner = "Cat";
            System.out.println(winner + "'s GAME!");
            return false;
        }//end if
        return true;
    }//end getWinner
}//end GameBoard