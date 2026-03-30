public class Anonymous1Demo {
    Bird e = new Bird() {   // e -> Anonymous1Demo class의 멤버 필드
        // Bird class의 move() override
        public void move() {
            System.out.println("Eagle is flying.");
        }

        // 무명 클래스의 메서드로 정의
        // but Bird 타입의 객체로 접근 불가
        public void sound() {
            System.out.println("Swoosh.");
        }
    };

    public static void main(String[] args) {
        Anonymous1Demo a = new Anonymous1Demo();
        a.e.move();     // 다형성으로 오버라이딩한 메소드 호출
        // a.e.sound();    // a.e 객체가 Bird 타입이기 때문에 sound() 호출 불가
    }
}