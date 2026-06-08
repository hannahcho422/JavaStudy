class Circle extends Shape {
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    // 부모 클래스에서 추상 메서드로 선언했기 때문에 자식 클래스에서 반드시 구현
    public void draw() {
        System.out.println("Draw a circle.");
    }

    // 부모 클래스에서 메서드 오버라이딩
    public double findArea() {
        return pi*radius*radius;
    }
}