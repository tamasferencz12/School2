import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define pi as a constant
        final double pi = Math.PI;
        // Read the radius from user input
        double radius = scanner.nextDouble();
        // Calculate the area of the circle
        double area = pi * Math.pow(radius,2);
        // Round the result to two decimal places
        area = Math.round(area*100.0)/100.0;

        // Print the result
        System.out.println(area);
    }
}