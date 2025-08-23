import javax.swing.*;
import java.util.Calendar;

public class Kapitel_1 {
    public static void printMyNameAndNumber(String fName, int tlfNo) {
        System.out.println("Namn: " + fName);
        System.out.println("Telefonnummer: " + tlfNo);
        System.out.println("*********************************");

        System.out.println("Namn: " + fName + "\nTelefonnummer: " + tlfNo + "\nAdress: Hemma i Stockholm!");
        System.out.println("*********************************");

        JOptionPane.showMessageDialog(null, fName);
        JOptionPane.showMessageDialog(null, tlfNo);

        String text = "Namn: " + fName + "\nTelefonnummer: " + tlfNo + "\nAdress: Hemma i Stockholm!";
        JOptionPane.showMessageDialog(null, text);

    }

    public static void printOtherStuff() {
        System.out.println("Hej! Välkommen " +
                "till kursen i Javaprogrammering.");
        System.out.println("*********************************");

        System.out.println(System.getProperty("user.name"));
        System.out.println("*********************************");

        System.out.println("Hej! Välkommen " + System.getProperty("user.name") + ", du användar " +
                "operativ systemet " + System.getProperty("os.name"));
        System.out.println("*********************************");

        System.out.println("Hej! \nVälkommen " +
                "till kursen i Javaprogrammering.");
        System.out.println("*********************************");

        System.out.println("Datum & tid:");
        System.out.println(Calendar.getInstance().getTime().toString());
    }
}
