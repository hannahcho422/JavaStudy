public class CoffeeMaker {
    private CoffeeMachine coffeeMachine;

    // 외부에서 CoffeeMachine 구현체를 주입받음
    public void setCoffeeMachine(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public void makeCoffee() {
        System.out.println(coffeeMachine.brew());
    }
}