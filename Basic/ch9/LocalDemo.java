public class LocalDemo {
    public static void main(String[] args) {
        // 지역 클래스
        class Eagle extends Bird {    
            public void move() {    // Bird 클래스의 move() override
                System.out.println("Eagle is flying.");
            }
        }
        Bird e = new Eagle();   // e -> main() 메서드의 지역 변수
        e.move();
    }

}