/* 내부 인터페이스 사용 */

// Icon.Touchable(): Icon 클래스의 멤버 Touchable interface
public class InnerInterfaceDemo implements Icon.Touchable {     // InnerInterfaceDemo 클래스가 Icon.Touchable 인터페이스를 구현한다 
                                                                // -> 인터페이스를 구현하면, 그 안에 있는 추상 메서드를 반드시 구현해야 함
    public void touch() {
        System.out.println("아이콘을 터치한다.");
    }

    public static void main(String[] args) {
        Icon.Touchable btn = new InnerInterfaceDemo();
        btn.touch();
    }
}