import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.swing.JOptionPane;

// line comment

/* block
comment
 */

/**
 * documentation comments for automatically generate comment report with javadoc
 */

public class Kapitel_2 {
    public static void app() {
//        textBlockTest();
//        exercise_2_2();
//        exercise_2_3();
//        exercise_2_6();
//        exercise_2_7();
//        exercise_2_8();
//        exercise_2_11();
//        programmeringuppgift_2_1();
//        programmeringuppgift_2_2();
//        programmeringuppgift_2_3();
//        programmeringuppgift_2_4();
    }

    private static void textBlockTest() {
        String s = """
                Första rad
                Rad 2
                Sista raden""";
        System.out.println(s);
        System.out.println("*********************************");
    }

    private static void exercise_2_2() {
        String name = "Gerald";
        String address = "Hemma i Stockholm";
        int telefonNo = 123456789;

        String info = "Navn: " + name + "\nAdress: " + address + "\nTlf: " + telefonNo;
        System.out.println(info);
        System.out.println("*********************************");
    }

    private static void exercise_2_3() {
        String fNamn, eNamn, hälsning;

        System.out.print("Vad heter du till förnamn? ");
        Scanner sc = new Scanner(System.in);
        fNamn = sc.nextLine();

        System.out.print("Vad heter du till efternamn? ");
        sc = new Scanner(System.in);
        eNamn = sc.nextLine();

        hälsning = "Välkommen " + fNamn + " " + eNamn;
        System.out.println(hälsning);
        sc.close();
        System.out.println("*********************************");
    }

    private static void exercise_2_6() {
        char c1 = 216, c2 = 248;
        System.out.println("Danska och Norska bokstaver: " + c1 + " " + c2);
        System.out.println("*********************************");
    }

    private static void exercise_2_7() {
        String a = "Programspråk";
        String b = a.substring(4, 8) + a.charAt(5);
        System.out.println(b);
        System.out.println("*********************************");
    }

    private static void exercise_2_8() {
        String a = " Erik Andersson 860314-2714 ";
        a = a.trim();
        int i = a.lastIndexOf(" ") + 1;
        int j = a.indexOf("-");

        String b = a.substring(i, j);
        String c = b + " " + b.substring(b.length() - 2) + "/" +
                b.substring(b.length() - 4, b.length() - 2);

        System.out.println(c);
        System.out.println("*********************************");
    }

    private static void exercise_2_11() {
        String text = "Välkommen ";
        String fName = JOptionPane.showInputDialog("Skriv in ditt förnamn:");
        String eName = JOptionPane.showInputDialog("Skriv in ditt efternamn:");
        text += fName + " " + eName;
        JOptionPane.showMessageDialog(null, text);
    }

    private static void programmeringuppgift_2_1() {
        DateTimeFormatter formatted = DateTimeFormatter.ofPattern("hh:mm:ss");
        String time = LocalDateTime.now().format(formatted);
        System.out.println("Time now is: " + time);

    }

    private static void programmeringuppgift_2_2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Skriv in ditt namn enligt modellen - \"efternamn, förnamn:\" ");
        String namn = sc.nextLine();
        String förNamn = namn.substring(namn.indexOf(" ") + 1);
        System.out.println("Hej " + förNamn);
        System.out.println("*********************************");
    }

    private static void programmeringuppgift_2_3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Skriv in ditt namn enligt modellen - \"efternamn, förnamn:\" ");
        sc.next();
        String förNamn = sc.next();
        System.out.println("Hej " + förNamn);
        System.out.println("*********************************");
    }

    private static void programmeringuppgift_2_4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Skriv in en mening bestående av minst två ord: ");
        String text = sc.nextLine();
        System.out.println("Du skrev " + text.length() + " tecken");
        System.out.println("Det första ordet var " + "\"" + text.substring(0, text.indexOf(" ")) + "\"");
        System.out.println("Det sista ordet var " + "\"" +
                text.substring(text.lastIndexOf(" ") + 1) + "\"");
        System.out.println("*********************************");
    }
}