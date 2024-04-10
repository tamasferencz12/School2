
public class T6 {
    // Ferencz Tamas G0820E
    public static void main(String[] args) {
        System.out.println("Enter a number:");
        float num1 = Integer.parseInt(System.console().readLine());
        System.out.println("Enter another number:");
        float num2 = Integer.parseInt(System.console().readLine());

        for (int i = (int) num1 + 1; i < (int) num2; i++) {
            System.out.println(i / 2);
        }
    }
}