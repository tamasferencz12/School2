import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String sUpdated = s.toLowerCase(Locale.ROOT);
        char[] c = sUpdated.toCharArray();
        int sum = 0;

        for (char value : c) {
            if (value == 'c' || value == 'g') {
                sum++;
            }
        }
        double result = (double) sum * 100 / c.length;
        System.out.println(result);
    }
}