import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Kapitel_10 {
    public static void app() {
//        exercise_10_2_1();
//        exercise_10_2_2();
//        exercise_10_3();
        exercise_10_4();
    }

    private static void exercise_10_2_1() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int maxInputNum = Integer.MIN_VALUE;
            while (true) {
                System.out.println("Skriv in et tal & tryck enter: (avsluta med ctrl + d)");
                String t = br.readLine();
                if (t == null)
                    break;
                int inputNum = Integer.parseInt(t);
                maxInputNum = Math.max(inputNum, maxInputNum);
            }
            System.out.println("Det största talet: " + maxInputNum);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Wrong format!");
        }
    }

    private static void exercise_10_2_2() {
        System.out.println("Mata in et antal heltal och tryck på Enter/Retur ");
        System.out.println("Avsluta med tom sträng & Enter eller ctrl+d");
        Scanner scan = new Scanner(System.in);
        int maxValue = Integer.MIN_VALUE;
        int num = 0;

        while (scan.hasNextLine()) {
            String txt = scan.nextLine();

            if (txt == null || txt.isEmpty())
                break;

            try {
                num = Integer.parseInt(txt);
            } catch (NumberFormatException e) {
                System.out.println("Du måste skriva in ett heltal!");
            }
            maxValue = Math.max(num, maxValue);
        }
        System.out.println("Max value: " + maxValue);
        scan.close();
    }

    private static void exercise_10_3() {
        try (BufferedReader br = new BufferedReader(new FileReader("resources/files/FileReaderTest.java"))) {
            String txt;
            int noOfCommentLines = 0, noOfLines = 0;

            while ((txt = br.readLine()) != null) {
                noOfLines++;
                if (txt.contains("//"))
                    noOfCommentLines++;
            }
            System.out.println("No of lines: " + noOfLines);
            System.out.println("No of comment lines: " + noOfCommentLines);
            System.out.println("Comment lines are " + (noOfCommentLines * 100 / noOfLines) + "% of total lines!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void exercise_10_4() {
        String userName = "";
        int maxSum = Integer.MIN_VALUE, sum = 0;

        try (Scanner sc = new Scanner(new File("resources/files/UseOfComputers.txt"))) {
            while (sc.hasNext()) {
                String name = sc.next();
                sum = 0;
                while (sc.hasNextInt())
                    sum += sc.nextInt();
                if (sum > maxSum) {
                    userName = name;
                    maxSum = sum;
                }
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("User " + userName + " has used computer the most: " + maxSum + " minutes!");

    }
}
