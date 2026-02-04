public class BMI {
    // private fields
    private String name;
    private int age;
    private double weight;
    private double height;

    private double bmi;
    private String status;

    // constructor
    public BMI(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getBMI() {
        return bmi;
    }

    public String getStatus() {
        return status;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setBMI(double bmi) {
        this.bmi = bmi;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}