import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int max = -1;
        int mult;

        for (int i = 0; i < n - 1; i++) {
            mult = arr[i] * arr[i+1];
            if ( mult > max){
                max = mult;
            }
        }
        System.out.println(max);
    }
}