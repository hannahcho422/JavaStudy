interface Printable {
    void print();
}

public class Lambda3Demo {
    public static void main(String[] args) {
        Printable p;
        p = () -> {
            System.out.println("Hello");
        };
        p = () -> System.out.println("Hello");
        p.print();
        
    }
}