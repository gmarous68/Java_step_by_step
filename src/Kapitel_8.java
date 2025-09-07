import javax.swing.JOptionPane;
import java.util.Scanner;

public class Kapitel_8 {
    public static void app() {
//        exercise_8_1();
        exercise_8_4();
    }

    private static void exercise_8_1() {
        try {
            int radie = Integer.parseInt(JOptionPane.showInputDialog("Tast in Cirkels radie: "));
            if (radie > 0) {
                String strResult = Cirkel.omkrets(radie);
                System.out.println("Cirkel omkrets är: " + strResult);
                strResult = Cirkel.area(radie);
                System.out.println("Cirkel area är: " + strResult);
            } else {
                JOptionPane.showMessageDialog(null, "Avbruten!");
                System.exit(0);
            }
        }
        catch(NumberFormatException | NullPointerException e) {
            System.out.println("Cancelled operation!");
        }
        System.out.println("*********************************");
    }

    private static void exercise_8_4() {
        var sc = new Scanner(System.in);
        System.out.println("Type in a year: ");
        int year = sc.nextInt();

        if(Kalender.isLeapYear(year))
            System.out.println("It's a leap year!");
        else
            System.out.println("It's NOT a leap year!");
    }
}

class Cirkel {
    public static String area(int radie) {
        return String.format("%.2f", (Math.PI * Math.pow(radie, 2.0)));
    }

    public static String omkrets(int radie) {
        return String.format("%.2f", (2 * Math.PI * radie));
    }
}

class Kalender {
    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }
}