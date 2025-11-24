// 배열 요소 정렬

import java.util.Arrays;

public class Practice06 {
    public static void main(String[] args) {
        double[] arr = {1, 9, 4.5, 6.6, 5.7, -4.5};

        System.out.println("Before sort: ");
        System.out.println(Arrays.toString(arr));

        sort(arr);

        System.out.println("After sort: ");
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {        // 전체 배열 여러 번 반복
            for (int j = 0; j < array.length - 1 - i; j++)      // 인접 값 비교 & swap
                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
        }

    }
}