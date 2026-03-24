/* 지역 클래스 사용 */
public class LocalClassDemo {
    private String s1 = "외부";

    void method() {
        int x = 1;

        // 지역 클래스
        class LocalClass {
            String s2 = "내부";
            String s3 = s1;     // 외부 클래스의 private 멤버 접근 가능

            public void show() {
                System.out.println("지역 클래스");
                // x = 2;       // x -> method() 내부에 선언된 지역 변수, 지역 변수는 사실상 final이기 때문에 수정 불가
            }
        }

        LocalClass lc = new LocalClass();
        System.out.println(lc.s2);
        lc.show();
    }

    public static void main(String[] args) {
        LocalClassDemo lcd = new LocalClassDemo();
        lcd.method();
    }
}