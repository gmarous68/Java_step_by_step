import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Kapitel_5 {
    public static void app() {
//        exercise_5_1();
//        exercise_5_2();
//        exercise_5_3();
//        exercise_5_4();
//        exercise_5_5();
//        exercise_5_7();
//        exercise_5_8();
//        exercise_5_9();
//        exercise_5_10();
//        exercise_5_11();
        programmeringUppgifter_5_1();
    }

    private static void exercise_5_1() {
        Scanner sc = new Scanner(System.in);
        int i = 1;

        System.out.println("No. of iterations: ");
        int num = sc.nextInt();

        while (i <= num) {
            System.out.print((int) Math.pow(i, 2));
            if (!(i == num))
                System.out.print(" + ");
            i++;
        }
        System.out.println();
        sc.close();
        System.out.println("*********************************");
    }

    private static void exercise_5_2() {
        Scanner sc = new Scanner(System.in);
        int i = 1;

        System.out.println("No. of iterations: ");
        int num = sc.nextInt();

        while (i <= num) {
            System.out.print(1 + "\\" + i);
            if (!(i == num))
                System.out.print(" + ");
            i++;
        }
        sc.close();
        System.out.println("*********************************");
    }

    private static void exercise_5_3() {
        Scanner sc = new Scanner(System.in);
        int numStuds = 0;

        System.out.println("Vilken höjd i meter slippes bollen från: ");
        double meter = sc.nextDouble();

        while (meter >= 0.01) {
            meter -= meter * 0.3;
            numStuds++;
        }
        System.out.println("Efter " + numStuds + " studs är höjd: " + meter);
        sc.close();
        System.out.println("*********************************");
    }

    private static void exercise_5_4() {
        Scanner sc = new Scanner(System.in);
        int numStuds = 0;

        while (true) {
            System.out.println("Vilken höjd i meter slippes bollen från: ");
            double meter = sc.nextDouble();

            if (meter < 0) {
                System.out.println("Negative m is not allowed!");
                break;
            }

            while (meter >= 0.01) {
                meter -= meter * 0.3;
                numStuds++;
            }
            System.out.println("Efter " + numStuds + " studs är höjd: " + String.format("%.3f", meter) + "m");
            System.out.println("*********************************");
        }
        sc.close();
    }

    private static void exercise_5_5() {
        try {
            while (true) {
                String n = JOptionPane.showInputDialog("n? (ett tal <= 0 för att sluta) ");

                if (n == null) break;

                int input = Integer.parseInt(n);
                if (input <= 0) break;

                int summa = 0, k = 1;
                while (k <= input)
                    summa += k++;

                JOptionPane.showMessageDialog(null, "Summan blir " + summa);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Nothing entered!");
        }
    }

    private static void exercise_5_7() {
        Scanner sc = new Scanner(System.in);
        int summa = 0;

        System.out.println("No. of iterations: ");
        int num = sc.nextInt();


        for (int k = 1; k <= num; k++)
            summa += k;

        System.out.println("Summen blir " + summa);

        sc.close();
        System.out.println("*********************************");
    }

    private static void exercise_5_8() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Skriv en text: ");
        String text = sc.nextLine();

        for (int k=text.length() - 1; k<text.length();  k--) {
            if (Character.isWhitespace(text.charAt(k))) {
                System.out.println("Siste tecken finns på idx " + k);
                break;
            }
        }
        sc.close();
        System.out.println("*********************************");
    }

    private static void exercise_5_9() {
        ArrayList<Double> doubleArr = new ArrayList<>();

        for (int i=-10; i<=10;  i++) {
            doubleArr.add(Math.pow((2 * i), 2) - 5 * i + 1);
        }

        int num = -10;
        for (double item : doubleArr) {
            System.out.println(num + "\t\t" + item);
            num += 1;
        }
        System.out.println("*********************************");
    }

    private static void exercise_5_10() {
        ArrayList<String> strArr = new ArrayList<>();
        double i = -1.0;

        while(i <= 1.0) {
            strArr.add(String.format("%.2f", Math.pow((2 * i), 2) - 5 * i + 1));
            i += 0.1;
        }

        double num = -1.0;
        for (String item : strArr) {
            System.out.println(String.format("%.1f", num) + "\t\t" + item);
            num += 0.1;
        }
        System.out.println("*********************************");
    }

    private static void exercise_5_11() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Skriv in et nummer för ant. rader?");
        int num = sc.nextInt();

        for(int i=num; i>0; i--) {
            for(int k=1; k<=i; k++)
                System.out.print("+");
            System.out.println();
        }
        System.out.println("*********************************");
    }

    private static void programmeringUppgifter_5_1() {

    }
}
