// 에스프레소 머신 사용해 물과 함께 커피 내리는 커피 메이커 클래스
public class CoffeeMaker {
    private EspressoMachine espressoMachine;

    // CoffeeMaker가 EspressoMachine에 의존 (CoffeeMaker가 EspressoMachine 필요로 함)
    public CoffeeMaker() {
        this.espressoMachine = new EspressoMachine();
    }

    public void makeCoffee() {
        System.out.println(espressoMachine.brew());
    }
}