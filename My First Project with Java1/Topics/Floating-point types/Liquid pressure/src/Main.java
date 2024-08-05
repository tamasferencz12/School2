import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double p;
        double g = 9.8;
        double q = scanner.nextDouble();
        double h = scanner.nextDouble();
        p = g*q*h;
        System.out.println(p);
    }
}