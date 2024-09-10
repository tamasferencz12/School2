import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(); // uppercase letters
        int b = scanner.nextInt(); // lowercase letters
        int c = scanner.nextInt(); // digits
        int n = scanner.nextInt(); // symbols count

        String pattern1 = "ABCDEF";
        String pattern2 = "abcdef";
        String pattern3 = "123456";

        String part1 = fill(pattern1, a);
        String part2 = fill(pattern2, b);
        String part3 = fill(pattern3, c);

        String pass = part1.concat(part2).concat(part3);
        if (pass.isEmpty()) {
            System.out.println(n >= 0 && n <= 1 ? "0" : fill("01", n));
        } else if (pass.length() == 1) {
            String pattern = part1.length() == 1 ? pattern1 : part2.length() == 1 ? pattern2 : pattern3;
            System.out.println(fill(pattern, n));
        } else {
            System.out.println(fill(pass, n));
        }

    }

    private static String fill(String pattern, int count) {
        int size = count / pattern.length();
        int remaining = count % pattern.length();
        return (size > 0 ? pattern.repeat(size) : "").concat(pattern.substring(0, remaining));
    }
}