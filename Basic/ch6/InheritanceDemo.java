public class InheritanceDemo {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Ball c2 = new Ball("Red");

        System.out.println("Circle: ");
        c1.findRadius();
        c1.findArea();

        System.out.println("\nBall: ");
        c2.findRadius();
        c2.findArea();
        c2.findColor();
        c2.findVolume();
    }
}