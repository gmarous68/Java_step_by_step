import javax.swing.*;

public class Kapitel_6 {
    public static void app() {
//        exercise_6_2();
//        exercise_6_3();
    }

    private static void exercise_6_2() {
        try {
            int a = Integer.parseInt(JOptionPane.showInputDialog("Skriv in heltal a ?"));
            int b = Integer.parseInt(JOptionPane.showInputDialog("Skriv in heltal b ?"));

            while (true) {
                int r = a % b;
                a = b;
                b = r;
                if (b == 0) {
                    System.out.println("Den största gemensamma delaren av a och b: " + a);
                    break;
                }
            }
        } catch (ArithmeticException e) {
            System.out.println("Division by 0 not allowed!");
        }
    }

    private static void exercise_6_3() {
        StringBuilder strPrim = new StringBuilder("Primenumber < tal:\n");

        try {
            while (true) {
                int num = Integer.parseInt(JOptionPane.showInputDialog("Skriv in et tal? -avluta? - skriv 0 eller tal <0!"));

                if (num <= 0) break;

                int antal = 0;
                for (int i = 1; i <= num; i++) {
                    boolean isPrime = true;
                    for (int k = 2; k < i; k++)
                        if (i % k == 0)
                            isPrime = false;
                    if (isPrime) {
                        antal++;
                        strPrim.append(" " + i);
                    }
                }
                JOptionPane.showMessageDialog(null, strPrim);
                break;
            }
        } catch (NullPointerException e) {
            // if pressed cancel or x
            JOptionPane.showMessageDialog(null, "Cancelled operation!");
        } catch (NumberFormatException e) {
            // if alpha characters in string to number parse
            JOptionPane.showMessageDialog(null, "Not able to parse to number!!");
        }
    }
}
