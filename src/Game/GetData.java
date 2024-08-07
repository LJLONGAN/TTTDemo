package Game;

import java.util.Scanner;

public class GetData {

    private final static Scanner scanner = new Scanner(System.in);

    private GetData(){}//private ctr

    public static int getInt(){
        return scanner.nextInt();
    }//end getInt

    public static int getInt(int x, int y){
        return scanner.nextInt();
    }//end getInt
}
