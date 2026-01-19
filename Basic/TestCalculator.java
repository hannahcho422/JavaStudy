import java.util.Scanner;

public class TestCalculator {
    public static void main(String[] args) {

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

        // operand validaton
        if((op == '/' || op == '%') && (num2 == 0)) {
            System.out.println("Error: cannot divide by 0");
            sc.close();
            return;
        }

        Calculator cal = new Calculator(num1, num2);

        if (op == '/' || op == '%') {
            double result;
            switch(op) {
            case '/':
                result = cal.divide();
                break;
            case '%':
                result = (double) cal.modulus();
                break;
            default:
                result = 0.0;    // validation 했기 때문에 사실상 여기 오지 않음
            }
            System.out.println("Result: " + result);
            
        } else {
            int result;

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
            default:
                result = 0;     // 사실상 오지 않음
            }
            System.out.println("Result: " + result);
        }
        
        sc.close();
    }
}