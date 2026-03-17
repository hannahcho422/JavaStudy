class TypeCast {
    public static void main(String[] args) {
        Vehicle v = new Car();
        System.out.println(v.name);
        v.whoami();
        v.move();
    }
}