import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Scanner;

public class Kapitel_3 {
    public static void App() {
        /*exercise_3_1();
        exercise_3_2();
        exercise_3_6();*/
//        exercise_3_7();
//        exercise_3_8();
        /*exercise_3_9();
        exercise_3_10();*/
//        exercise_3_11();
//        exercise_3_12();
        //programmeringuppgift_3_1();
        programmeringuppgift_3_2();
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
        pris += (pris * moms) / 100;
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

        for(int i=0; i<weekDays.length; i++) {
            System.out.println("Tast in temp kl: 13 " + weekDays[i] + ": ");
            temp = sc.nextDouble();
            maxTemp = Math.max(temp, maxTemp);
        }
        System.out.println("Max temp i veckan var: " + maxTemp);
        sc.close();
        System.out.println("*********************************");
    }

    public static void exercise_3_9() {
        int i = (int) (Math.random() * 7);
        System.out.println("Math class result: " + i);
        System.out.println("*********************************");

        Random ran = new Random();
        i = ran.nextInt(1,7);
        System.out.println("Random class result: " + i);
        System.out.println("*********************************");
    }

    public static void exercise_3_10() {
        System.out.println(Math.cos(Math.PI));
    }

    public static void exercise_3_11() {
        try {
            double pris = Double.parseDouble(JOptionPane.showInputDialog("Skriv in priset på varan: "));
            int moms = Integer.parseInt(JOptionPane.showInputDialog("Skriv in % moms på varan: "));

            JOptionPane.showMessageDialog(null, "Pris utan moms: " + pris);

            pris += (pris * moms) / 100;
            String formattedStr = String.format("%.2f", pris);

            JOptionPane.showMessageDialog(null, "Pris med moms: " + formattedStr);
        }
        catch(NumberFormatException e) {
            System.out.println("Wrong format!");
        }
    }

    public static void exercise_3_12() {
        double a, b, c;
        try {
            a = Double.parseDouble(JOptionPane.showInputDialog("Första sidan?  "));
            b = Double.parseDouble(JOptionPane.showInputDialog("Andra sidan?  "));

            c = Math.sqrt(a * a + b * b);
            String formattedStr = String.format("%.2f", c);

            JOptionPane.showMessageDialog(null, "Hypotenusans längd är: " + formattedStr);
        }
        catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Wrong format!");
        }
    }

    public static void programmeringuppgift_3_1() {
        double radie, volym, area;
        try {
            radie = Double.parseDouble(JOptionPane.showInputDialog("Tast in Sfärens radie: "));
            System.out.println(Math.PI);
            volym = (4/3.0) * Math.PI * (radie * radie * radie);

            String formattedString = String.format("%.1f", volym);
            JOptionPane.showMessageDialog(null, "Volym: "
                    + formattedString + " cm" + '\u00B3');

            area = 4 * Math.PI * (radie * radie);
            formattedString = String.format("%.1f", area);
            JOptionPane.showMessageDialog(null, "Area: "
                    + formattedString + " cm" + '\u00B2');
        }
        catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Wrong format!");
        }
    }

    public static void programmeringuppgift_3_2() {

    }
}
