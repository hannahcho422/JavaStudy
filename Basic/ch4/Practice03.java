// 배열 요소 중 최대값 출력

public class Practice03 {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 5, 3, 4, 5, 5};

        int max = arr[0];   // set the first element as max
        int maxIndex = 0;

        for (int i = 0; i < arr.length; i++){
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }

        System.out.println("Largest element is " + max + ", and the smallest index of " + max + " is " + maxIndex);

    }
}