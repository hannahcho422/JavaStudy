// 극장 예약 시스템
import java.util.Scanner;

public class Practice11 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] seats = {0, 0, 0, 0, 0, 1, 1, 1, 0, 0};
        
        System.out.print("Book seats? (0: No, 1: Yes)");
        int num = sc.nextInt();

        while (num == 1) {
            System.out.println("Current reservation status");
            System.out.println("---------------------------");
            System.out.println("1 2 3 4 5 6 7 8 9 10");
            System.out.println("---------------------------");
            for (int i = 0; i < seats.length; i++) {
                System.out.print(seats[i] + " ");
            }
            System.out.print("\nWhich seat would you like to book for?");
            int seatNum = sc.nextInt();

            while (seatNum < 1 || seatNum > seats.length) {
                System.out.println("Invalid seat number. Please choose between 1 and 10.");
                seatNum = sc.nextInt();
            } 
            
            while (seats[seatNum - 1] == 1) {
                System.out.println("Seat " + seatNum + " is already booked. Choose another seat.");
                seatNum = sc.nextInt();
            }

            seats[seatNum - 1] = 1;
            System.out.println("Successfully booked seat " + seatNum + ".");

            System.out.print("Book seats? (0: No, 1: Yes)");
            num = sc.nextInt();

        } 

        System.out.println("System terminated.");
        sc.close();
    }
}