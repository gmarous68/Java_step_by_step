import javax.swing.*;
import java.time.LocalDateTime;

public class Kapitel_1 {
    public static void App(String fName, int tlfNo) {
        exercise_1_6(fName, tlfNo);
        exercise_1_7(fName, tlfNo);
        printOtherStuff();
        exercise_1_8(fName, tlfNo);
        exercise_1_9(fName, tlfNo);
        exercise_1_10(fName, tlfNo);
        programmeringuppgift_1_7();
    }

    public static void exercise_1_6(String fName, int tlfNo) {
        System.out.println("Namn: " + fName);
        System.out.println("Telefonnummer: " + tlfNo);
        System.out.println("*********************************");
    }

    public static void exercise_1_7(String fName, int tlfNo) {
        System.out.println("Hej! Välkommen " + System.getProperty("user.name") + ", du användar " +
                "operativ systemet " + System.getProperty("os.name"));
        System.out.println("*********************************");

        System.out.println("Hej! \nVälkommen " +
                "till kursen i Javaprogrammering.");
        System.out.println("*********************************");
    }

    public static void exercise_1_8(String fName, int tlfNo) {
        System.out.println("Namn: " + fName + "\nTelefonnummer: " + tlfNo + "\nAdress: Hemma i Stockholm!");
        System.out.println("*********************************");
    }

    public static void exercise_1_9(String fName, int tlfNo) {
        JOptionPane.showMessageDialog(null, fName);
        JOptionPane.showMessageDialog(null, tlfNo);
    }

    public static void exercise_1_10(String fName, int tlfNo) {
        String text = "Namn: " + fName + "\nTelefonnummer: " + tlfNo + "\nAdress: Hemma i Stockholm!";
        JOptionPane.showMessageDialog(null, text);
    }

    public static void programmeringuppgift_1_7() {
        System.out.println("Datum & tid:");
        System.out.println(LocalDateTime.now());
        System.out.println("*********************************");
    }

    public static void printOtherStuff() {
        System.out.println("Hej! Välkommen " +
                "till kursen i Javaprogrammering.");
        System.out.println("*********************************");

        System.out.println(System.getProperty("user.name"));
        System.out.println("*********************************");
    }
}