package chucknorris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input;

        /*
        System.out.println("Divisible by 7: "+dividableBy7("000 0 00 00 0000 0 00 000"));
        System.out.println("Only zeros: "+onlyZeros("000 0 00 00 0000 0 00 000"));
        System.out.println("Correct type: "+correctType("000 0 00 00 0000 0 00 000"));*/

        do {
            System.out.println("Please input operation (encode/decode/exit):");
            input = scanner.nextLine();

            if (!(input.equals("encode") || input.equals("decode") || input.equals("exit"))) {
                System.out.println("There is no '" + input + "' operation\n");
                continue;
            }

            switch (input) {
                case "encode":
                    System.out.println("Input string:");
                    String encoded = scanner.nextLine();
                    encode(encoded);
                    System.out.println();
                    break;
                case "decode":
                    System.out.println("Input encoded string:");
                    String decoded = scanner.nextLine();
                    decode(decoded);
                    System.out.println();
                    break;
                case "exit":
                    System.out.println("Bye!");
                    break;
            }
        } while (!input.equals("exit"));

        scanner.close();
    }
    
    public static void decode(String input){
        if(dividableBy7(input) && onlyZeros(input) && correctType(input)){

            List<String> pieces = Arrays.stream(input.split(" ")).toList();
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < pieces.size() - 1; i += 2) {
                if (pieces.get(i).equals("00")){
                    builder.append("0".repeat(pieces.get(i+1).length()));
                }else {
                    builder.append("1".repeat(pieces.get(i+1).length()));
                }
            }
            String binary = builder.toString();
            StringBuilder output = new StringBuilder();
            List<String> every7th = new ArrayList<>();
            for (int i = 0; i < binary.length(); i += 7) {
                every7th.add(binary.substring(i, Math.min(i + 7, binary.length())));
            }
            for (String s : every7th) {
                output.append((char) Integer.parseInt(s, 2));
            }

            System.out.println("Decoded string:\n" + output);
            //System.out.println(output);
        }else{
            System.out.println("Encoded string is not valid!\n");
            return;
        }

    }

    public static void encode(String input) {
        StringBuilder binaryString = new StringBuilder();

        for (char c : input.toCharArray()) {
            String binaryChar = String.format("%7s", Integer.toBinaryString(c)).replace(' ', '0');
            binaryString.append(binaryChar);
        }

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < binaryString.length()) {
            char currentChar = binaryString.charAt(i);
            int count = 0;

            while (i < binaryString.length() && binaryString.charAt(i) == currentChar) {
                count++;
                i++;
            }

            if (currentChar == '1') {
                result.append("0 ");
            } else {
                result.append("00 ");
            }

            result.append("0".repeat(count));

            if (i < binaryString.length()) {
                result.append(" ");
            }
        }

        System.out.println("Encoded string:\n" + result);
    }
    public static boolean dividableBy7(String input){
        List<String> pieces = Arrays.stream(input.split(" ")).toList();
        int sum = 0;
        for (int i = 1; i < pieces.size(); i += 2) {
            sum+= pieces.get(i).length();
        }
        return sum % 7 == 0;
    }
    public static boolean onlyZeros(String input) {
        for (char piece : input.toCharArray()) {
            if (piece == '1') {
                return false;
            }
        }
        return true;
    }

    public static boolean correctType(String input){
        List<String> pieces = Arrays.stream(input.split(" ")).toList();
        for (int i = 0; i < pieces.size(); i += 2) {
            if(pieces.get(i).length() > 2 || pieces.get(i).isEmpty()){
                return false;
            }
        }
        return true;
    }
}