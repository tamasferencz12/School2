import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arr = new String[n+1];
        int sumD = 0;
        int sumC = 0;
        int sumB = 0;
        int sumA = 0;

        for (int i = 0; i <= n; i++) {
            arr[i] = scanner.nextLine();
        }
        for (int i = 0; i <= n; i++) {
            if (arr[i].equals("D")) {
                sumD ++;
            }
            if (arr[i].equals("C")) {
                sumC ++;
            }
            if (arr[i].equals("B")) {
                sumB ++;
            }
            if (arr[i].equals("A")) {
                sumA ++;
            }
        }
        System.out.println(sumD + " " + sumC + " " + sumB + " " + sumA);

    }
}