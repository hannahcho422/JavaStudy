public class Practice04 {
    public static void main(String[] args) {
        BadBank badBank = new BadBank();
        NormalBank normalBank = new NormalBank();
        GoodBank goodBank = new GoodBank();

        System.out.println("BadBank의 이자율: " + badBank.getInterestRate());
        System.out.println("NormalBank의 이자율: " + normalBank.getInterestRate());
        System.out.println("GoodBank의 이자율: " + goodBank.getInterestRate());
    }
}