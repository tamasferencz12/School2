import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int bestSeed = A;
        int minMaxValue = Integer.MAX_VALUE;

        for (int seed = A; seed <= B; seed++) {
            Random rand = new Random(seed);
            int maxValue = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                int number = rand.nextInt(K);
                if (number > maxValue) {
                    maxValue = number;
                }
            }

            if (maxValue < minMaxValue) {
                minMaxValue = maxValue;
                bestSeed = seed;
            }
        }

        System.out.println(bestSeed);
        System.out.println(minMaxValue);
    }
}
