import java.util.Scanner;

// 덧셈 퀴즈
public class Practice07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num1 = (int)(Math.random() * 10);
        int num2 = (int)(Math.random() * 10);

        System.out.print(num1 + " + " + num2 + " ? ");
        int answer = in.nextInt();
        int correct = num1 + num2;

        while (answer != correct) {
            System.out.print("틀렸습니다. 다시해보세요. " + num1 + " + " + num2 + " ? ");
            answer = in.nextInt();
        }
        System.out.println("정답입니다!"); 
        in.close();
    }
}