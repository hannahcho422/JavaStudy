public class Car2{
    // instance fields
    String company;
    String model;
    String color;

    // static fields
    static int numOfCars;
    static int numOfRedCars;

    // constructor
    public Car2(String company, String model, String color) {
        this.company = company;
        this.model = model;
        this.color = color;

        numOfCars++;

        if (color.equalsIgnoreCase("red")) {
            numOfRedCars++;
        }
    }
}