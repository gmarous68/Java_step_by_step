import javax.swing.*;
import java.util.Calendar;
import java.util.Scanner;

public class Kapitel_7 {
    public static void app() {
//        exercise_7_4();
//        programmeringUppgifter_7_1();
//        programmeringUppgifter_7_2();
//        programmeringUppgifter_7_3();
    }

    private static void exercise_7_4() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int i = 1;
            System.out.println("No. of iterations: ");
            int num = sc.nextInt();

            while (i <= num) {
                System.out.print(1 + "\\" + i);
                if (!(i == num))
                    System.out.print(" + ");
                i++;
            }
            sc.nextLine();
            System.out.println("\nAgain? type y");
            String choice = sc.nextLine().toLowerCase();
            if (!choice.equals("y")) break;
        }
        sc.close();
        System.out.println("*********************************");
    }

    private static void programmeringUppgifter_7_1() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ett tal?");
        String num = sc.nextLine();
        int i;

        for (i = 0; i < num.length(); i++)
            if (num.charAt(i) < '0' || num.charAt(i) > '9')
                break;
        if (i < num.length())
            System.out.println("Tal inte ok");
        else
            System.out.println("Tal ok");
    }

    private static void programmeringUppgifter_7_2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Skriv in en mening bestående av minst två ord: ");
        String text = sc.nextLine();
        System.out.println("Du skrev " + text.length() + " tecken");

        if(!text.contains(" ") ||
                (text.contains(" ") && text.substring(text.indexOf(" ") + 1).isEmpty())) {
            System.out.println("Ord två saknas!");
            return;
        }
        System.out.println("Det första ordet var " + "\"" + text.substring(0, text.indexOf(" ")) + "\"");
        System.out.println("Det sista ordet var " + "\"" +
                text.substring(text.lastIndexOf(" ") + 1) + "\"");
        System.out.println("*********************************");
    }

    private static void programmeringUppgifter_7_3() {
        double radie, volym, area;
        boolean tryAgain = true;

        while (tryAgain) {
            try {
                radie = Double.parseDouble(JOptionPane.showInputDialog("Tast in Sfärens radie: "));

                if (radie < 0) {
                    JOptionPane.showMessageDialog(null, "Negative number not allowed!");
                    continue;
                }

                volym = (4 / 3.0) * Math.PI * Math.pow(radie, 3.0);
                tryAgain = false;

                String formattedString = String.format("%.1f", volym);
                JOptionPane.showMessageDialog(null, "Volym: "
                        + formattedString + " cm" + '\u00B3');

                area = 4 * Math.PI * Math.pow(radie, 2.0);
                formattedString = String.format("%.1f", area);
                JOptionPane.showMessageDialog(null, "Area: "
                        + formattedString + " cm" + '\u00B2');
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Cancelled operation!");
                tryAgain = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Wrong format!");
            }
        }
    }
}
