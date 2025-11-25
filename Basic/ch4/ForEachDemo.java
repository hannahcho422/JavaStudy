import java.util.Scanner;

public class ForEachDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int scores[] = new int[5];
        int sum = 0;

        for (int i = 0; i < scores.length; i++) {
            scores[i] = sc.nextInt();
        }

        for (int s : scores) {
            sum += s;
        }

        System.out.println("Average = " + sum / 5.0);
    }
}