package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of rows:\n> ");
        int rows = scan.nextInt();
        System.out.print("Enter the number of seats in each row:\n> ");
        int seatInRows = scan.nextInt();

        String[][] screenRoom = new String[rows][seatInRows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatInRows; j++) {
                screenRoom[i][j] = "S";
            }
        }
        System.out.println();
        printScreenRoom(rows, seatInRows, screenRoom);

        System.out.print("Enter a row number:\n> ");
        int paidRows = scan.nextInt();
        System.out.print("Enter a seat number in that row:\n> ");
        int paidSeatInRows = scan.nextInt();

        screenRoom[paidRows-1][paidSeatInRows-1] = "B";

        if((rows * seatInRows) <= 60){
            System.out.println("\nTicket price: $10\n");
        }else{
            if(paidRows <= (rows / 2)){
                System.out.println("\nTicket price: $10\n");
            }else {
                System.out.println("\nTicket price: $8\n");
            }
        }
        printScreenRoom(rows, seatInRows, screenRoom);

//        int totalSum = 0;
//        if((rows * seatInRows) <= 60){
//            totalSum = rows * seatInRows * 10;
//        }else if((rows * seatInRows) > 60){
//            int firstHalfRoom = rows / 2;
//            totalSum = (firstHalfRoom * seatInRows  * 10) + ((rows - firstHalfRoom) * seatInRows * 8);
//        }
//        System.out.println("Total income:\n$" + totalSum);
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
}