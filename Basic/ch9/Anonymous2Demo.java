public class Anonymous2Demo {
    public static void main(String[] args) {
        Bird b = new Bird() {   // b -> 지역 변수
            public void move() {    // Bird 클래스의 move() override
                System.out.println("Eagle is flying.");
            }
        };
        
        b.move();
    }
}