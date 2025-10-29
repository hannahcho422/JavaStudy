import java.util.Scanner;

public class IfElseDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input number: ");
        int number = in.nextInt();

        if(number % 2 == 0)
            System.out.println("Even number");
        else
            System.out.println("Odd number");
        System.out.println("End program");
    }
}
