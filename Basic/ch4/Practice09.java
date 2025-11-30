// 사용자로부터 받은 문자열 역순 출력
import java.util.Scanner;

public class Practice09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String reverse = "";

        for (int i = input.length() - 1; i >=0; i--) {
            reverse += input.charAt(i);
        }

        System.out.println("Reversed: " + reverse);

        sc.close();
    }
}