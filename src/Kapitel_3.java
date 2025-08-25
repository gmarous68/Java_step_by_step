import java.util.Scanner;

public class Kapitel_3 {
    public static void App() {
        exercise_3_1();
        exercise_3_2();
        exercise_3_3();
        exercise_3_4();
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

        // i = 500.7; Måste caste som nedanför
        i = (int)500.7;
        d = 500.7;
        //b = 500.7; //Error -> Byte max is 127
        System.out.println("int: i " + i + ", double: " + d);
        System.out.println("*********************************");
    }

    public static void exercise_3_3() {
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

    public static void exercise_3_4() {

        System.out.println("*********************************");
    }
}
