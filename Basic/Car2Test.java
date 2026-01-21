import java.util.Scanner;

public class Car2Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("생성할 자동차 개수 입력: ");
        int num = sc.nextInt();
        sc.nextLine();  // 버퍼 비우기

        Car2[] cars = new Car2[num];    // Car2 객체 담을 수 있는 참조 변수 칸 num개 생성

        for (int i = 0; i < num; i++) {
            System.out.println("\n자동차 " + (i + 1) + " 정보 입력");

            System.out.print("Company: ");
            String company = sc.nextLine();

            System.out.print("Model: ");
            String model = sc.nextLine();

            System.out.print("Color");
            String color = sc.nextLine();

            // 1. heap에 새로운 Car2 객체 생성
            // 2. 생성자 호출
            // 3. 필드 값 초기화
            // 4. Car2 객체 주소를 i 번째 칸에 저장
            cars[i] = new Car2(company, model, color); 
        }

        System.out.println("\n===== 생산 결과 =====");
        System.out.println("Total number of cars: " + Car2.numOfCars);
        System.out.println("Total number of red cars: " + Car2.numOfRedCars);

        sc.close();
    }
}