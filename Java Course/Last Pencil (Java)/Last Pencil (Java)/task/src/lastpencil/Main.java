package lastpencil;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        List<String> names = List.of("John", "Jack");
        int pencil = readPencil();
        String person1 = readPerson(names);
        String pencils = "|".repeat(pencil);
        List<Player> players = List.of(new Person(names.get(0)), new Bot(names.get(1)));
        System.out.println(pencils);
        Player currentPlayer = players.stream().filter(p -> p.getName().equals(person1)).findFirst().orElseThrow();
        while (!pencils.isEmpty()) {
            System.out.printf("%s's turn!\n", currentPlayer.getName());
            int removeCount = currentPlayer.getRemoveCount(pencils);
            if (currentPlayer instanceof Bot) {
                System.out.println(removeCount);
            }
            pencils = "|".repeat(pencils.length() - removeCount);
            if (!pencils.isEmpty()) {
                System.out.println(pencils);
            }
            currentPlayer = players.indexOf(currentPlayer) == 0 ? players.get(1) : players.get(0);
        }
        System.out.printf("%s won!\n", currentPlayer.getName());

    }


    public static String readPerson(List<String> possiblePersons) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Who will be the first (" + String.join(", ", possiblePersons) + "):");
        while (true) {
            String person = scanner.next();
            if (!possiblePersons.contains(person)) {
                System.out.println("Choose between " + String.join(" and ",
                        possiblePersons.stream().map(p -> "'" + p + "'").toList()));
            } else {
                return person;
            }
        }
    }

    public static int readPencil() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many pencils would you like to use:");
        while (true) {
            int pencil = getInteger(scanner.nextLine());
            if (pencil == 0) {
                System.out.println("The number of pencils should be positive");
            } else if (pencil <= -1) {
                System.out.println("The number of pencils should be numeric");
            } else {
                return pencil;
            }
        }
    }

    public static int getInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
