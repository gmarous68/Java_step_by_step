import javax.swing.*;
import java.util.Locale;
import java.util.Scanner;

public class Kapitel_9 {
    public static void app() {
//        Locale.setDefault(Locale.US);
//        Locale.setDefault(new Locale("sv", "SE"));
//        exercise_9_1();
//        exercise_9_2();
//        exercise_9_5();
        programmeringUppgifter_9_1();
    }

    private static void exercise_9_1() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Type in a decimal number: ");
        while(!sc.hasNextDouble()) {
            if(!sc.hasNext())
                System.exit(0);
            sc.nextLine();
            System.out.println("Felaktig decimal tal");
        }
        sc.close();
    }

    private static void exercise_9_2() {
        String s = JOptionPane.showInputDialog("Type in a number of int's - separated with blank");
        Scanner sc = new Scanner(s);
        int sum = 0;

        while(sc.hasNextInt())
            sum += sc.nextInt();

        JOptionPane.showMessageDialog(null, "Sum is: " + sum);
        sc.close();
    }

    private static void exercise_9_5() {
        for (int i = 1; i <= 30; i++) {
            System.out.format("%02d -> 2 in power of " + i + " = %15.2f\n", i, Math.pow(2, i));

        }
    }

    private static void programmeringUppgifter_9_1() {
        try {
            int antMilNow = Integer.parseInt(JOptionPane.showInputDialog("Dagens mäterställning i mil?"));
            int antMilLastYear = Integer.parseInt(JOptionPane.showInputDialog("Mäterställning för ett år sedan?"));
            int noOfLitersUsed = Integer.parseInt(JOptionPane.showInputDialog("Antal liter förbrukat bensin?"));

            int diffMil = antMilNow - antMilLastYear;
            double gasUsedPerMil = noOfLitersUsed / (double)diffMil;

            String output = "Dagens mäterställning: %14d\nMäterställning ett år sedan: %8d\n"
                    + "Antal ltr bensin förbrukat: %9d\nAntal körde mil: %20d\nFörbruk per mil: %20.2f\n";
            System.out.format(output, antMilNow, antMilLastYear, noOfLitersUsed, diffMil, gasUsedPerMil);
        } catch(NumberFormatException e) {
            System.out.println("Wrong format!");
        }
    }
}
