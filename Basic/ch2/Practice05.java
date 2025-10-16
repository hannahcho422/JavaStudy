import java.util.Scanner;

public class Practice05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 사용자 입력
        System.out.println("Enter three numbers: ");
        double num1 = input.nextDouble();
        double num2 = input.nextDouble();
        double num3 = input.nextDouble();

        // 평균 계산
        double average = (num1 + num2 + num3) / 3;

        // 결과 출력
        System.out.println("The average of " + num1 + ", " + num2 + ", and " + num3 + " is " + average);
    }
}