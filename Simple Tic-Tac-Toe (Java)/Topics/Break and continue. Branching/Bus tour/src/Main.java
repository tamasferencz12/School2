import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        int N = scanner.nextInt();
        int[] bridges = new int[N];

        for (int i = 0; i < N; i++) {
            bridges[i] = scanner.nextInt();
        }
        int j = 0;

        for (int i = 0; i < N; i++) {
            if (height >= bridges[i]){
                System.out.println("Will crash on bridge " + (i+1));
                break;
            }else{
                j++;
            }
        }
        if (j == N){
            System.out.println("Will not crash");
        }
    }
}