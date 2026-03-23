class Employee {
    String name;
    String address;
    protected int salary;
    private int rrn;

    // 생성자: 객체 만들 때 필드값 처음 넣어주는 역할
    public Employee(String name, String address, int salary, int rrn){
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.rrn = rrn;
    }

    public String toString() {
        return "name=" + name + ", address=" + address + ", salary=" + salary + ", rrn=" + rrn;
    }
}