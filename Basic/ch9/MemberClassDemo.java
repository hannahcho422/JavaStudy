/* 인스턴스 멤버 클래스 사용 */
// 외부 클래스
public class MemberClassDemo {
    private String secret = "비공개";
    String s = "외부";

    // 인스턴스 멤버 클래스
    class MemberClass {
        String s = "내부";
    
        public void show1() {
            System.out.println("인스턴스 멤버 클래스");
            System.out.println(secret);                     // 외부 클래스의 private 멤버 접근 가능
            System.out.println(s);                          // 자신의 멤버 s("내부") 의미
            System.out.println(MemberClassDemo.this.s);     // 외부 클래스의 멤버 s("외부") 의미
        }

    }

    /*
    // 인스턴스 멤버 클래스 내부에 정적 변수나 메서드 포함 불가
    static String ss = "정적 멤버 필드";
    static void show2() {}
    */

    public static void main(String[] args) {
        // 인스턴스 멤버 객체 생성
        MemberClassDemo m = new MemberClassDemo();
        MemberClassDemo.MemberClass m1 = m.new MemberClass();

        System.out.println(m1.s);
        m1.show1();
    }
}