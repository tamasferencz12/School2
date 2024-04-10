package _05gyak.math.operation.safe;

public class Increment{
    public static int increment(int n){
        if(n == Integer.MAX_VALUE){
            return n;
        }else{
            return n + 1;
        }

    }
}