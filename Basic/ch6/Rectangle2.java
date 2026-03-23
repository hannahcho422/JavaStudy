class Rectangle2 extends Shape2 {
    int width;
    int height;

    public Rectangle2() {
        // super(); // Shape2 호출
        width = 0;
        height = 0;
        System.out.println("Rectangle()");
    }

    public double calcArea() {
        return width * height;
    }
}