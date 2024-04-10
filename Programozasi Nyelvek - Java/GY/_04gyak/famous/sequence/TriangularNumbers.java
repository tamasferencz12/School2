package _04gyak.famous.sequence;

public static class TriangularNumbers{
    public static int getTriangularNumber(int n){
        int x = 0;
        for(int i = 0; i <= n; i++){
            x += i;
        }
        return x;
    }

    public static int getTriangularNumberAlternative(int n){
        return (n * (n + 1)) / 2;
    }
}