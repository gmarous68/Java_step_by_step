import java.util.Scanner;

public class Kapitel_5 {
    public static void app() {
//        exercise_5_1();
//        exercise_5_2();
//        exercise_5_3();
    }

    public static void exercise_5_1() {
        Scanner sc = new Scanner(System.in);
        int i = 1;

        System.out.println("No. of iterations: ");
        int num = sc.nextInt();

        while(i<=num) {
            System.out.print((int)Math.pow(i, 2));
            if(!(i==num))
                System.out.print(" + ");
            i++;
        }
        System.out.println();
        sc.close();
        System.out.println("*********************************");
    }

    public static void exercise_5_2() {
        Scanner sc = new Scanner(System.in);
        int i = 1;

        System.out.println("No. of iterations: ");
        int num = sc.nextInt();

        while(i<=num) {
            System.out.print(1 + "\\" + i);
            if(!(i==num))
                System.out.print(" + ");
            i++;
        }
        sc.close();
        System.out.println("*********************************");
    }

    public static void exercise_5_3() {
        Scanner sc = new Scanner(System.in);
        int numStuds = 0;

        System.out.println("Vilken höjd i meter slippes bollen från: ");
        double meter = sc.nextDouble();

        while(meter >= 0.01) {
            meter -= meter * 0.3;
            numStuds++;
        }
        System.out.println("Efter " + numStuds + " studs är höjd: " + meter);
        sc.close();
        System.out.println("*********************************");
    }
}
