import java.util.Scanner;

// 정수 3개 입력 받아 max, min 출력
public class Practice02 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter any three integers: ");
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int num3 = in.nextInt();

        int max, min;

        // get max
        if (num1 > num2) {
            if (num1 > num3)
                max = num1;
            else
                max = num3;
        } else {
            if (num2 > num3)
                max = num2;
            else
                max = num3;
        }

        // get min
        if (num1 < num2){
            if (num1 < num3)
                min = num1;
            else
                min = num3;
        } else {
            if (num2 < num3)
                min = num2;
            else
                min = num3;
        }

        System.out.println("The largest integer is " + max + ", and the smallest integer is " + min + ".");
    }
}