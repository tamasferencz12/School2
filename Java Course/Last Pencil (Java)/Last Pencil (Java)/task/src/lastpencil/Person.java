package lastpencil;

import java.util.Scanner;

public class Person extends Player {
    public Person(String name) {
        super(name);
    }


    @Override
    public int getRemoveCount(String actualPencils) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int count = getInteger(scanner.nextLine());
            if (count < 1 || count > 3) {
                System.out.println("Possible values: '1', '2' or '3'");
            } else if (count > actualPencils.length()) {
                System.out.println("Too many pencils were taken");
            } else {
                return count;
            }
        }
    }

    public int getInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}