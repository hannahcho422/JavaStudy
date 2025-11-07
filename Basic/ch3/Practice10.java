// Prime Numbers
public class Practice10 {
    public static void main(String[] args) {
        int count = 0;      // 소수 개수
        int num = 2;        // 소수 판별 시작 숫자
        int lineCount = 0;  // 한 줄에 출력된 소수 개수 

        System.out.println("The first 50 prime numbers are: ");

        while (count < 50) {
            boolean isPrime = true;
            // 1과 자기 자신 외에 나누어 떨어지면 소수 아님
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            // 소수인 경우
            if(isPrime) {
                System.out.printf("%4d", num);
                count++;
                lineCount++;

                if(lineCount == 10) {
                    System.out.println();
                    lineCount = 0;
                }
            }
            num++;
        }
    }
}

