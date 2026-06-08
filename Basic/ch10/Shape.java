abstract class Shape {
    double pi = 3.14;   // 추상 클래스도 멤버필드 포함 가능

    abstract void draw();   // 추상 메서드는 본체 없음

    public double findArea() {  // 추상 클래스도 실행 베서드 포함 가능
        return 0.0;
    }
}