public class Ball extends Circle {
    private String color;

    public Ball (String color) {
        this.color = color;
    }

    public void findColor() {
        System.out.println(color + " ball");
    }

    public void findVolume() {
        System.out.println("Volume is (4/3 * pi * radius * radius * radius)");
    }
}