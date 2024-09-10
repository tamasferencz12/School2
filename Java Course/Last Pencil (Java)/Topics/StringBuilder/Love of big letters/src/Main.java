import java.util.Arrays;
import java.util.Scanner;

class EvenUpperCase {

    public static String upperEvenLetters(String message) {
        char[] builderInChar = message.toCharArray();
        for (int i = 0; i < builderInChar.length; i++) {
            if (i % 2 == 0){
                builderInChar[i] = Character.toUpperCase(builderInChar[i]);
            }
        }
        return new String(builderInChar);
    }

    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.next();

        System.out.println(upperEvenLetters(message));
    }
}