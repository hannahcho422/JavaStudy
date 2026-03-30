public class MemberDemo {
    // Member class
    class Eagle extends Bird {
        public void move() {    // Bird class의 move() override
            System.out.println("Eagle is flying.");
        }

        public void sound() {   // Eagle class에 추가한 메서드
            System.out.println("Swoosh.");
        }
    }

    // MemberDemo class의 멤버 필드
    Eagle e = new Eagle();

    public static void main(String[] args) {
        MemberDemo m = new MemberDemo();
        // MemberDemo class의 객체 m의 멤버 필드 e 객체의 move(), sound() 메서드 호출
        m.e.move();
        m.e.sound();
    }
}