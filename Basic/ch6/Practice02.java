public class Practice02 {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();

        rect.setX(5);
        rect.setY(3);
        rect.setWidth(10);
        rect.setHeight(20);

        rect.print();
        System.out.println("(" + rect.getX() + ", " + rect.getY() + ") 위치에 가로: " 
                + rect.getWidth() + ", 세로: " + rect.getHeight());

        rect.setX(8);
        rect.setY(9);
        rect.print();
        rect.draw();   
    }
}