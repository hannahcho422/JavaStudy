// 히스토그램
import java.util.Scanner;

public class Practice12 {
    public static void main(String[] java) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        int[] count = new int[10];

        System.out.print("Enter 10 numbers: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();

            if (arr[i] >= 1 && arr[i] <= 100) {
                int index = (arr[i] - 1) / 10;
                count[index]++;
            }
        }

        for (int i = 0; i < count.length; i++) {
            int start = i * 10 + 1;
            int end = (i + 1) * 10;
            System.out.print(start + "-" + end + ": ");

            for (int j = 0; j < count[i]; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}