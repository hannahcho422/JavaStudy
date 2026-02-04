public class TestCircle {
    public static void main(String[] args) {
        // 객체1
        Circle circle1 = new Circle();
        printCircle("circle1", circle1);

        // 객체2
        Circle circle2 = new Circle(25);
        printCircle("circle2", circle2);

        // 객체3
        Circle circle3 = new Circle(125);
        printCircle("circle3", circle3);

        // modify radius
        System.out.println();
        System.out.println("circle1의 반지름을 100으로 수정한 후 :");
        circle1.setRadius(100);
        printCircle("circle1", circle1);
    }

    // 출력 메서드
    private static void printCircle(String name, Circle c) {
        System.out.printf(
            "%s: 원의 반지름이 %.1f일 때, 넓이는 %.2f, 둘레는 %.2f%n",
            name,
            c.getRadius(),
            c.getArea(),
            c.getCircumference()
        );
    }
}