// 배열 선언, 길이만큼 사용자로부터 값 입력 받아 저장, 배열에 입력된 값 순서대로 출력
import java.util.Scanner;

public class Practice02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] arr = new double[5];

        System.out.print("Enter 5 values: ");

        for (int i = 0; i < arr.length; i++){
            arr[i] = sc.nextDouble();
        }

        System.out.println("Entered values are: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        sc.close();
    }
    
}