import java.util.Scanner;

class MultipleFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        System.out.println(f(x));
    }

    public static double f(double x) {
        double result = 0;
        if (x <= 0){
            result = f1(x);
        }
        if ( x > 0 && x < 1){
            result = f2(x);
        }
        if (x >= 1) {
            result = f3(x);
        }
        return result;
    }

    //implement your methods here
    public static double f1(double x){
        return Math.pow(x,2)+1;
    }

    public static double f2(double x){
        return 1 / Math.pow(x,2);
    }

    public static double f3(double x){
        return Math.pow(x,2)-1;
    }
}