public class AbstractClassDemo {
    public static void main(String[] args) {
        // Shape s = new Shape();   추상 클래스는 생성자 사용해서 객체 생성 불가

        Circle c = new Circle(3);
        c.draw();
        System.out.printf("원의 넓이는 %.1f\n", c.findArea());
        c.findArea();
    }
}