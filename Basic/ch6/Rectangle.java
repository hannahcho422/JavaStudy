class Rectangle extends Shape {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public void draw() {
        System.out.println("(" + getX() + ", " + getY() + ") 위치에 가로: " + width + ", 세로: " + height);
    }
}