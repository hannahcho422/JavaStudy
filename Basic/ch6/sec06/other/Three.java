package ch6.sec06;

import ch6.sec06.One;

public class Three {
    void print() {
        One o = new One();

        // 다른 패키지에 있는 클래스인 경우, public 멤버만 접근 가능
        System.out.println(o.roommate);
        System.out.println(o.child);
        System.out.println(o.anybody);

        System.out.println(o.anybody);
    }

}
