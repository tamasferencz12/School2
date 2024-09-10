import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        char[] charArrayFromString = input.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < charArrayFromString.length; i++) {
            result.append(charArrayFromString[i]).append(charArrayFromString[i]);
        }

        System.out.println(result);
    }
}