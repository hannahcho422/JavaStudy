class Car extends Vehicle {
    String name = "자동차";

    void whoami() {     // Override
        System.out.println("나는 자동차이다.");
    }

    static void move() {    // Override(x) bc it's static  
        System.out.println("달리다.");
    }
}