
public class T7 {
    // Ferencz Tamas G0820E
    public static void main(String[] args) {

        if (args.length != 1) {
            System.exit(-1);
        }

        String num1 = args[0];
        String num2 = args[1];

        System.out.println("a + b: " + (Integer.parseInt(num1) + Integer.parseInt(num2)));
        System.out.println("a - b: " + (Integer.parseInt(num1) - Integer.parseInt(num2)));
        System.out.println("a * b: " + (Integer.parseInt(num1) * Integer.parseInt(num2)));
        System.out.println("a / b: " + ((Integer.parseInt(num2) == 0) ? "Can't devide with 0"
                : (Integer.parseInt(num1) / Integer.parseInt(num2))));
        System.out.println("a % b: " + ((Integer.parseInt(num2) == 0) ? "Can't devide with 0"
                : (Integer.parseInt(num1) % Integer.parseInt(num2))));
    }
}