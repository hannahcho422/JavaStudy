import java.util.Scanner;

// 계산기
public class Practice04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the first number operator(+, -, *, /, %) second number: ");
        int num1 = in.nextInt();
        int operator = in.next().charAt(0);
        int num2 = in.nextInt();

        double result = 0;

        switch (operator) {
        case '+':
            result = num1 + num2;
            System.out.println("Result: " + result);
            break;
        case '-':
            result = num1 - num2;
            System.out.println("Result: " + result);
            break;
        case '*':
            result = num1 * num2;
            System.out.println("Result: " + result);
            break;
        case '/':
            result = num1 / num2;
            System.out.println("Result: " + result);
            break;
        case '%':
            result = num1 % num2;
            System.out.println("Result: " + result);
            break;
        default:
            System.out.println("Wrong Input");
        }
    }
}