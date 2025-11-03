public class Practice06 {
    public static void main(String[] args) {
         // 첫 줄: 1~9 헤더 출력
         System.out.printf("%2s", "");
         for (int i=1; i<=9; i++) {
            System.out.printf("%3d", i);
         }
         System.out.println();

         // 2단부터 9단까지 반복
         for (int i=2; i <=9; i++) {
            System.out.printf("%d:", i);
            for (int j=1; j <=9; j++) {
                System.out.printf("%3d", i * j);
            }
            System.out.println();         
        }
    }
}