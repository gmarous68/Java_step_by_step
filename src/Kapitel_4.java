import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.text.Collator;
import java.util.Locale;
import java.util.Scanner;

public class Kapitel_4 {
    public static void App() {
//        exercise_4_1();
//        exercise_4_2();
//        exercise_4_3();
//        exercise_4_5();
//        exercise_4_8();
//        exercise_4_9();
//        exercise_4_10();
    }

    public static void exercise_4_1() {
        /*int temp = Integer.parseInt(JOptionPane.showInputDialog("Temp: ? "));
        if(temp < 18) {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("Temp is less than 18 degrees.");
        }*/

        var sc = new Scanner(System.in);
        System.out.println("Hur många gram godis? ");
        int gram = sc.nextInt();
        System.out.println("Pris pr. hekto? ");
        double pris = gram * sc.nextDouble() / 100;

        if(pris >= 100.0)
            pris = pris - (pris * 10) / 100;
        System.out.println("Pris på godis blir " + pris + " kr.");
    }

    public static void exercise_4_2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Price annual membership: ");
        double priceYear = sc.nextDouble();
        System.out.println("Price single ticket: ");
        double priceTicket = sc.nextDouble();
        System.out.println("No. of visits planned: ");
        int noOfVisits = sc.nextInt();

        if((priceTicket * noOfVisits) > priceYear)
            System.out.println("More favorable to purchase annual card.");
    }

    public static void exercise_4_3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Betyg på mattetest?: ");
        String betyg = sc.next().toUpperCase();
        sc.nextLine();
        if(betyg.equals("A"))
            System.out.println("45 poeng!");
        else if(betyg.equals("B"))
            System.out.println("40 poeng!");
        else if(betyg.equals("C"))
            System.out.println("35 poeng!");
        else if(betyg.equals("D"))
            System.out.println("30 poeng!");
        else if(betyg.equals("E"))
            System.out.println("25 poeng!");
        else
            System.out.println("Ugyldig bokstav.");
    }

    public static void exercise_4_5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Brevets längd: ");
        int l = sc.nextInt();
        System.out.println("Brevets brädd: ");
        int b = sc.nextInt();
        System.out.println("Brevets tjocklek: ");
        int t = sc.nextInt();

        if((l + b + t) > 90)
            System.out.println("Felaktig mått!");
        else
            System.out.println("Mått ok!");
    }

    public static void exercise_4_8() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Person nummer för person 1: ");
        String a = sc.nextLine();
        System.out.println("Person nummer för person 2: ");
        String b = sc.nextLine();

        if(a.length() == 12)
            a = a.substring(4,8);
        else if(a.length() == 10)
            a = a.substring(2,6);
        else
            a = "";

        if(b.length() == 12)
            b = b.substring(4,8);
        else if(b.length() == 10)
            b = b.substring(2,6);
        else
            b = "";

        if(!a.isEmpty() && !b.isEmpty()) {
            if(a.equals(b))
                System.out.println("Birthday on the same day!");
        }
        else
            System.out.println("Invalid no. of digits in personal number!");
    }

    public static void exercise_4_9() {
        Scanner sc = new Scanner(System.in);
        Collator cl = Collator.getInstance();
        cl.setStrength(Collator.PRIMARY);

        System.out.println("efternamn, förnamn på person 1: ");
        String a = sc.nextLine();
        System.out.println("efternamn, förnamn på person 2: ");
        String b = sc.nextLine();

        int result = cl.compare(a, b);
        if(result == 0)
            System.out.println("Same name..");
        else if(result > 0)
            System.out.println(b + " is before " + a);
        else
            System.out.println(a + " is before " + b);
    }

    public static void exercise_4_10() {
        String[] timeOfDay = {"dagtid", "kväll"};
        try {
            int minuteLength =
                    Integer.parseInt(JOptionPane.showInputDialog("Hur länge varar samtalet - min? "));
            int timeChoice =
                    JOptionPane.showConfirmDialog(null, "Äger samtalet tid under dagtid? ");

            if (timeChoice == 0)
                System.out.println("Samtalet " +
                        timeOfDay[timeChoice] + " koster: " + (0.60 + (minuteLength * 2.5)) + " kr!");
            else if (timeChoice == 1)
                System.out.println("Samtalet " +
                        timeOfDay[timeChoice] + " koster: " + (0.60 + (minuteLength * 0.55)) + " kr!");
            else {
                JOptionPane.showMessageDialog(null, "Avbruten!");
                System.exit(0);
            }
        }
        catch(NumberFormatException e) {
            System.out.println("Avbruten!");
        }
    }
}