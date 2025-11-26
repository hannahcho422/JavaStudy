import java.util.Scanner;

public class Practice08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] arr1 = new double[3][3];
        double[][] arr2 = new double[3][3];
        double[][] sum  = new double[3][3];

        System.out.print("Enter 3x3 matrix 1: ");
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] = sc.nextDouble();
            }
        }

        System.out.print("Enter 3x3 matrix 2: ");
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = sc.nextDouble();
            }
        }

        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[i].length; j++) {
                sum[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        // 출력
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%4.1f", arr1[i][j]);
            }

            if (i == 1) System.out.print("   +   ");
            else        System.out.print("       ");

            for (int j = 0; j < 3; j++) {
                System.out.printf("%4.1f", arr2[i][j]);
            }

            if (i == 1) System.out.print("   =   ");
            else        System.out.print("       ");

            for (int j = 0; j < 3; j++) {
                System.out.printf("%4.1f", sum[i][j]);
            }

            System.out.println();
        }

        sc.close();
    }
}