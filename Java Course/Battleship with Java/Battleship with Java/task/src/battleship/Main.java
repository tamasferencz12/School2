package battleship;

public class Main {

    public static void main(String[] args) {
        System.out.println("Player 1, place your ships to the game field\n");
        Matrix gameMatrix1 = new Matrix(null);
        Matrix gameMatrixGuess1 = new Matrix(null);
        gameMatrix1.gameCreate();
        gameMatrixGuess1.gameCreate();
        Game game1 = new Game(gameMatrix1);
        Game.printBoard(gameMatrix1.getTable());
        Game.placeShip(gameMatrix1.getTable());

        System.out.println("Player 2, place your ships to the game field\n");
        Matrix gameMatrix2= new Matrix(null);
        Matrix gameMatrixGuess2 = new Matrix(null);
        gameMatrix2.gameCreate();
        gameMatrixGuess2.gameCreate();
        Game game2 = new Game(gameMatrix2);
        Game.printBoard(gameMatrix2.getTable());
        Game.placeShip(gameMatrix2.getTable());

        Game.play(gameMatrix1.getTable(), gameMatrixGuess1.getTable(), gameMatrix2.getTable(), gameMatrixGuess2.getTable());
    }
}
