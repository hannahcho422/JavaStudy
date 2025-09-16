public class Main {
    public static void main(String[] args) {
        CoffeeMaker coffeeMaker = new CoffeeMaker(); 
        coffeeMaker.setCoffeeMachine(new DripCoffeeMachine());  // 객체 주입
        coffeeMaker.makeCoffee();   
    }
}