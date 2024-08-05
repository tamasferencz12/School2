package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //String input = scanner.nextLine(); // no need to get input string, it's empty

        printBlanc();
        place("         ");

        //print(input);
        //String result = calculateResult(input);
        //System.out.println(result);
    }

    public static void printBlanc(){
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print("  ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }
    public static void print(String input){

        System.out.println("---------");
        System.out.println("| " + replaceUnderScore(input.charAt(0)) + " " + replaceUnderScore(input.charAt(1)) + " " + replaceUnderScore(input.charAt(2)) + " |");
        System.out.println("| " + replaceUnderScore(input.charAt(3)) + " " + replaceUnderScore(input.charAt(4)) + " " + replaceUnderScore(input.charAt(5)) + " |");
        System.out.println("| " + replaceUnderScore(input.charAt(6)) + " " + replaceUnderScore(input.charAt(7)) + " " + replaceUnderScore(input.charAt(8)) + " |");
        System.out.println("---------");


    }
    private static char replaceUnderScore(char c){
        return c == '_' ? ' ' : c;
    }
    public static String calculateResult(String input){
        int xCount = 0;
        int oCount = 0;
        int emptyCount = 0;

        for (char c : input.toCharArray()) {
            if (c == 'X') xCount++;
            else if (c == 'O') oCount++;
            else emptyCount++;
        }

        if (Math.abs(xCount - oCount) > 1) return "Impossible";

        boolean xWins = (input.charAt(0) == 'X' && input.charAt(1) == 'X' && input.charAt(2) == 'X') || // Row 1
                (input.charAt(3) == 'X' && input.charAt(4) == 'X' && input.charAt(5) == 'X') || // Row 2
                (input.charAt(6) == 'X' && input.charAt(7) == 'X' && input.charAt(8) == 'X') || // Row 3
                (input.charAt(0) == 'X' && input.charAt(3) == 'X' && input.charAt(6) == 'X') || // Col 1
                (input.charAt(1) == 'X' && input.charAt(4) == 'X' && input.charAt(7) == 'X') || // Col 2
                (input.charAt(2) == 'X' && input.charAt(5) == 'X' && input.charAt(8) == 'X') || // Col 3
                (input.charAt(0) == 'X' && input.charAt(4) == 'X' && input.charAt(8) == 'X') || // Diagonal
                (input.charAt(2) == 'X' && input.charAt(4) == 'X' && input.charAt(6) == 'X');   // Diagonal

        boolean oWins = (input.charAt(0) == 'O' && input.charAt(1) == 'O' && input.charAt(2) == 'O') || // Row 1
                (input.charAt(3) == 'O' && input.charAt(4) == 'O' && input.charAt(5) == 'O') || // Row 2
                (input.charAt(6) == 'O' && input.charAt(7) == 'O' && input.charAt(8) == 'O') || // Row 3
                (input.charAt(0) == 'O' && input.charAt(3) == 'O' && input.charAt(6) == 'O') || // Col 1
                (input.charAt(1) == 'O' && input.charAt(4) == 'O' && input.charAt(7) == 'O') || // Col 2
                (input.charAt(2) == 'O' && input.charAt(5) == 'O' && input.charAt(8) == 'O') || // Col 3
                (input.charAt(0) == 'O' && input.charAt(4) == 'O' && input.charAt(8) == 'O') || // Diagonal
                (input.charAt(2) == 'O' && input.charAt(4) == 'O' && input.charAt(6) == 'O');   // Diagonal

        if (xWins && oWins) return "Impossible";
        if (xWins) return "X wins";
        if (oWins) return "O wins";
        if (emptyCount == 0) return "Draw";

        return "Game not finished";
    }
    public static void place(String input){

        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[3][3];
        int countLaps = 0;
        //int x = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = ' ';
                //matrix[i][j] = replaceUnderScore(input.charAt(x));
                //x++;
            }
        }
        String X ;
        String Y ;
        int c1;
        int c2;
        boolean helper = false;
        String inputU = "         ";


        while (calculateResult(inputU).equals("Game not finished")) {
            helper = false;
            while (!helper) {
                X = scanner.next();
                Y = scanner.next();
                if (!isNumeric(X) || !isNumeric(Y)) {
                    System.out.println("You should enter numbers!");
                } else {
                    c1 = Integer.parseInt(X);
                    c2 = Integer.parseInt(Y);
                    if ((c1 > 3 || c1 < 0) || c2 > 3 || c2 < 0) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    } else {
                        if (matrix[c1 - 1][c2 - 1] == ' ') {
                            matrix[c1 - 1][c2 - 1] = (countLaps % 2 == 0) ? 'X' : 'O';
                            helper = true;

                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                        }
                    }
                }
            }

            countLaps++;
            System.out.println("---------");
            for (char[] chars : matrix) {
                System.out.print("| ");
                for (int j = 0; j < matrix.length; j++) {
                    System.out.print(chars[j] + " ");
                }
                System.out.print("|");
                System.out.println();
            }
            System.out.println("---------");

            String updatedInput = "";
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    updatedInput += (matrix[i][j] == ' ') ? '_' : matrix[i][j];
                }
            }
            inputU = updatedInput;

        }
        String result = calculateResult(inputU);
        System.out.println(result);


    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}

