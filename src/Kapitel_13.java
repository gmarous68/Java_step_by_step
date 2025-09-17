import java.util.Objects;

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
        GOT.latGr = 57;
        GOT.latMin = 39;
        GOT.latSek = 47;
        GOT.latNorth = true;
        GOT.longGr = 12;
        GOT.longMin = 16;
        GOT.longSek = 58;
        GOT.longEast = true;
        System.out.println(GOT);
        System.out.println("*********************************");

        var ARN = new Position();  // Arlanda
        ARN.latGr = 59;
        ARN.latMin = 24;
        ARN.latSek = 52;
        ARN.latNorth = true;
        ARN.longGr = 17;
        ARN.longMin = 55;
        ARN.longSek = 18;
        ARN.longEast = true;
        System.out.println(ARN);
        System.out.println("*********************************");
    }

    private static void programmeringuppgift_13_6() {
        Card a = new Card();
        Card b = new Card();
        a.color = Card.SPADES;
        a.value = 12;
        b.color = Card.CLOVES;
        b.value = 7;
    }
}

class Card {
    public static final int CLOVES = 0;
    public static final int DIAMONDS = 1;
    public static final int HEARTS = 2;
    public static final int SPADES = 3;
    int value;
    int color;

    @Override
    public String toString() {
        String v = switch (value) {
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 -> "Nine";
            case 10 -> "Ten";
            case 11 -> "Jack";
            case 12 -> "Queen";
            case 13 -> "King";
            case 14 -> "Ace";
            default -> throw new IllegalArgumentException("No such value!");
        };

        String c = switch (color) {
            case CLOVES -> "Cloves";
            case DIAMONDS -> "Diamonds";
            case HEARTS -> "Hearts";
            case SPADES -> "Spades";
            default -> throw new IllegalArgumentException("No such value!");
        };

        return "Card: " + v + " of " + c;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value && color == card.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, color);
    }

    public void changeCard(int c, int v) {
        if (v < 1 || v > 14) {
            System.out.println("Wrong card number!");
            return;
        }
        if (c < 0 || c > 3) {
            System.out.println("Wrong card color!");
            return;
        }
        this.color = c;
        this.value = v;
    }
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