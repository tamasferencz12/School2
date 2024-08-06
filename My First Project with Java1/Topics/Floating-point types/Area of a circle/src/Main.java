import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double s;
        double pi = Math.PI;
        double r = scanner.nextDouble();
        s = pi * Math.pow(r,2);
        System.out.println(s);
    }
}