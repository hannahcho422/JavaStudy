import java.util.Scanner;

public class TestCalculator {
    public static void main(String[] args) {

        double result;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter: number1 OperationalSymbol(+, -, *, /, %) number2: ");

        int num1 = sc.nextInt();  
        char op = sc.next().charAt(0);    
        int num2 = sc.nextInt();

        // operator validation
        while (op != '+' && op != '-' && op != '*' && op != '/' && op != '%') {
            System.out.println("Wrong Input");
            System.out.print("Enter operator again (+, -, *, /, %): ");
            op = sc.next().charAt(0);
        }

        Calculator cal = new Calculator(num1, num2);

        switch(op) {
        case '+':
            result = cal.add();
            break;
        case '-':
            result = cal.subtract();
            break;
        case '*':
            result = cal.multiply();
            break;
        case '/':
            result = cal.divide();
        case '%':
            result = cal.modulus();
        default:
            result = 0;     // validation 했기 때문에 사실상 여기 오지 않음
        }

        System.out.println("\nResult: " + result);
        
        sc.close();
    }
}