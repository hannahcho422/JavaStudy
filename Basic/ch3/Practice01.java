import java.util.Scanner;

// 학점 게산하기
public class Practice01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input grade: ");
        int grade = in.nextInt();

        if (grade >= 90) {
            System.out.println(grade + " is A.");
        } else if (grade >= 80) {
            System.out.println(grade + " is B.");
        } else if (grade >= 70) {
            System.out.println(grade + " is C.");
        } else if (grade >= 60) {
            System.out.println(grade + " is D.");
        } else {
            System.out.println(grade + " is F.");
        }
    }
}
