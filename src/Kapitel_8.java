import javax.swing.JOptionPane;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Kapitel_8 {
    public static void app() {
//        exercise_8_1();
//        exercise_8_4();
//        System.out.println(exercise_8_7(5));
//        System.out.println("Antal siffror i talet: " + exercise_8_8(124559));
//        exercise_8_10();
//        exercise_8_11("This is an alert!");
//        exercise_8_13();
//        programmeringUppgifter_8_1();
//        programmeringUppgifter_8_2();
//        programmeringUppgifter_8_4();
//        programmeringUppgifter_8_6();
//        programmeringUppgifter_8_7();
//        programmeringUppgifter_8_9("Kalender", 10);
//        programmeringUppgifter_8_10();
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

    private static double exercise_8_7(int n) {
        if(n == 1)
            return n;
        return n * exercise_8_7(n-1);
    }

    private static int exercise_8_8(int n) {
        String strNum = String.valueOf(n);
        int numOfDigits = 0;
        for (int i = 0; i < strNum.length(); i++) {
            numOfDigits++;
        }
        return numOfDigits;
    }

    private static void exercise_8_10() {
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.name"));
    }

    private static void exercise_8_11(String message) {
        for (int i = 0; i < 3; i++) {
            Toolkit.getDefaultToolkit().beep();
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(message);
    }

    private static void exercise_8_13() {
        String text = JOptionPane.showInputDialog(("Skriv in et ord:"));
        StringBuilder reverseText = new StringBuilder();

        for (int i = text.length() - 1; i >= 0; i--)
            reverseText.append(text.charAt(i));

        if (text.equalsIgnoreCase(reverseText.toString()))
            JOptionPane.showMessageDialog(null, "It is a Palindrom!");
        else
            JOptionPane.showMessageDialog(null, "It is NOT a Palindrom!");
    }

    private static void programmeringUppgifter_8_1() {
        int num = Integer.parseInt(JOptionPane.showInputDialog(("Skriv in et tal:")));
        int result = Integer.compare(num, 0);
        System.out.println(result);
    }

    private static void programmeringUppgifter_8_2() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Skriv in priset på varan: ");
        double pris = (sc.nextDouble());
        System.out.println("Skriv in % moms på varan: ");
        int moms = sc.nextInt();

        System.out.println("Moms: " + moms + "%");
        System.out.println("Pris utan moms: " + pris);
        pris += (pris * moms) / 100.0;
        System.out.println("Pris med moms: " + pris);
        sc.close();
        System.out.println("*********************************");
    }

    private static void programmeringUppgifter_8_4() {
        int num = Integer.parseInt(JOptionPane.showInputDialog("Type in a number between 1 and 10?"));

        if(num < 1 || num > 10) {
            JOptionPane.showMessageDialog(null, "Not between 1 and 10!");
            return;
        }
        for (int i = 1; i <= num; i++)
            System.out.println(i + " multiplied by " + num + " is: " + (i*num));
        System.out.println("*********************************");
    }

    private static void programmeringUppgifter_8_6() {
        String date = Calendar.getInstance().getTime().toString();
        int idx = date.indexOf(":");
        System.out.println("Time of day: " + date.substring(idx-2, idx+6));
    }

    private static void programmeringUppgifter_8_7() {
        DateTimeFormatter formatted = DateTimeFormatter.ofPattern("yyyy:MM:dd");
        String time = LocalDateTime.now().format(formatted);
        System.out.println(time);
    }

    private static void programmeringUppgifter_8_9(String s, int n) {
        if(s.length() > n)
            System.out.println(s.substring(0, n+1));
        else if(s.length() == n)
            System.out.println(s);
        else {
            StringBuilder sb = new StringBuilder();
            int numBlank = n - s.length();
            for (int i = 0; i < numBlank; i++)
                sb.append(" ");
            System.out.println(sb + s);
        }
    }

    private static void programmeringUppgifter_8_10() {
        String s1 = JOptionPane.showInputDialog("Type in a text 1: ");
        String s2 = JOptionPane.showInputDialog("Type in a text 2: ");

        s1 = s1.replace(" ", "");
        s2 = s2.replace(" ", "");

        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        String s1Sorted = new String(chars);

        chars = s2.toCharArray();
        Arrays.sort(chars);
        String s2Sorted = new String(chars);

        if(s1Sorted.equals(s2Sorted))
            JOptionPane.showMessageDialog(null, "Strings are anagram!");
        else
            JOptionPane.showMessageDialog(null, "Strings are NOT anagram!");
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