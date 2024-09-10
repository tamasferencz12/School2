import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        // function calls of isDivByThree, isDivByFive, isDivByThreeAndFive will be here
        if(isDivByThreeAndFive(num)){
            System.out.println("FizzBuzz");
        } else if (isDivByFive(num)) {
            System.out.println("Buzz");
        } else if (isDivByThree(num)) {
            System.out.println("Fizz");
        }else {
            System.out.println("None");
        }
    }

    // function isDivByThree will be here
        public static boolean isDivByThree(int num){
            return num % 3 == 0;
        }

    // function isDivByFive will be here
    public static boolean isDivByFive(int num){
        return num % 5 == 0;
    }

    // function isDivByThreeAndFive will be here
    public static boolean isDivByThreeAndFive(int num){
        return num % 5 == 0 && num % 3 == 0;
    }
}