import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if(arr[i] > n){
                sum += arr[i];
            }
        }
        System.out.println(sum);
    }
}