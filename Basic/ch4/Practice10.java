// 사용자로부터 받은 문자열에서 자음 모음 개수 출력
import java.util.Scanner;

public class Practice10 {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int vowles = 0;
        int consonants = 0;

        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'a' && ch <= 'z') {   // 알파벳인지 확인
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowles++;
                } else {
                    consonants++;
                }
            
            }
        }

        System.out.println("Number of vowles: " + vowles);
        System.out.println("Number of consonants: " + consonants);
       
    }
}