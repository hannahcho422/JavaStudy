import java.util.Scanner;

// Up and Down
public class Practice08 {
    public static void main(String[] args) {
        int num = (int)(Math.random() * 10);
        Scanner in = new Scanner(System.in);

        System.out.println("Guess a number from 0 to 100.");
        System.out.print("Input the number: ");
        int guess = in.nextInt();

        while (num != guess) {
            if (num > guess) {
                System.out.println("Up!");
            }
            else {
                System.out.println("Down!");
            }
            System.out.print("Input the number: ");
            guess = in.nextInt();
        }
        System.out.println("Correct! The number is " + num + ".");
        in.close();



    }
}