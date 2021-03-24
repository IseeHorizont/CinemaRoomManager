package cinema;

import java.util.Scanner;

public class Cinema {

    public static int countSoldTicket = 0;
    public static int currentIncome = 0;
    public static boolean[][] soldSeat;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of rows:\n> ");
        int rows = scan.nextInt();
        System.out.print("Enter the number of seats in each row:\n> ");
        int seatInRows = scan.nextInt();
        initArraySoldSeats(rows, seatInRows);

        String[][] screenRoom = new String[rows][seatInRows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatInRows; j++) {
                screenRoom[i][j] = "S";
            }
        }

        while(true){
            System.out.println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
            System.out.print("> ");
            int command = scan.nextInt();
            if(command == 0){
                break;
            }else if(command == 1){
                System.out.println();
                printScreenRoom(rows, seatInRows, screenRoom);
            }else if(command == 2){
                while(true){
                    System.out.println();
                    System.out.print("Enter a row number:\n> ");
                    int paidRows = scan.nextInt();
                    System.out.print("Enter a seat number in that row:\n> ");
                    int paidSeatInRows = scan.nextInt();
                    if(paidRows > rows || paidSeatInRows > seatInRows){
                        System.out.println("\nWrong input!");
                    }else if(!isFreeSeat(paidRows - 1, paidSeatInRows - 1)){
                        System.out.println("\nThat ticket has already been purchased!");
                    }else {
                        screenRoom[paidRows - 1][paidSeatInRows - 1] = "B";
                        soldSeat[paidRows - 1][paidSeatInRows - 1] = false;
                        countSoldTicket++;
                        if((rows * seatInRows) <= 60){
                            System.out.println("\nTicket price: $10");
                            currentIncome += 10;
                        }else{
                            if(paidRows <= (rows / 2)){
                                System.out.println("\nTicket price: $10");
                                currentIncome += 10;
                            }else {
                                System.out.println("\nTicket price: $8");
                                currentIncome += 8;
                            }
                        }
                        break;
                    }
                }

            }else if(command == 3){

                System.out.println("\nNumber of purchased tickets: " + countSoldTicket);
                System.out.printf("Percentage: %.2f", (double)(countSoldTicket * 100) / (rows * seatInRows));
                System.out.print("%\n");
                System.out.println("Current income: $" + currentIncome);
                System.out.println("Total income: $" + calcTotalIncome(rows, seatInRows));
            }
        }
    }

    private static void printScreenRoom(int rows, int seatInRows, String[][] screenRoom) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= seatInRows; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < seatInRows; j++) {
                System.out.print(screenRoom[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int calcTotalIncome(int rows, int seatInRows){
        if((rows * seatInRows) <= 60){
            return (rows * seatInRows * 10);
        }else{
            int firstHalfRoom = (rows / 2) * seatInRows * 10;
            int secondHalfRoom = ((rows - rows / 2) * seatInRows * 8);
            return (firstHalfRoom + secondHalfRoom);
        }
    }

    private static void initArraySoldSeats(int rows, int seatInRows){
        soldSeat = new boolean[rows][seatInRows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatInRows; j++) {
                soldSeat[i][j] = true;
            }
        }
    }

    private static boolean isFreeSeat(int row, int seatInRows){
        return (soldSeat[row][seatInRows] == true) ? true : false;
    }
}