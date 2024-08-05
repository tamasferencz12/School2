import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        float sum = 0;
        int totalNum = 0;

        for (int i = a; i <= b; i++) {
            if (i % 3 == 0) {
                sum +=i;
                totalNum++;
            }

        }
        System.out.println((float) sum / totalNum);
    }
}