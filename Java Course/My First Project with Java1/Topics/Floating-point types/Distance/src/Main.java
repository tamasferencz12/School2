import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int miles = scanner.nextInt();
        int hours = scanner.nextInt();
        System.out.println(miles /  hours);
    }
}