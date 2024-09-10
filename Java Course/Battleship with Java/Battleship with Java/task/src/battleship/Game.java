package battleship;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private static  Matrix gameMatrix;
    public Game(Matrix matrix) {
        gameMatrix = matrix;
    }

    public static void printBoard(char[][] game) {
        System.out.print("  ");
        for (int j = 1; j < 11; j++) {
            if (j == 10) {
                System.out.print("10 ");
            } else {
                System.out.print(j + " ");
            }
        }
        System.out.println();

        for (int i = 1; i < 11; i++) {
            System.out.print((char) ('A' + i - 1) + " ");
            for (int j = 1; j < 11; j++) {
                System.out.print(game[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isAdjacent(char[][] game, int startRow, int endRow, int startCol, int endCol) {

        int minRow = Math.max(1, startRow - 1);
        int maxRow = Math.min(10, endRow + 1);
        int minCol = Math.max(1, startCol - 1);
        int maxCol = Math.min(10, endCol + 1);

        for (int i = minRow; i <= maxRow; i++) {
            for (int j = minCol; j <= maxCol; j++) {
                if ((i >= startRow && i <= endRow) && (j >= startCol && j <= endCol)) {
                    continue;
                }
                if (game[i][j] == 'O') {
                    return true;
                }
            }
        }
        return false;
    }

    public static void play(char[][] game1, char[][] gameBoardGuess1, char[][] game2, char[][] gameBoardGuess2) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        System.out.println("The game starts!\n");
        boolean won = false;

        while (!won) {
            if (count <= 0) {
                System.out.println("Press Enter and pass the move to another player");
                scanner.nextLine();
            }

            if (count % 2 == 0) {
                // First player's turn
                System.out.println("First player's move:\n");
                Game.printBoard(gameBoardGuess1);
                System.out.println("--------------------\n");
                Game.printBoard(game1);
                System.out.println("\nTake a shot!\n");

                won = takeShot(scanner, game2, gameBoardGuess1);
                if (won) {
                    System.out.println("\nFirst player won. Congratulations!\n");
                }

            } else {
                // Second player's turn
                System.out.println("Second player's move:\n");
                Game.printBoard(gameBoardGuess2);
                System.out.println("--------------------\n");
                Game.printBoard(game2);
                System.out.println("\nTake a shot!\n");

                won = takeShot(scanner, game1, gameBoardGuess2);
                if (won) {
                    System.out.println("\nSecond player won. Congratulations!\n");
                }
            }
            count++;
        }
    }

    private static boolean takeShot(Scanner scanner, char[][] gameBoard, char[][] gameBoardGuess) {
        int hits = 0;

        while (true) {
            String shot = scanner.nextLine();
            System.out.println();

            if (shot.isEmpty()) {
                System.out.println("\nError! You entered the wrong coordinates! Try again:\n");
                continue;
            }

            String firstC = shot.split(" ")[0];
            char firstChar = firstC.charAt(0);
            int firstNum = Integer.parseInt(firstC.substring(1));
            int decimalValue = firstChar - 'A' + 1;

            if ((firstChar > 'J' || firstChar < 'A') || (firstNum > 10 || firstNum < 1)) {
                System.out.println("\nError! You entered the wrong coordinates! Try again:\n");
                continue;
            }

            boolean hit = Matrix.forSetTableShot(gameBoard, decimalValue, firstNum);
            if (hit) {
                hits++;
                gameBoardGuess[decimalValue][firstNum] = 'X';
                gameBoard[decimalValue][firstNum] = 'X';

                if (Matrix.isShipSunk(gameBoard, decimalValue, firstNum)) {
                    if(areAllShipsSunk(gameBoard)){
                        return areAllShipsSunk(gameBoard);
                    }else{
                        System.out.println("You sank a ship! Press Enter to pass to another player");
                        scanner.nextLine();
                        break;
                    }

                } else {
                    System.out.println("You hit a ship! Try again:\n");
                    break;
                }
            } else {
                if (gameBoardGuess[decimalValue][firstNum] != 'X') {
                    gameBoardGuess[decimalValue][firstNum] = 'M';
                    gameBoard[decimalValue][firstNum] = 'M';
                }
                System.out.println("You missed! Press ENTER to pass to the other player");
                scanner.nextLine();
                break;
            }
        }
        return areAllShipsSunk(gameBoard);
    }

    private static boolean areAllShipsSunk(char[][] game) {
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                if (game[i][j] == 'O') {
                    return false;
                }
            }
        }
        return true;
    }
    public static void placeShip(char[][] game) {
        Scanner scanner = new Scanner(System.in);
        String[] shipNames = new String[Ships.values().length];

        for (int i = 0; i < shipNames.length; i++) {

            String firstC;
            String secondC;
            char firstChar;
            int firstNum;
            char secondChar;
            int secondNum;

            System.out.println(Ships.values()[i].getName() + "\n");

            while (true) {

                String coordinates = scanner.nextLine();
                System.out.println();

                if (coordinates.length() < 2) {
                    System.out.println("\nError! You must enter two coordinates! Try again:\n");
                    i--;
                    break;
                }

                firstC = coordinates.split(" ")[0];
                secondC = coordinates.split(" ")[1];

                firstChar = firstC.charAt(0);
                firstNum = Integer.parseInt(firstC.substring(1));
                secondChar = secondC.charAt(0);
                secondNum = Integer.parseInt(secondC.substring(1));

                int length = 0;
                if (firstChar == secondChar) {
                    length = Math.abs(secondNum - firstNum) + 1;
                } else if (firstNum == secondNum) {
                    length = Math.abs(secondChar - firstChar) + 1;
                } else {
                    System.out.println("\nError! Wrong ship location! Try again:\n");
                    continue;
                }
                if (!((i == 0 && length == 5) || (i == 1 && length == 4) || (i == 2 && length == 3) || (i == 3 && length == 3) || (i == 4 && length == 2))) {
                    System.out.println("\nError! Wrong length of the Submarine! Try again:\n");
                } else {
                    int decimalValue = firstChar - 'A' + 1;

                    int startRow = Math.min(decimalValue, secondChar - 'A' + 1);
                    int endRow = Math.max(decimalValue, secondChar - 'A' + 1);
                    int startCol = Math.min(firstNum, secondNum);
                    int endCol = Math.max(firstNum, secondNum);

                    if (isAdjacent(game, startRow, endRow, startCol, endCol)) {
                        System.out.println("\nError! Ships cannot be adjacent. Try again:\n");
                        continue;
                    }
                    if (firstChar == secondChar) {
                        // Vertical placement
                        for (int j = Math.min(firstNum, secondNum); j <= Math.max(firstNum, secondNum); j++) {
                            Matrix.setTablePos(game, decimalValue, j);
                        }
                    } else if (firstNum == secondNum) {
                        // Horizontal placement
                        for (int j = Math.min(firstChar, secondChar) - 'A' + 1; j <= Math.max(firstChar, secondChar) - 'A' + 1; j++) {
                            Matrix.setTablePos(game, j, firstNum);

                        }
                    }
                    Game.printBoard(game);
                    break;
                }
            }
        }
    }}







