package ch6.sec06.other;

import ch6.sec06.One;

public class One2 extends One {
    void print() {
        // ❌ 자식 클래스라도 부모가 다른 패키지에 있는 경우, private과 default 멤버에 접근 불가
        System.out.println(secret);
        System.out.println(roommate);

        // 다른 패키지에 있는 public 클래스를 import
        // public 클래스가 아니면 import 불가능
        System.out.println(child);
        System.out.println(anybody);
    }
}
