import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // Declare and initialize the array
        float[] array = new float[n];
        // Read temperature values
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextFloat();
        }
        // Calculate average, highest, and count above 30.0°C
        float sum = 0;
        int aboveThirty = 0;
        float max = array[0];

        for (int i = 0; i < n; i++) {
            sum+=array[i];
            if (array[i] > 30.0) {
                aboveThirty++;
            }
            if (array[i] > max){
                max = array[i];
            }
        }
        // Print results

        System.out.println("Average: " + String.format("%.1f", (sum / n)));
        System.out.println("Highest: " + max );
        System.out.println("Above 30.0°C: " + aboveThirty);

        scanner.close();
    }
}