import java.util.Scanner;

public class BMImain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BMICalculator calculator = new BMICalculator();

        // ===== bmi1 =====
        System.out.print("Enter name, age, weight, height: ");
        String name1 = sc.next();
        int age1 = sc.nextInt();
        double weight1 = sc.nextDouble();
        double height1 = sc.nextDouble();

        BMI bmi1 = new BMI(name1, age1, weight1, height1);
        calculator.calculateBMI(bmi1);

        // ===== bmi2 =====
        System.out.print("Enter name, age, weight, height: ");
        String name2 = sc.next();
        int age2 = sc.nextInt();
        double weight2 = sc.nextDouble();
        double height2 = sc.nextDouble();

        BMI bmi2 = new BMI(name2, age2, weight2, height2);
        calculator.calculateBMI(bmi2);

        System.out.println("\n=== Result ===");
        System.out.println("BMI1: " + bmi1.getBMI() + " (" + bmi1.getStatus() + ")");
        System.out.println("BMI2: " + bmi2.getBMI() + " (" + bmi2.getStatus() + ")");

        sc.close();
    }
}