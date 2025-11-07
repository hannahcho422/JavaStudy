public class Practice14 {
    // 내부 클래스 (Counter 객체의 상태를 나타냄)
    static class Counter {
        int value;
    }

    // Counter의 value를 증가시키는 메서드
    static void bump(Counter c) {  // 같은 객체 참조
        c.value++;                 // 내부 상태 변경 → 호출자도 보게 됨
    }

    // Counter를 새 객체로 교체하는 메서드
    static void replace(Counter c) {
        c = new Counter();         // 매개변수 변수만 새 객체를 가리킴
        c.value = 100;             // 호출자 변수와는 다른 객체
    }

    public static void main(String[] args) {
        Counter x = new Counter(); // x.value = 0
        bump(x);                   // x.value == 1 (반영 O)
        replace(x);                // x.value 여전히 1 (재할당은 반영 X)

        System.out.println("x.value = " + x.value);  // 결과: 1
    }
}