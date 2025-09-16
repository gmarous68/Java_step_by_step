public class Kapitel_13 {
    public static void app() {
//        programmeringuppgift_13_1();
//        programmeringuppgift_13_2();
//        programmeringuppgift_13_6();
    }

    private static void programmeringuppgift_13_1() {
        Bok b1 = new Bok();
        b1.title = "The Kite Runner";
        b1.author = "Khaled Husseini";
        b1.pages = 253;
        b1.price = 29.99;
        System.out.println(b1);

        Bok b2 = new Bok();
        b2.title = "Death in the afternoon";
        b2.author = "Ernest Hemingway";
        b2.pages = 311;
        b2.price = 39.99;
        System.out.println(b2);
    }

    private static void programmeringuppgift_13_2() {
        var GOT = new Position();  // Landvetter
        GOT.latGr = 57;  GOT.latMin = 39;  GOT.latSek = 47;  GOT.latNorth = true;
        GOT.longGr = 12; GOT.longMin = 16; GOT.longSek = 58; GOT.longEast = true;
        System.out.println(GOT);
        System.out.println("*********************************");

        var ARN = new Position();  // Arlanda
        ARN.latGr = 59;  ARN.latMin = 24;  ARN.latSek = 52;  ARN.latNorth = true;
        ARN.longGr = 17; ARN.longMin = 55; ARN.longSek = 18; ARN.longEast = true;
        System.out.println(ARN);
    }

    private static void programmeringuppgift_13_6() {
        Card a = new Card();
        Card b = new Card();
        a.color = Card.SPADES;
        a.value = 12;
        b.color = Card.CLOVS;
        b.value = 7;
    }
}

class Card {
    public static final int CLOVS = 0;
    public static int DIAMONDS = 1;
    public static int HEARTS = 2;
    public static int SPADES = 3;
    int value;
    int color;
}

class Position {
    int latGr, latMin, latSek;
    boolean latNorth;
    int longGr, longMin, longSek;
    boolean longEast;

    @Override
    public String toString() {
        return "Position:\nlatGr: " + latGr + ", latMin: " + latMin + ", latSek: " + latSek + ", latNorth: " + latNorth + "\n"
                + "longGr: " + longGr + ", longMin: " + longMin + ", longSek: " + longSek + ", longEast: " + longEast;

    }
}

class Bok {
    String title;
    String author;
    int pages;
    double price;

    @Override
    public String toString() {
        return "Bok{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                '}';
    }
}