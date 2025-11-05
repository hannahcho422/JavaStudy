import java.util.Scanner;

// 뺄셈 퀴즈
public class Practice09 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int correct = 0;
        int num_correct = 0;
        int count = 0;
        int temp;

        do { 
            int num1 = (int)(Math.random() * 10);
            int num2 = (int)(Math.random() * 10);

            if (num1 < num2) {
                temp = num1;
                num1 = num2;
                num2 = temp;
            }

            correct = num1 - num2;

            System.out.print(num1 + " - " + num2 + " ? ");
            int answer = in.nextInt();

            if (answer == correct) {
                System.out.println("Correct!");
                num_correct++;
                count++;
            }
            else {
                System.out.println("Wrong! " + num1 + " - " + num2 + " is " + correct + ".");
                count++;
            }

        } while (count < 5);

        System.out.println("\nGame Over!");
        System.out.println("You got " + num_correct + " out of 5.");

        in.close();
    }
}