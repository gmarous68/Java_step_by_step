import javax.swing.*;
import java.util.Scanner;


public class MiscCode {
    private static void fibonacci(int x) {
        /* Print the Fibonacci sequence for values <= x */
        int lo = 1, hi = 1;
        System.out.print(lo + " ");

        while (hi <= x) {
            System.out.print(hi + " ");
            hi = lo + hi;
            lo = hi - lo;
        }
        System.out.println();
    }

    private static void momsCompute() {
        double itemPriceDouble = Double.parseDouble(JOptionPane.showInputDialog("Vad är varans totala pris?"));
        int taxRateDouble = Integer.parseInt(JOptionPane.showInputDialog("Vad är momsen i heltal?"));

        //double itemPriceDoubleWithoutTax = itemPriceDouble / (1 + (double)taxRateDouble / 100);
        //double momsPrice = itemPriceDouble - itemPriceDoubleWithoutTax;
        double momsPrice = itemPriceDouble / (taxRateDouble * 0.01 +1);
        double moms = itemPriceDouble - momsPrice;


        JOptionPane.showMessageDialog(null,"Varans pris exkl. moms: " + String.format("%.2f",momsPrice) +
                "\n" + "Momspriset: " + String.format("%.2f", moms));
    }

    private static void leapYear() {
        var sc = new Scanner(System.in);
        System.out.println("Type in a year: ");
        int year = sc.nextInt();

        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            System.out.println("It's a leap year!");
        else
            System.out.println("It's NOT a leap year!");
    }

    private static void ternaryOp() {
        int time = Integer.parseInt(JOptionPane.showInputDialog("Tim of day: "));

        String message = (time < 18) ? "Good day." : "Good evening.";
        System.out.println(message);
    }

    private static void newSwitch() {
        String month = JOptionPane.showInputDialog("Which month: (type 3 first letters in month)");
        int days = switch (month.toLowerCase()) {
            case "apr", "jun", "sep", "nov" -> 30;
            case "jan", "mar", "may", "jul", "aug", "oct", "dec" -> 31;
            case "feb" -> 28;
            default -> {
                System.out.println("Illegal option types in!");
                yield 0;
            }
        };
        System.out.println(month + " has " + days + " days!");
    }

    private static void antBlank() {
        int summa = 0;
        String text = JOptionPane.showInputDialog("Tasta in en sträng: ");

        for(int i=0; i<text.length(); i++) {
            if(Character.isWhitespace(text.charAt(i)))
                summa++;
        }
        JOptionPane.showMessageDialog(null, "Antal blanka tecken: " + summa);
    }

    private static void bankProgram() {
        int procent = Integer.parseInt(JOptionPane.showInputDialog("Skriva in procent: "));
        int antYear  = Integer.parseInt(JOptionPane.showInputDialog("Skriva in ant år: "));

        StringBuilder str = new StringBuilder("År    Kapital\n");
        double summa = 1000;

        for(int i=0; i<antYear; i++) {
            summa += (summa * procent) / 100;
            str.append((i+1)).append("     ").append(String.format("%.2f", summa)).append(" kr\n");
        }
        JOptionPane.showMessageDialog(null, str);
    }
}
