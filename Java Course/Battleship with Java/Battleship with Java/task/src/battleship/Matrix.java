package battleship;

public class Matrix {
    private char[][] table;
    private final int row;
    private final int col;

    public Matrix(char[][] table) {
        this.table = table;
        this.row = 11;
        this.col = 11;
    }

    public char[][] getTable() {
        return table;
    }

    public void setTable(char[][] table) {
        this.table = table;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void gameCreate() {
        char[][] game = new char[11][12];
        game[0][0] = ' ';

        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                game[i][j] = '~';
            }
        }

        for (int j = 1; j < 11; j++) {
            if (j == 10) {
                game[0][j] = '1';
                game[0][j + 1] = '0';
            } else {
                game[0][j] = (char) ('0' + j);
            }
        }

        for (int i = 1; i < 11; i++) {
            game[i][0] = (char) ('A' + i - 1);
        }
        this.table = game;
    }

    public static void setTablePos(char[][] game, int row, int col){
        game[row][col] = 'O';
    }
    public static boolean forSetTableShot(char[][] board, int row, int col) {
        return board[row][col] == 'O';
    }
    public static boolean isShipSunk(char[][] board, int row, int col) {
        boolean isSunk = true;

        // Boundary checks
        if (row > 0 && board[row - 1][col] == 'O') {
            isSunk = false;
        }
        if (row < board.length - 1 && board[row + 1][col] == 'O') {
            isSunk = false;
        }
        if (col > 0 && board[row][col - 1] == 'O') {
            isSunk = false;
        }
        if (col < board[row].length - 1 && board[row][col + 1] == 'O') {
            isSunk = false;
        }

        return isSunk;
    }

}
