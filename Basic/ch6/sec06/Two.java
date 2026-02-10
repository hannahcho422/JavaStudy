package ch6.sec06;

public class Two {
    void print() {
        One o = new One();

        // ❌ 같은 패키지에 있더라도 다른 객체의 private 멤버에 접근 불가
        System.out.println(o.secret);

        // 같은 패키지에 있는 경우, 다른 객체의 private 외의 멤버에 접근 가능
        // 자신의 멤버가 아니기 때문에 객체 생성해야 함
        System.out.println(o.roommate);
        System.out.println(o.child);
        System.out.println(o.anybody);
    }
}
