package lastpencil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many pencils would you like to use:");
        int pencil = scanner.nextInt();
        System.out.println("Who will be the first (John, Jack):");
        String name = scanner.next();

        for (int i = 1; i <= pencil; i++) {
            System.out.print("|");
        }
        System.out.println();

        if(name.equals("John")){
            System.out.print("John is going first!");
        }else if(name.equals("Jack")){
            System.out.print("Jack is going first!");
        }
    }
}
