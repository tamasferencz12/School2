package _06gyak.array.util.main;

public class ArrayUtil{
    public static int max(int[] n){

        if(n.length == 0){
            return 0;
        }else{
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < n.length; i++){
                if(n[i] > max){
                    max = n[i];
                }
            }
            return max;
        }
    }

    public static int max2(int[] n){
        if(n.length == 0){
            return 0;
        }else{
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < n.length; i++){
               max = (n[i] > max) ? n[i] : max;
            }
            return max;
        }
    }

    public static int max3(int[] n){
        if(n.length == 0){
            return 0;
        }else{
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < n.length; i++){
                max = Math.max(n[i], max);
            }
            return max;
        }
    }

    public static int max4(int[] n){
        int max = Integer.MIN_VALUE;
        if(n.length == 0){
            return 0;
        }for(int element : n){
           max = (element > max) ? element : max ; 
        }
        return max;
    }
    public static int[] minMax(int[] n){
        int[] x = new int[2];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n.length; i++){
           max = (n[i] > max) ? n[i] : max ; 
           min = (n[i] < min) ? n[i] : min ; 
        }
        x[0] = min;
        x[1] = max;
        return x;
    }
}