// 평균 계산

import java.util.Scanner;

public class Practice04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int num = sc.nextInt();

        double[] arr = new double[num];
        double sum = 0;

        System.out.print("Enter the numbers: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextDouble();
            sum += arr[i];
        }

        double avg = sum / num;
        
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (avg < arr[i]) {
                count++;
            }
        }

        System.out.println("Average: " + avg);
        System.out.println("Number of elements above the average: " + count);

        sc.close();
    }
}