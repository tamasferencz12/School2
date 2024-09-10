import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int j = 0;
        while (j < 10) {
            j++;
            if (j == 5) {
                continue;
            }
            System.out.print(j);
        }
    }
}