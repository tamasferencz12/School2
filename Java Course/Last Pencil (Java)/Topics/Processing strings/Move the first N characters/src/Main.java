import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = scanner.nextInt();

        char[] sCharArr = s.toCharArray();
        if (n == 0 || n > s.length()){
            System.out.println(s);
        }else {
            for (int i = 0; i < n; i++) {
                move(sCharArr);
            }

            String resultString = new String(sCharArr);
            System.out.println(resultString);
        }
    }

    private static void move(char[] arr){
        char first = arr[0];
        for (int i = 0; i < arr.length-1 ; i++) {
            arr[i] = arr[i+1];
        }
        arr[arr.length - 1] = first;
    }
}