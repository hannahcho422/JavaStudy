public class Calculator {
    // fields
    public int num1;
    public int num2;

    // constructor 
    public Calculator(int n1, int n2) {
        num1 = n1;
        num2 = n2;
    }

    // methods
    public int add() {
        return num1 + num2;
    }

    public int subtract() {
        return num1 - num2;
    }

    public int multiply() {
        return num1 * num2;
    }

    public double divide() {
        return (double) num1 / num2;
    }

    public int modulus() {
        return num1 % num2;
    }
}