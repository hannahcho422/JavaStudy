package ch6.sec06;

public class One1 extends One {
    void print() {
        // ❌ 같은 패키지에 있는 자식 객체라도 부모 클래스의 private 멤버에는 접근 불가
        System.out.println(secret);     
        
        // 같은 패키지에 있는 자식 객체는 부모 클래스의 private 외의 멤버에 접근 가능
        System.out.println(roommate);
        System.out.println(child);
        System.out.println(anybody);
    }
    // ❌ 메서드 오버라이딩 시 접근 범위 좁아지면 오류 발생 
    void show() { }
}
