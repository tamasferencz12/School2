package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String code = secretNumberGenerator();
        System.out.println(code);
        if(code != null){
            System.out.println("Okay, let's start a game!");
            calculate(code);
        }
    }
    public static String secretNumberGenerator() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the length of the secret code:");
        String length = scanner.nextLine();
        int lengthInt;

        if (!isNumeric(length)) {
            System.out.println("Error: " + length + " isn't a valid number.");
            return null;
        }else {
             lengthInt = Integer.parseInt(length);
        }
        if (lengthInt == 0) {
            System.out.println("Error! Integer length can't be 0.");
            return null;
        }
        System.out.println("Input the number of possible symbols in the code:");
        int lengthChar = scanner.nextInt();


        if (lengthChar < lengthInt) {
            System.out.println("Error: it's not possible to generate a code with a length of " + lengthInt + " with " + lengthChar + " unique symbols.");
            return null;
        }

        System.out.println("The secret is prepared: " + "*".repeat(lengthInt) + " (0-9, a-z).");

        if (lengthChar > 36) {
            System.out.println("Error: can't generate a secret number with a length of "+ lengthChar +" because there aren't enough unique digits.");
            return null;
        }

        String characters = "0123456789abcdefghijklmnopqrstuvwxyz";
        characters = characters.substring(0,lengthChar);
        System.out.println(characters);
        Random rand = new Random();
        StringBuilder builder = new StringBuilder();

        while (builder.length() < lengthInt) {
            char randomChar = characters.charAt(rand.nextInt(characters.length()));
            if (!builder.toString().contains(String.valueOf(randomChar))) {
                builder.append(randomChar);
            }
        }
        return builder.toString();
    }
    public static void calculate(String code){
        Scanner scanner = new Scanner(System.in);

        char[] codeToArr = code.toCharArray();
        int round = 1;

        while (true) {
            int bulls = 0;
            int cows = 0;

            System.out.printf("Turn %d:\n", round);
            String guessedCode = scanner.nextLine();
            char[] guessedCodeToArr = guessedCode.toCharArray();

            for (int i = 0; i < codeToArr.length; i++) {
                if (guessedCodeToArr[i] == codeToArr[i]) {
                    bulls++;
                } else if (code.contains(Character.toString(guessedCodeToArr[i]))){
                    cows++;
                }
            }

            if (cows == 0){
                System.out.printf("Grade: %d bulls\n", bulls);
            } else if (bulls == 0) {
                System.out.printf("Grade: %d cows\n", cows);
            }else{
                System.out.printf("Grade: %d bulls and %d cows\n", bulls, cows);
            }

            if (bulls == code.length()) {
                System.out.printf("Grade: %d bulls\n", bulls);
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }
            round++;
        }
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

