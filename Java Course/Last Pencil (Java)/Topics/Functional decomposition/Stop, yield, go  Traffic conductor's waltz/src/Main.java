import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentState = scanner.nextInt();
        scanner.close();

        String nextState = getNextState(currentState);
        String action = getAction(currentState);

        System.out.println(nextState);
        System.out.println(action);
    }

    public static String getNextState(int currentState) {
        String x = "";
        switch (currentState){
            case 0 :
                x = "1";
                break;
            case 1 :
                x = "2";
                break;
            case 2 :
                x = "0";
                break;
            default:
                break;
        }
        return x;
    }

    public static String getAction(int currentState) {
        String action = "";
        switch (currentState){
            case 0 :
                action = "Change to Yellow";
                break;
            case 1 :
                action = "Change to Green";
                break;
            case 2 :
                action = "Change to Red";
                break;
            default:
                break;
        }
        return action;
    }
}