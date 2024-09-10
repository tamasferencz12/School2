package cinema;

import java.util.Scanner;

public class Matrix {

    private String[][] table;
    private int row;
    private int col;
    private int totalSeats;

    public Matrix(String[][] table, int row, int col) {
        this.table = table;
        this.row = row;
        this.col = col;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String[][] getTable() {
        return table;
    }

    public void setTable(String[][] table) {
        this.table = table;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void cinemaCreate(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt()+1;
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt()+1;

        String[][] cinema = new String[rows][seats];
        cinema[0][0] = " ";

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < seats; j++) {
                cinema[i][j] = "S";
            }
        }
        for (int j = 1; j < seats; j++) {
            cinema[0][j] = j + "";
        }

        for (int i = 1; i < rows; i++) {
            cinema[i][0] = i + "";
        }
        this.table = cinema;
        this.row = rows;
        this.col = seats;
        this.setTotalSeats((rows-1) * (seats-1));
    }

    public static void setTablePos(String[][] cinema, int row, int col){
        cinema[row][col] = "B";
    }
    public String getTablePos(String[][] cinema, int row, int col){
       return cinema[row][col];
    }
}
