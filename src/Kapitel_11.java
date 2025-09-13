import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

class Kapitel_11 {
    public static void app() {
//        exercise_11_1();
//        exercise_11_2();
//        exercise_11_4();
//        exercise_11_5();
//        exercise_11_6();
//        exercise_11_8();
//        exercise_11_9();
//        programmeringuppgift_11_1();
//        programmeringuppgift_11_2();
//        programmeringuppgift_11_3();
//        programmeringuppgift_11_4();
//        programmeringuppgift_11_5();
//        programmeringuppgift_11_6();
//        programmeringuppgift_11_7();
    }

    private static void exercise_11_1() {
        double[] dblArr = new double[4];
        int[] intArr = {5, 10, 20, 50, 100, 200, 500};
        System.out.println(Arrays.toString(dblArr));
        System.out.println(Arrays.toString(intArr));
    }

    private static void exercise_11_2() {
        double[] dblArr = new double[10];
        for (int i = 0; i < dblArr.length; i++)
            dblArr[i] = 1 / (i + 1.0);
        for (double item : dblArr)
            System.out.print(String.format("%.4f", item) + " ");
        System.out.println();
    }

    private static void exercise_11_4() {
        double[] dblArr = new double[10];
        int k = dblArr.length - 1;
        for (int i = k; i > 0; i--)
            dblArr[k - i] = 1 / (i + 1.0);
        for (double item : dblArr)
            System.out.print(String.format("%.4f", item) + " ");
        System.out.println();
    }

    private static void exercise_11_5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many subscription to compare? ");
        int n = sc.nextInt();
        sc.nextLine();
        int minPrice = Integer.MAX_VALUE;
        String output = "";

        for (int i = 0; i < n; i++) {
            System.out.println("Subscription name? ");
            String name = sc.nextLine();
            System.out.println("Subscription price? ");
            int price = sc.nextInt();
            sc.nextLine();

            if (price < minPrice) {
                minPrice = price;
                output = "Subscriber " + name + " with price " + minPrice + " is the lowest!";
            }
        }
        System.out.println(output);
        sc.close();
    }

    private static void exercise_11_6() {
        int[] intArr1 = new int[100];
        int[] intArr2 = new int[20];
        int k = 9;

        for (int i = 0; i < intArr1.length; i++) {
            intArr1[i] = i;
        }
        for (int i = 50; i < 55; i++) {
            intArr2[k++] = i;
        }
        System.out.println(Arrays.toString(intArr2));
        System.arraycopy(intArr1, 95, intArr2, 3, 5);
        System.out.println(Arrays.toString(intArr2));
    }

    private static void exercise_11_8() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many subscription to compare? ");
        int n = sc.nextInt();
        int[] intArr = new int[n];
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Subscription price " + (i + 1) + "? ");
            intArr[i] = sc.nextInt();
            sc.nextLine();
        }
        System.out.println("Average value for " + n + " subscriptions: " + medel(intArr));
        sc.close();
    }

    private static void exercise_11_9() {
        double[] dblArr = {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
        var modifiedArr = fill(dblArr, 5, 8, 2.3);
        skrivUt(modifiedArr, 0, modifiedArr.length);
    }

    private static void programmeringuppgift_11_1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in numbers - redundant numbers will be removed!");
        System.out.println("exit with ctrl+d");
        int[] intArr = new int[100];
        int antal = 0;
        while (sc.hasNextInt())
            intArr[antal++] = sc.nextInt();

        for (int i = 0; i < intArr.length; i++) {
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (intArr[i] == intArr[j])
                    found = true;
            }
            if (!found)
                System.out.println(intArr[i]);
        }
    }

    private static void programmeringuppgift_11_2() {
        String currDir = System.getProperty("user.dir");
        JFileChooser fc = new JFileChooser(currDir);
        if (fc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
            System.out.println("No file selected!");
            System.exit(0);
        }

        double maxTemp = Integer.MIN_VALUE, totTemp = 0;
        int totDays = 0;
        double[] dblArr = new double[31];

        try (Scanner sc = new Scanner(new File(fc.getSelectedFile().getAbsolutePath()))) {
            while (sc.hasNextLine()) {
                String dayNo = sc.next();
                while (sc.hasNextDouble()) {
                    double temp = sc.nextDouble();
                    dblArr[totDays++] = temp;
                    totTemp += temp;
                }
            }
            System.out.println("Average temp in month: " + String.format("%.2f", (totTemp / totDays)) + " C gr");

            for (int i = 0; i < dblArr.length; i++) {
                if (dblArr[i] > (totTemp / totDays)) {
                    String output = "Temp: " + dblArr[i] + " C gr on day " + (i + 1) + ", is > average: "
                            + String.format("%.2f", (totTemp / totDays)) + " C gr";
                    System.out.println(output);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void programmeringuppgift_11_3() {
        int[] intArr1 = {5, 7, 9, 10, 15, 18, 19, 25, 26, 47, 99};
        int[] intArr2 = {7, 5, 3, 8, 9, 10, 5, 84, 77, 65, 15, 4};
        System.out.println("Array 1 sorted?: " + isSortedArray(intArr1));
        System.out.println("Array 2 sorted?: " + isSortedArray(intArr2));
    }

    private static void programmeringuppgift_11_4() {
        double[] dblArr1 = {5, 7, 9, 10, 15, 18, 19, 20, 88, 47, 45};
        double[] dblArr2 = new double[dblArr1.length];
        arrayCopy(dblArr1, 3, dblArr2, 2, 5);
        System.out.println(Arrays.toString(dblArr2));
    }

    private static void programmeringuppgift_11_5() {
        int[] intArr1 = {5, 7, 9, 10, 15, 18, 19, 25, 26, 47, 99};
        int[] intArr2 = {5, 7, 9, 10, 15, 18, 19, 25, 26, 47, 99};
        if (arrayEquals(intArr1, intArr2))
            System.out.println("Equal");
        else
            System.out.println("NOT equal");
    }

    private static void programmeringuppgift_11_6() {
        double[] dblArr = {1.2, 5.4, 3.4, 7.1, 1.7, 1.8, 3.4, 2.84};
        System.out.println("Sum of all elements in array: " + sum(dblArr));
        System.out.println("Sum of all elements kvadratisk: " + kvadSum(dblArr));
    }

    private static void programmeringuppgift_11_7() {
        int[] intArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int temp = 0;

        for (int i = 0; i < intArr.length - 1; i++) {
            temp = intArr[i + 1];
            intArr[i + 1] = intArr[0];
            intArr[0] = temp;
        }
        System.out.println(Arrays.toString(intArr));
    }

    private static String sum(double[] a) {
        double totSum = 0;
        for (int i = 0; i < a.length; i++) {
            totSum += a[i];
        }
        return String.format("%.2f", totSum);
    }

    private static String kvadSum(double[] a) {
        double totSum = 0;
        for (int i = 0; i < a.length; i++) {
            totSum += Math.pow(a[i], 2);
        }
        return String.format("%.2f", totSum);
    }

    private static boolean arrayEquals(int[] a, int[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] != b[i])
                    return false;
            }
        }
        return true;
    }

    private static void arrayCopy(double[] a, int startArrA, double[] b, int startArrB, int length) {
        for (int i = startArrA; i < startArrA + length; i++) {
            while (startArrB < (startArrB + length)) {
                b[startArrB++] = a[i];
                break;
            }
        }
    }

    private static boolean isSortedArray(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i])
                    return false;
            }
        }
        return true;
    }

    private static double[] fill(double[] a, int first, int last, double num) {
        for (int i = first; i < last; i++) {
            a[i] = num;
        }
        return a;
    }

    private static double medel(int[] a) {
        double total = 0;
        for (int i = 0; i < a.length; i++) {
            total += a[i];
        }
        return total / a.length;
    }

    private static void skrivUt(double[] a, int first, int last) {
        /*for (int i = first; i < last; i++) {
            System.out.println(a[i]);
        }*/
        System.out.println(Arrays.toString(a));
    }
}
