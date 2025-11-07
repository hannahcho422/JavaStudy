public class Practice13 {
    public static void main(String[] args) {
        String s1 = "Hello";
        s1 = s1 + " World";
        System.out.println(s1);

        String s2 = "Hi";
        change(s2);
        System.out.println(s2);
    }

    public static void change(String str) {
        str = str + "!";
    }
    
}