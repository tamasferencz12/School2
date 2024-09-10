import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        StringBuilder stringBuilder = new StringBuilder(s);
        String stringReversed = stringBuilder.reverse().toString();

        if (s.equals(stringReversed)){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}