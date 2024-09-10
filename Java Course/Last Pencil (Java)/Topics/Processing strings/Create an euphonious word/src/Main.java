import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringInput = scanner.nextLine();

        char[] charInput = stringInput.toCharArray();
        int count = 0;

        while (!clear(charInput)){
            for (int i = 0; i < charInput.length - 2; i++) {
                if (isVowelOrConsonant(charInput[i], charInput[i + 1], charInput[i + 2])) {
                    charInput  = removeTwoCharacters(charInput, i+1);
                    count++;
                    i = -1;
                }
            }
        }
        System.out.println(count);
    }


    private static boolean clear(char[] charArr){
        for (int i = 0; i < charArr.length - 2; i++) {
            if (isVowelOrConsonant(charArr[i], charArr[i+1], charArr[i+2])){
                return false;
            }
        }
        return true;
    }

    private static boolean isVowelOrConsonant(char c1, char c2, char c3){
        if(isVowel(c1) && isVowel(c2) && isVowel(c3)){
            return true;
        } else return !isVowel(c1) && !isVowel(c2) && !isVowel(c3);
    }

    private static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y';
    }

    private static char[] removeTwoCharacters(char[] arr, int index) {
        char[] newArr = new char[arr.length - 2];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i == index || i == index + 1) {
                continue;
            }
            newArr[j++] = arr[i];
        }
        return newArr;
    }
}