import java.util.Comparator;
import java.util.Objects;

public class Kapitel_14 {
    public static void app() {
//        exercise_14_4();
//        exercise_14_6();
//        exercise_14_9();
//        exercise_14_10();
//        exercise_14_11();
//        programmeringuppgift_14_3();
//        programmeringuppgift_14_5();
//        programmeringuppgift_14_6();
    }

    private static void exercise_14_4() {
        Name n1 = new Name();
        n1.setName("Annie", "Hall");
        System.out.println(n1);

        n1.setName("Hall, Annie");
        System.out.println(n1);

        n1.setName("Hall, Annie", '!');
        System.out.println(n1);
    }

    private static void exercise_14_6() {
        Date d1 = new Date();
        d1.year = 1968;
        d1.month = 11;
        d1.day = 19;
        System.out.format("%04d-%02d-%02d\n", d1.year, d1.month, d1.day);

        Date d2 = new Date();
        d2.year = 1968;
        d2.month = 11;
        d2.day = 18;
        System.out.format("%04d-%02d-%02d\n", d2.year, d2.month, d2.day);
        System.out.println(d1.compareTo(d2));
    }

    private static void exercise_14_9() {
        Observation o1 = new Observation();
        o1.no = 8431;
        o1.t.tim = 11;
        o1.t.min = 12;
        o1.temp = 12.5;
        o1.windVelocity = 2.5;
        o1.windDirection = 270;

        Observation o2 = new Observation();
        o2.no = 8432;
        o2.t.tim = 11;
        o2.t.min = 11;
        o2.temp = 18;
        o2.windVelocity = 2.75;
        o2.windDirection = 90;

        Observation o3 = new Observation();
        o3.no = 8433;
        o3.t.tim = 11;
        o3.t.min = 11;
        o3.temp = 15.5;
        o3.windVelocity = 2.8;
        o3.windDirection = 360;

        if (o2.compareTo(o3) < 0)
            System.out.println(o2);
        else
            System.out.println(o3);
    }

    private static void exercise_14_10() {
        var p1 = new Person();
        p1.fName = "Lisa";
        p1.birthYear = 2002;

        var p2 = new Person();
        p2.fName = "Lisa";
        p2.birthYear = 2002;

        p1.partner = p2;

        String s = p1.fName + " år " + p1.birthYear;
        if (p1.partner == null)
            s += " is single!";
        else
            s += " is together with " + p1.partner.fName;
        System.out.println(s);

        System.out.println(p1.equals(p2));
    }

    private static void exercise_14_11() {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();
        EquRectangle eq = new EquRectangle();

        r1.setWidth(20);
        r1.setHeight(10);
        r2.setWidth(20);
        r2.setHeight(10);

        if(eq.compare(r1, r2) < 0)
            System.out.println("Rectangle 1 < Rectangle 2!");
        else if(eq.compare(r1, r2) > 0)
            System.out.println("Rectangle 2 > Rectangle 1!");
        else
            System.out.println("Rectangle 1 is equal to Rectangle 2!");
    }

    private static void programmeringuppgift_14_3() {
        Card a = new Card();
        Card b = new Card();

        a.color = Card.SPADES;
        a.value = 12;
        System.out.println(a);

        b.color = Card.DIAMONDS;
        b.value = 7;
        System.out.println(b);

        System.out.println(a.equals(b));

        a.changeCard(Card.DIAMONDS, 7);
        System.out.println(a);

        System.out.println(a.equals(b));
    }

    private static void programmeringuppgift_14_5() {
        Date d = new Date();
        d.year = 1968;
        d.month = 11;
        d.day = 19;
        System.out.println(d);
    }

    private static void programmeringuppgift_14_6() {
        Calculator cal = new Calculator();
        cal.init(4, 8);
        cal.increase();
        cal.increase();
        cal.increase();
        cal.increase();
        cal.increase();
        cal.decrease();
        cal.decrease();
    }
}

class Calculator {
    private int value, min, max;

    public void init(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void increase() {
        if(value >= this.max)
            System.out.println("Not able to increase!");
        else
            System.out.println("Increase by 1 to " + ++value);
    }

    public void decrease() {
        if(value <= this.min)
            System.out.println("Not able to decrease!");
        else
            System.out.println("Decreased by 1 to " + --value);
    }
}

class EquRectangle implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        if (o1.area() < o2.area())
            return -1;
        if (o1.area() > o2.area())
            return 1;
        if (o1.perimeter() < o2.perimeter())
            return -1;
        if (o1.perimeter() > o2.perimeter())
            return 1;
        return 0;
    }
}

class Person {
    String fName;
    int birthYear;
    Person partner;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return birthYear == person.birthYear &&
                Objects.equals(fName, person.fName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fName, birthYear);
    }
}

class Observation implements Comparable<Observation> {
    int no, tim, min, windDirection;
    Time t = new Time();
    double temp, windVelocity;

    @Override
    public int compareTo(Observation o) {
        int x = t.compareTo(o.t);
        if (x == 0) {
            if (no < o.no)
                return -1;
            else return 1;
        }
        return x;
    }

    @Override
    public String toString() {
        return "Observation{" +
                "no=" + no +
                ", tim=" + tim +
                ", min=" + min +
                ", windDirection=" + windDirection +
                ", t=" + t +
                ", temp=" + temp +
                ", windVelocity=" + windVelocity +
                '}';
    }
}

class Time implements Comparable<Time> {
    int tim, min;

    @Override
    public int compareTo(Time o) {
        if (tim < o.tim || (tim == o.tim && min < o.min))
            return -1;
        if (tim > o.tim || (tim == o.tim && min > o.min))
            return 1;
        return 0;
    }

    public void increaseOneMin() {
        min++;
        if(min > 59) {
            tim++;
            min = 0;
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", tim, min);
    }
}

class Date implements Comparable<Date> {
    int day, month, year;

    @Override
    public String toString() {
        String s = year + "-" + month + "-" + day;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            return s += " is leap year!";
        return s;
    }

    @Override
    public int compareTo(Date o) {
        if (this.year == o.year && this.month == o.month && this.day == o.day)
            return 0;
        if (this.year < o.year)
            return -1;
        if (this.year == o.year && this.month < o.month)
            return -1;
        if (this.year == o.year && this.month == o.month && this.day < o.day)
            return -1;
        return 1;
    }


}

class Name {
    private String fName;
    private String lName;
    private char end;

    public void setName(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public void setName(String name) {
        int k = name.indexOf(',');
        if (k < 0)
            throw new IllegalArgumentException("Error in name input!");

        this.lName = name.substring(0, k).trim();
        this.fName = name.substring(k + 1).trim();
    }

    public void setName(String name, char end) {
        setName(name);
        this.end = end;
    }

    @Override
    public String toString() {
        return (end == '\u0000') ? "First name: " + fName + ", Last name: " + lName :
                "First name: " + fName + ", Last name: " + lName + end;
    }
}
