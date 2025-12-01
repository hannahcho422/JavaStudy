import java.util.Scanner;

enum Vowel {
    A, E, I, O, U;

    // ch가 모음인지 확인하는 정적 메서드
    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        for (Vowel v : values()) {
            if (v.name().toLowerCase().charAt(0) == ch) {
                return true;
            }
        }
        return false;
    }
}

public class Practice10_1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isAlphabetic(ch)) {
                if (Vowel.isVowel(ch)) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Number of vowels: " + vowels);
        System.out.println("Number of consonants: " + consonants);

        sc.close();
    }
}