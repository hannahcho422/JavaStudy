// 타입 변환: 부가세 구하기
public class Practice04 {
    public static void main (String[] args) {
        // 변수 선언
        double amount = 197.55;
        double taxRate = 0.06;
        
        // 부가세 계산
        double tax = amount * taxRate;

        // int형으로 캐스팅
        int taxInt = (int) tax;

        // 결과 출력
        System.out.println("Sales tax is $" + taxInt + ".");
    }
}