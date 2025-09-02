import javax.swing.JOptionPane;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Kapitel_3 {
    public static void app() {
//        exercise_3_1();
//        exercise_3_2();
        exercise_3_6();
//        exercise_3_7();
//        exercise_3_8();
//        exercise_3_9();
//        exercise_3_10();
//        exercise_3_11();
//        exercise_3_12();
//        programmeringuppgift_3_1();
//        programmeringuppgift_3_2();
//        programmeringuppgift_3_3();
//        programmeringuppgift_3_4();
//        programmeringuppgift_3_5();
    }

    public static void exercise_3_1() {
        int i;
        double d;
        byte b;

        i = 500;
        d = 500;
        //b = 500; //Error -> Byte max is 127
        System.out.println("int: i " + i + ", double: " + d);
        System.out.println("*********************************");
    }

    public static void exercise_3_2() {
        int i;
        double d;
        byte b;

        // i = 500.7; // double 64bit får inte plats i en int 32bit
        d = 500.7;
        //b = 500.7; //Error -> Byte max is 127
        //System.out.println("int: i " + i);
        System.out.println("double: " + d);
        System.out.println("*********************************");
    }

    public static void exercise_3_6() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Skriv in priset på varan: ");
        double pris = (sc.nextDouble());
        System.out.println("Skriv in % moms på varan: ");
        int moms = sc.nextInt();

        System.out.println("Pris utan moms: " + pris);
        pris += (pris * moms) / 100.0;
        System.out.println("Pris med moms: " + pris);
        sc.close();
        System.out.println("*********************************");
    }

    public static void exercise_3_7() {
        int i;
        double d;
        byte b;

        i = 500;
        d = (double) 500;
        b = (byte) 500; //Error -> Byte max is 127 - show just random number
        System.out.println("int: i " + i + ", double: " + d + ", byte: " + b);
        System.out.println("*********************************");


        // i = 500.7; // Error - Cast as below
        i = (int) 500.7; // no decimals
        d = 500.7;
        b = (byte) 500.7; //Error -> Byte max is 127 - show just random number
        System.out.println("int: i " + i + ", double: " + d + ", byte: " + b);
        System.out.println("*********************************");
    }

    public static void exercise_3_8() {
        String[] weekDays = {"måndag", "tisdag", "onsdag", "torsdag", "fredag", "lördag", "söndag"};
        Scanner sc = new Scanner(System.in);
        double temp;
        double maxTemp = 0.0;

        for (int i = 0; i < weekDays.length; i++) {
            System.out.println("Tast in temp kl: 13 " + weekDays[i] + ": ");
            temp = sc.nextDouble();
            maxTemp = Math.max(temp, maxTemp);
        }
        System.out.println("Max temp i veckan var: " + maxTemp);
        sc.close();
        System.out.println("*********************************");
    }

    public static void exercise_3_9() {
        System.out.println("Math class result: " + (int) ((Math.random() * 6) + 1));
        System.out.println("*********************************");

        Random ran = new Random();
        System.out.println("Random class result: " + ran.nextInt(1, 7));
        System.out.println("*********************************");
    }

    public static void exercise_3_10() {
        System.out.println(Math.cos(Math.PI));
        System.out.println("*********************************");
    }

    public static void exercise_3_11() {
        try {
            double pris = Double.parseDouble(JOptionPane.showInputDialog("Skriv in priset på varan: "));
            int moms = Integer.parseInt(JOptionPane.showInputDialog("Skriv in % moms på varan: "));

            JOptionPane.showMessageDialog(null, "Pris utan moms: " + pris);

            pris += (pris * moms) / 100;
            String formattedStr = String.format("%.2f", pris);

            JOptionPane.showMessageDialog(null, "Pris med moms: " + formattedStr);
        } catch (NumberFormatException e) {
            System.out.println("Wrong format!");
        }
    }

    public static void exercise_3_12() {
        double a, b, c;
        try {
            a = Double.parseDouble(JOptionPane.showInputDialog("Första sidan?  "));
            b = Double.parseDouble(JOptionPane.showInputDialog("Andra sidan?  "));

            //c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
            c = Math.hypot(a, b);
            String formattedStr = String.format("%.2f", c);

            JOptionPane.showMessageDialog(null, "Hypotenusans längd är: " + formattedStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Wrong format!");
        }
    }

    public static void programmeringuppgift_3_1() {
        double radie, volym, area;
        try {
            radie = Double.parseDouble(JOptionPane.showInputDialog("Tast in Sfärens radie: "));
            volym = (4 / 3.0) * Math.PI * Math.pow(radie, 3.0);

            String formattedString = String.format("%.1f", volym);
            JOptionPane.showMessageDialog(null, "Volym: "
                    + formattedString + " cm" + '\u00B3');

            area = 4 * Math.PI * Math.pow(radie, 2.0);
            formattedString = String.format("%.1f", area);
            JOptionPane.showMessageDialog(null, "Area: "
                    + formattedString + " cm" + '\u00B2');
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Wrong format!");
        }
    }

    public static void programmeringuppgift_3_2() {
        // C = (F-32) X 5 / 9
        try {
            double fahrenheit = Double.parseDouble(JOptionPane.showInputDialog("Type in temperature in fahrenheit: "));
            double celsius = (fahrenheit - 32) * 5 / 9;
            String outPut = "Fahrenheit " + fahrenheit + " is equivalent to " + celsius + " celsius!";
            JOptionPane.showMessageDialog(null, outPut);
        } catch (NumberFormatException e) {
            System.out.println("Wrong format!");
        }
    }

    public static void programmeringuppgift_3_3() {
        final double MILES_TO_KM = 1.609; // km
        final double GALLON_TO_LTR = 3.785; // liter
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Miles per gallon? ");
            double milesPerGallon = sc.nextDouble();
            double literPerMil = GALLON_TO_LTR/milesPerGallon/MILES_TO_KM*10;

            String str = String.format("%.2f", literPerMil);
            System.out.println(str + " l/mil");
        } catch (NumberFormatException e) {
            System.out.println("Wrong format!");
        } finally {
            sc.close();
        }
        System.out.println("*********************************");
    }

    public static void programmeringuppgift_3_4() {
        double x1, x2, y1, y2;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Type in coordinate x1: ");
            x1 = sc.nextDouble();
            System.out.println("Type in coordinate x2: ");
            x2 = sc.nextDouble();
            System.out.println("Type in coordinate y1: ");
            y1 = sc.nextDouble();
            System.out.println("Type in coordinate y2: ");
            y2 = sc.nextDouble();

            double result = Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
            String strResult = String.format("%.2f", result);
            System.out.println(strResult);

        } catch (InputMismatchException e) {
            System.out.println("Wrong format!");
        } finally {
            sc.close();
        }
        System.out.println("*********************************");
    }

    public static void programmeringuppgift_3_5() {
        var scan = new Scanner(System.in);

        System.out.print("Antal år? ");
        int t = scan.nextInt();

        double lambda = Math.log(2.0) / 5730;
        double n0 = 100;  // 100 %

        double rest = n0 * Math.exp(-lambda * t);
        System.out.println("Det återstår " + rest + " %");
        System.out.println("*********************************");
    }
}
