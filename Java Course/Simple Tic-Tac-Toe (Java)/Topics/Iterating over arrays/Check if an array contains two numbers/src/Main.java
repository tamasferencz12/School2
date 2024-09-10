import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean result = false;

        for (int i = 0; i < N - 1; i++) {
            if((arr[i] == n && arr[i+1] == m) || (arr[i] == m && arr[i+1] == n) ){
                result = true;
                break;
            }
        }
        System.out.println(result);
    }
}