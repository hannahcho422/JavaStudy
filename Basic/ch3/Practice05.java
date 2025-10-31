import java.util.Scanner;

// 12지 계산
public class Practice05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the year: ");
        int year = in.nextInt();
        int zodiac = year % 12;

        String animal;

        switch (zodiac) {
            case 0:  animal = "monkey"; break;
            case 1:  animal = "rooster"; break;
            case 2:  animal = "dog"; break;
            case 3:  animal = "pig"; break;
            case 4:  animal = "rat"; break;
            case 5:  animal = "ox"; break;
            case 6:  animal = "tiger"; break;
            case 7:  animal = "rabbit"; break;
            case 8:  animal = "dragon"; break;
            case 9:  animal = "snake"; break;
            case 10: animal = "horse"; break;
            case 11: animal = "sheep"; break;
            default: animal = "undefined";
        }

        System.out.println(year + " is " + animal + " year.");
    }
}