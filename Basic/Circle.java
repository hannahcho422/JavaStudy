public class Circle {
    // Field
    private double radius;

    // Constructor1 : default radius 1
    public Circle() {
        this.radius = 1.0;
    }

    // Constructor2 : 반지름을 매개변수로 받음
    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return Math.PI * 2 * radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}