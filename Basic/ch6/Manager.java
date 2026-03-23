class Manager extends Employee {
    int bonus;

    public Manager(String name, String address, int salary, int rrn, int bonus) {
        super(name, address, salary, rrn);
        this.bonus = bonus;
    }

    public void test() {
        System.out.println("name = " + name);
        System.out.println("address = " + address);
        System.out.println("salary = " + salary);
        
        // private 필드이므로 자식 클래스에서 직접 접근 불가 -> 문법 오류 발생
        // System.out.println("rrn = " + rrn);
    }
}