package cinema;

import java.util.Scanner;

public class Cinema {

    private Matrix matrix;
    private int purchasedTickets;
    private int currIncome;
    private int totalIncome;
    private int totalSeats;
    private float percentage;

    public Cinema(Matrix matrix, int purchasedTickets, int currIncome, int totalIncome) {
        this.matrix = matrix;
        this.purchasedTickets = purchasedTickets;
        this.currIncome = currIncome;
        this.totalIncome = totalIncome;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    public int getPurchasedTickets() {
        return purchasedTickets;
    }

    public void setPurchasedTickets(int purchasedTickets) {
        this.purchasedTickets = purchasedTickets;
    }

    public int getCurrIncome() {
        return currIncome;
    }

    public void setCurrIncome(int currIncome) {
        this.currIncome = currIncome;
    }

    public int getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(int totalIncome) {
        this.totalIncome = totalIncome;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Matrix cinemaMatrix = new Matrix(null, 0, 0);
        cinemaMatrix.cinemaCreate();
        Cinema cinema = new Cinema(cinemaMatrix,0,0,0 );

        while (true){
            System.out.println("\n1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    printCinema(cinemaMatrix);
                    break;
                case 2:
                    buyTicket(cinemaMatrix, cinema);
                    break;
                case 3:
                    statistics(cinema, cinemaMatrix);
                    break;
                case 0:
                    return;
            }
        }

    }

    public static void statistics(Cinema cinema, Matrix matrix) {
        System.out.println("\nNumber of purchased tickets: " + cinema.getPurchasedTickets());
        System.out.printf("Percentage: %.2f%%\n", cinema.getPercentage());
        System.out.printf("Current income: $%d\n", cinema.getCurrIncome());
        System.out.printf("Total income: $%d\n", calculatePrice(cinema, matrix));

    }
    public static int calculatePrice(Cinema cinema, Matrix matrix){
        int totalSeats = matrix.getTotalSeats();

        if (totalSeats <= 60){
            return totalSeats * 10;
        }else{
            int frontHalf = (cinema.getMatrix().getRow()-1) / 2;
            int backHalf = (cinema.getMatrix().getRow()-1) - frontHalf;

            int frontHalfPrice = frontHalf * (cinema.getMatrix().getCol()-1) * 10;
            int backHalfPrice = backHalf * (cinema.getMatrix().getCol()-1) * 8;

            return frontHalfPrice + backHalfPrice;
        }
    }
    public static void buyTicket(Matrix cinemaMatrix, Cinema cinema){
        Scanner scanner = new Scanner(System.in);

        while(true) {
            int row;
            int seat;
            while (true) {
                System.out.println("\nEnter a row number:");
                row = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter a seat number in that row:");
                seat = Integer.parseInt(scanner.nextLine());

                if (row >= cinemaMatrix.getRow() || seat >= cinemaMatrix.getCol() || row < 0 || seat < 0) {
                    System.out.println("\nWrong input!");
                } else if (cinemaMatrix.getTablePos(cinemaMatrix.getTable(),row,seat).equals("B")){
                    System.out.println("\nThat ticket has already been purchased!");
                }else {
                    break;
                }
            }


            int ticket = ticketPrice(cinemaMatrix, row, cinema);
            System.out.println("\nTicket price: $" + ticket);

            cinema.setPurchasedTickets(cinema.getPurchasedTickets() + 1);
            cinema.setCurrIncome(cinema.getCurrIncome() + ticket);
            cinema.setPercentage(((float) cinema.getPurchasedTickets() / cinemaMatrix.getTotalSeats()) * 100);

            if (row < cinemaMatrix.getRow() && seat < cinemaMatrix.getCol()) {
                Matrix.setTablePos(cinemaMatrix.getTable(), row, seat);
                break;
            }

        }
    }
    public static int ticketPrice(Matrix cinemaMatrix, int row, Cinema cinema){
        int totalSeats = cinemaMatrix.getRow() * cinemaMatrix.getCol();

        if (totalSeats <= 60){
            return 10;
        }else {
            int frontHalf = cinemaMatrix.getRow() % 2 == 0 ? cinemaMatrix.getRow() / 2 : cinemaMatrix.getRow() / 2 + 1;
            if (row < frontHalf){
                return 10;
            }else{
                return 8;
            }
        }
    }
    public static void printCinema(Matrix cinemaMatrix){
        String[][] seatingChart = cinemaMatrix.getTable();
        System.out.println("\nCinema:");
        for (int i = 0; i < cinemaMatrix.getRow(); i++) {
            for (int j = 0; j < cinemaMatrix.getCol(); j++) {
                System.out.print(seatingChart[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}