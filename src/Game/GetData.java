package Game;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class GetData{
    static Scanner keyboard = new Scanner(System.in);

    private GetData(){}//private ctor

    public static byte getByte(){
        while(true){
            try{
                return  Byte.parseByte(keyboard.nextLine());
            } catch(NumberFormatException e){
                System.out.println(e);
            }//end try/catch
        }//end while
    }//end getByte

    public static byte getByte(byte x, byte y){
        while(true){
            try{
                byte number = Byte.parseByte(keyboard.nextLine());
                if((number > x) && (number < y)){
                    return number;
                } else{
                    System.out.println("number is not between " + x + " and " + y);
                }//end if/else
            } catch(NumberFormatException e){
                System.out.println(e);
            }//end try/catch
        }//end while
    }//end getByte

    public static short getShort(){
        while(true){
            try{
                return Short.parseShort(keyboard.nextLine());
            } catch(NumberFormatException e){
                System.out.println(e);
            }//end try/catch
        }//end while
    }//end getShort

    public static short getShort(short x, short y){
        while(true){
            try{
                short number = Short.parseShort(keyboard.nextLine());
                if((number > x) && (number < y)){
                    return number;
                } else{
                    System.out.println("number is not between " + x + " and " + y);
                }//end if/else
            } catch(NumberFormatException e){
                System.out.println(e);
            }//end try/catch
        }//end while
    }//end getShort

    public static int getInt(){
        while(true){
            try{
                return Integer.parseInt(keyboard.nextLine());
            } catch(NumberFormatException e){
                System.out.println(e);
            }//end try/catch
        }//end while
    }//end getInt

    public static int getInt(int x, int y){
        while(true){
            try{
                int number = Integer.parseInt(keyboard.nextLine());
                if((number > x) && (number < y)){
                    return number;
                } else{
                    System.out.println("number is not between " + x + " and " + y);
                }//end if/else
            } catch(NumberFormatException e){
                System.out.println(e);
            }//end try/catch
        }//end while
    }//end getByte

    public static long getLong(){
        while(true){
            try{
                return Long.parseLong(keyboard.nextLine());
            } catch(NumberFormatException e){
                System.out.println(e);
            }//end try/catch
        }//end while
    }//end getLong

    public static long getLong(long x, long y){
        while(true){
            try{
                long number = Long.parseLong(keyboard.nextLine());
                if((number > x) && (number < y)){
                    return number;
                } else{
                    System.out.println("number is not between " + x + " and " + y);
                }//end if/else
            } catch(NumberFormatException e){
                System.out.println(e);
            }//end try/catch
        }//end while
    }//end getLong

    public static float getFloat(){
        while(true){
            try{
                return Float.parseFloat(keyboard.nextLine());
            } catch(NumberFormatException e){
                System.out.println(e);
            }//end try/catch
        }//end while
    }//end getFloat

    public static float getFloat(float x, float y){
        while(true){
            try{
                float number = Float.parseFloat(keyboard.nextLine());
                if((number > x) && (number < y)){
                    return number;
                } else{
                    System.out.println("number is not between " + x + " and " + y);
                }//end if/else
            } catch(NumberFormatException e){
                System.out.println(e);
            }//end try/catch
        }//end while
    }//end getFloat

    public static double getDouble(){
        while(true){
            try{
                return Double.parseDouble(keyboard.nextLine());
            } catch(NumberFormatException e){
                System.out.println(e);
            }//end try/catch
        }//end while
    }//end getDouble

    public static double getDouble(double x, double y){
        while(true){
            try{
                double number = Double.parseDouble(keyboard.nextLine());
                if((number > x) && (number < y)){
                    return number;
                } else{
                    System.out.println("number is not between " + x + " and " + y);
                }//end if/else
            } catch(NumberFormatException e){
                System.out.println(e);
            }//end try/catch
        }//end while
    }//end getDouble

    public static boolean isEven(int x){
        return (x % 2) == 0;
    }//end isEven

    public static boolean isOdd(int x){
        return (x % 2) != 0;
    }//end isOdd

    public static double getSquareRoot(int x){
        int start = 0;
        int end = x;
        double root = 0.0;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if((mid * mid) > x){
                end = mid - 1;
            } else if((mid * mid) < x){
                start = mid + 1;
            } else{
                return mid;
            }//end if/else
        }//end while

        double incr = 0.1;

        for (int i = 0; i < 2; i++) {
            while (root * root < x) {
                root = root + incr;
            }//end while
            root = root - incr;
            incr = incr / 10;
        }//end for
        return root;
    }//end getSquareRoot

    public static double getSquareRoot(int num, int p){
        int start = 0;
        int end = num;
        double root = 0.0;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if((mid * mid) > num){
                end = mid - 1;
            } else if((mid * mid) < num){
                start = mid + 1;
            } else{
                return mid;
            }//end if/else
        }//end while

        double incr = 0.1;

        for (int i = 0; i < p; i++) {
            while (root * root < num) {
                root = root + incr;
            }//end while
            root = root - incr;
            incr = incr / 10;
        }//end for

        return root;
    }//end getSquareRoot

    public static int getGreatestCommonDivisor(int x, int y){
        if(x == 0){
            return y;
        }//end if
        return getGreatestCommonDivisor(x, y % x);
    }//getGreatestCommonDivisor

    public static int getLeastCommonMultiplier(int a,int b){
        int max=a>b?a:b;
        int min=a<b ?a:b;

        for(int i=1;i<=min;i+=1){
            int prod=max*i;
            if(prod%min==0){
                return prod;
            }//end if
        }//end for
        return max*min;
    }//end getLeastCommonMulitplier

    public static boolean isPrime(int number){
        if(number< 3){
            return true;
        }//end if

        // check if n is a multiple of 2
        if(number%2==0){
            return false;
        }//end if

        // if not, then just check the odds
        for(var i = 3; i * i <= number; i += 2){
            if(number % i == 0){
                return false;
            }//end if
        }//end for
        return true;
    }//end isPrime
}//end GetData