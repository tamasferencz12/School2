// Don't delete scanner import
import java.util.Scanner;

class Name {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    // use this program as a source of inspiration for your method
        String firstName0 = scanner.next();
        String lastName0 = scanner.next();
        System.out.println(createFullName(firstName0, lastName0));

        String firstName1 = scanner.next();
        String lastName1 = scanner.next();
        System.out.println(firstName1 + " " + lastName1);

        String firstName2 = scanner.next();
        String lastName2 = scanner.next();
        System.out.println(firstName2 + " " + lastName2);

        String firstName3 = scanner.next();
        String lastName3 = scanner.next();
        System.out.println(firstName3 + " " + lastName3);

    }

    //implement your method here
    public static String createFullName(String firstName0, String lastName0){
        return firstName0 + " " + lastName0;
    }
}