import javax.swing.*;
import java.util.Scanner;

public class MiscCode {
    public static void fibonacci(int x) {
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

    public static void leapYear() {
        var sc = new Scanner(System.in);
        System.out.println("Type in a year: ");
        int year = sc.nextInt();

        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            System.out.println("It's a leap year!");
        else
            System.out.println("It's NOT a leap year!");
    }

    public static void ternaryOp() {
        int time = Integer.parseInt(JOptionPane.showInputDialog("Tim of day: "));

        String message = (time < 18) ? "Good day." : "Good evening.";
        System.out.println(message);
    }

    public static void newSwitch() {
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
}
