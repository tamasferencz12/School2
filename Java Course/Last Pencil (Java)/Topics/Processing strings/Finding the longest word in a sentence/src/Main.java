import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        String[] separetedSentence = sentence.split(" ");
        String max = separetedSentence[0];
        for (String s : separetedSentence) {
            if (s.length() > max.length()) {
                max = s;
            }
        }
        System.out.println(max);
    }
}