public class KoreanExample {
    public static void main(String[] args) {
        // k1, k2 객체 생성
        Korean k1 = new Korean("연세", "011225-1234567");
        Korean k2 = new Korean("믿음", "930525-0654321");

        // 객체 정보 출력
        System.out.println("k1.name : " + k1.name);
        System.out.println("k1.id : " + k1.id);
        System.out.println("k2.name : " + k1.name);
        System.out.println("k2.id : " + k1.id);
    }
}