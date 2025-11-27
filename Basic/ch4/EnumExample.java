public class EnumExample {
    public enum Day { SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY };

    public static void main(String[] args) {
        Day day1 = Day.FRIDAY;
        Day day2 = Day.SATURDAY;

        System.out.println("day1's name: " + day1.name());
        System.out.println("day2's name: " + day2.name());
        System.out.println("day1's ordinal: " + day1.ordinal());
        System.out.println("day2's ordinal: " + day2.ordinal());

        System.out.println("day1.equals(day2) returns " + day1.equals(day2));
        System.out.println("day1.toString returns " + day1.toString());
        System.out.println("day1.compareTo(day2) returns " + day1.compareTo(day2));

    }
}