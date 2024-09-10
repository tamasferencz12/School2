import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        char[] charFromString = input.toCharArray();
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < charFromString.length) {
            char selectedChar = charFromString[i];
            int count = 0;

            while (i < charFromString.length && charFromString[i] == selectedChar) {
                count++;
                i++;
            }
            result.append(selectedChar).append(count);
        }
        System.out.println(result.toString());
    }
}