import java.util.Scanner;

public class Practice08_1 {
    // 행렬 입력 받기
    public static double[][] readMatrix(Scanner sc, String text) {
        System.out.print(text);
        double arr[][] = new double[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextDouble();
            }
        }
        return arr;
    }

    // 행렬 출력
    public static void printMatrix(double[][] arr, int row) {
        for (int j = 0; j < arr.length; j++) {
            System.out.printf("%4.1f", arr[row][j]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] arr1 = readMatrix(sc, "Enter 3x3 matrix 1: ");
        double[][] arr2 = readMatrix(sc, "Enter 3x3 matrix 2: ");

        double[][] sum = new double[3][3];

        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[i].length; j++) {
                sum[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        for (int i = 0; i < 3; i ++) {
            printMatrix(arr1, i);
            System.out.print(i == 1 ? "   +   " : "       ");
            printMatrix(arr2, i);
            System.out.print(i == 1 ? "   +   " : "       ");
            printMatrix(sum, i);
            System.out.println();
        }

        sc.close();

    }
}