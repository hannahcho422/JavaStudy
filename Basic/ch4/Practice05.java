import java.util.Arrays;

// swap

public class Practice05 {
    public static void main(String[] args) {
        int[] arr = {1, 2};

        System.out.println("Before invoking swap");
        System.out.println("Array: " + Arrays.toString(arr)); 

        swap(arr);

        System.out.println("After invoking swap");
        System.out.println("Array: " + Arrays.toString(arr)); 

    }

    public static void swap(int[] array) {
        int temp = array[0];
        array[0] = array [1];
        array[1] = temp;
    }
}