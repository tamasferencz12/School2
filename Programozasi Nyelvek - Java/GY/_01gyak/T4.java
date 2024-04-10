
public class T4 {
    // Ferencz Tamas G0820E
    public static void main(String[] args) {

        if (args.length > 0) {
            String name = args[0];
            System.out.println("Hello " + name + "!");
        } else {
            System.out.println("Enter your name:");
            String str = System.console().readLine();
            System.out.println("Hello " + str + "!");
        }

    }
}