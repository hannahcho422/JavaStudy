import java.util.Scanner;

// 계산기 
public class Practice03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Simple Calculator");
        System.out.println("Addition");
        System.out.println("Subtraction");
        System.out.println("Multiplication");
        System.out.println("Division");
        System.out.println("Remaining");
        System.out.println("\n");

        System.out.print("Choice number <1-5>: ");

        int choice = in.nextInt();
        System.out.println("\n");

        if (choice >= 1 && choice <= 5) {
            System.out.println("Start: ");
            System.out.print("Enter the first number: ");
            int num1 = in.nextInt();
            System.out.print("Enter the second number: ");
            int num2 = in.nextInt();
            if (choice == 1) {
                double result = num1 + num2;
                System.out.println("Result: " + result);
            } else if (choice == 2) {
                double result = num1 - num2;
                System.out.println("Result: " + result);
            } else if (choice == 3) {
                double result = num1 * num2;
                System.out.println("Result: " + result);
            } else if (choice == 4) {
                double result = num1 / num2;
                System.out.println("Result: " + result);
            } else if (choice == 5) {
                double result = num1 % num2;
                System.out.println("Result: " + result);
            }
        } else {
            System.out.println("Wrong Input");
        }

    }
}
