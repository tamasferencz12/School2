import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int r1 = scanner.nextInt();
        int r2 = scanner.nextInt();

        System.out.println(word.subSequence(r1,r2+1));
    }
}