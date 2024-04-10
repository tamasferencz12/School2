
public class T8 {
    // Ferencz Tamas G0820E
    public static void main(String[] args) {

        if (args.length != 1) {
            System.exit(-1);
        }

        String fact = args[0];
        int s = 1;

        for (int i = 1; i < Integer.parseInt(fact); i++) {
            s = s * i;
        }
        System.out.println(fact + " factorial is: " + s + "!");
    }
}