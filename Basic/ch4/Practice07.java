// 2차원 배열 선언, 모든 요소의 합계 구하기

import java.util.Scanner;

public class Practice07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[3][4];
        int sum = 0;

        System.out.println("Enter 3 rows and 4 columns: ");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextInt();
                sum += arr[i][j];
            }
        }

        System.out.println("Sum of all elements: " + sum);

        sc.close();
    }
   
}