import javax.swing.JOptionPane;
import java.awt.*;
import java.text.Collator;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
//        exercise_4_11();
//        exercise_4_12();
//        programmeringUppgifter_4_1();
//        programmeringUppgifter_4_2();
//        programmeringUppgifter_4_3();
//        programmeringUppgifter_4_4();
//        programmeringUppgifter_4_5();
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

        if (pris >= 100.0)
            pris = pris - (pris * 10) / 100;
        System.out.println("Pris på godis blir " + pris + " kr.");
        System.out.println("*********************************");
    }

    public static void exercise_4_2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Price annual membership: ");
        double priceYear = sc.nextDouble();
        System.out.println("Price single ticket: ");
        double priceTicket = sc.nextDouble();
        System.out.println("No. of visits planned: ");
        int noOfVisits = sc.nextInt();

        if ((priceTicket * noOfVisits) > priceYear)
            System.out.println("More favorable to purchase annual card.");
        System.out.println("*********************************");
    }

    public static void exercise_4_3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Betyg på mattetest?: ");
        String betyg = sc.next().toUpperCase();
        sc.nextLine();
        if (betyg.equals("A"))
            System.out.println("45 poeng!");
        else if (betyg.equals("B"))
            System.out.println("40 poeng!");
        else if (betyg.equals("C"))
            System.out.println("35 poeng!");
        else if (betyg.equals("D"))
            System.out.println("30 poeng!");
        else if (betyg.equals("E"))
            System.out.println("25 poeng!");
        else
            System.out.println("Ugyldig bokstav.");
        System.out.println("*********************************");
    }

    public static void exercise_4_5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Brevets längd: ");
        int l = sc.nextInt();
        System.out.println("Brevets brädd: ");
        int b = sc.nextInt();
        System.out.println("Brevets tjocklek: ");
        int t = sc.nextInt();

        if ((l + b + t) > 90)
            System.out.println("Felaktig mått!");
        else
            System.out.println("Mått ok!");
        System.out.println("*********************************");
    }

    public static void exercise_4_8() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Person nummer för person 1: ");
        String a = sc.nextLine();
        System.out.println("Person nummer för person 2: ");
        String b = sc.nextLine();

        if (a.length() == 12)
            a = a.substring(4, 8);
        else if (a.length() == 10)
            a = a.substring(2, 6);
        else
            a = "";

        if (b.length() == 12)
            b = b.substring(4, 8);
        else if (b.length() == 10)
            b = b.substring(2, 6);
        else
            b = "";

        if (!a.isEmpty() && !b.isEmpty()) {
            if (a.equals(b))
                System.out.println("Birthday on the same day!");
        } else
            System.out.println("Invalid no. of digits in personal number!");
        System.out.println("*********************************");
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
        if (result == 0)
            System.out.println("Same name..");
        else if (result > 0)
            System.out.println(b + " is before " + a);
        else
            System.out.println(a + " is before " + b);
        System.out.println("*********************************");
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
        } catch (NumberFormatException e) {
            System.out.println("Avbruten!");
        }
    }

    public static void exercise_4_11() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in personal number: ");
        String strPno = sc.nextLine();

        if (!strPno.isEmpty() && (strPno.length() == 12 || strPno.length() == 10)) {
            int intPNo = Integer.parseInt(strPno.substring(strPno.length() - 2, strPno.length() - 1));
            switch (intPNo) {
                case 1, 3, 5, 7, 9:
                    System.out.println("Male person number detected.");
                    break;
                case 0, 2, 4, 6, 8:
                    System.out.println("Female person number detected.");
                    break;
                default:
                    System.out.println("No idea what happend!");
            }
        } else {
            System.out.println("Invalid no. of digits in personal number!");
            return;
        }
        sc.close();
        System.out.println("*********************************");
    }

    public static void exercise_4_12() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in personal number: ");
        String strPno = sc.nextLine();

        if (!strPno.isEmpty() && (strPno.length() == 12 || strPno.length() == 10)) {
            int intPNo = Integer.parseInt(strPno.substring(strPno.length() - 2, strPno.length() - 1));
            switch (intPNo) {
                case 1, 3, 5, 7, 9 -> System.out.println("Male person number detected.");
                case 0, 2, 4, 6, 8 -> System.out.println("Female person number detected.");
                default -> System.out.println("No idea what happend!");
            }
        } else {
            System.out.println("Invalid no. of digits in personal number!");
            return;
        }
        System.out.println("*********************************");
    }

    public static void programmeringUppgifter_4_1() {
        try {
            int minuteLength =
                    Integer.parseInt(JOptionPane.showInputDialog("Hur länge skal du ringa pr. månad i min? "));

            if (minuteLength < 33)
                System.out.println("Med " + minuteLength + " samtal pr. månad skal du välja Kontant!");
            else if (minuteLength >= 33 && minuteLength <= 66)
                System.out.println("Med " + minuteLength + " samtal pr. månad skal du välja Normal!");
            else if (minuteLength > 66)
                System.out.println("Med " + minuteLength + " samtal pr. månad skal du välja Plus!");
            else {
                JOptionPane.showMessageDialog(null, "Avbruten!");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            System.out.println("Avbruten!");
        }
        System.out.println("*********************************");
    }

    public static void programmeringUppgifter_4_2() {
        try {
            int radie = Integer.parseInt(JOptionPane.showInputDialog("Tast in Cirkels radie: "));
            if (radie > 0) {
                String strResult = String.format("%.2f", (2 * Math.PI * radie));
                System.out.println("Cirkel omkrets är: " + strResult);
                strResult = String.format("%.2f", (Math.PI * Math.pow(radie, 2.0)));
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

    public static void programmeringUppgifter_4_3() {
        try {
            String strPno = JOptionPane.showInputDialog("Tast in postnummer: ");
            int intPnr = Integer.parseInt(strPno.substring(0,2));

            if((intPnr >= 20 && intPnr <= 62) || intPnr == 65 || intPnr == 66)
                System.out.println("Postnummer finns i Götaland!");
            else if(intPnr >= 80)
                System.out.println("Postnummer finns i Norrland!");
            else
                System.out.println("Postnummer finns i Svealand!");
        }
        catch(NumberFormatException | NullPointerException e) {
            System.out.println("Cancelled operation!");
        }
        System.out.println("*********************************");
    }

    public static void programmeringUppgifter_4_4() {
        DateTimeFormatter formatted = DateTimeFormatter.ofPattern("MMdd");
        String getDateNow = LocalDateTime.now().format(formatted);

        try {
            String strPNo = JOptionPane.showInputDialog("Type in personal number: ");

            if (strPNo.length() == 12) // || strPno.length() == 10)) {
                strPNo = strPNo.substring(4, 8);
            else if (strPNo.length() == 10)
                strPNo = strPNo.substring(2, 6);
            else {
                System.out.println("Invalid number!");
                System.out.println("*********************************");
            }

            if(getDateNow.equals(strPNo))
                JOptionPane.showMessageDialog(null,"Grattis!");
            else
                JOptionPane.showMessageDialog(null,"No birthday today!");
        }
        catch(NumberFormatException | NullPointerException e) {
            System.out.println("Cancelled operation!");
            System.out.println("*********************************");
        }
    }

    public static void programmeringUppgifter_4_5() {
        // Cosinussatsen lyder: a2=b2+c2−2bc⋅cosα
        double a, b, c;
        double d = 1e-10;

        try {
            a = Double.parseDouble(JOptionPane.showInputDialog("Längd sidan a?  "));
            b = Double.parseDouble(JOptionPane.showInputDialog("Längd sidan b?  "));
            int v = Integer.parseInt(JOptionPane.showInputDialog("Vinkel mellan a & b?  "));

            double gamma = v * 2 * Math.PI / 360;
            c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2) - 2 * a * b * Math.cos(gamma));
            String result = "a = " + a + ", b = " + b + ", c = " + c;

            if (Math.abs(a - b) < d && Math.abs(a - c) < d && Math.abs(b - c) < d)
                JOptionPane.showMessageDialog(null, "Triagel är liksidig!");
            else if (Math.abs(a - b) < d || Math.abs(a - c) < d || Math.abs(b - c) < d)
                JOptionPane.showMessageDialog(null, "Triagel är likbent!");
            else
                JOptionPane.showMessageDialog(null, "Triagel är oliksidig!");
            JOptionPane.showMessageDialog(null, result);
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Wrong format!");
        }
    }
}