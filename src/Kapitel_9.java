import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Kapitel_9 {
    public static void app() {
//        Locale.setDefault(Locale.US);
//        Locale.setDefault(new Locale("sv", "SE"));
//        exercise_9_1();
//        exercise_9_2();
//        exercise_9_5();
//        programmeringUppgifter_9_1();
//        programmeringUppgifter_9_2();
//        programmeringUppgifter_9_4();
//        programmeringUppgifter_9_5();
//        programmeringUppgifter_9_6();
        programmeringUppgifter_9_7();
    }

    private static void exercise_9_1() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Type in a decimal number: ");
        while (!sc.hasNextDouble()) {
            if (!sc.hasNext())
                System.exit(0);
            sc.nextLine();
            System.out.println("Felaktig decimal tal");
        }
        sc.close();
    }

    private static void exercise_9_2() {
        String s = JOptionPane.showInputDialog("Type in a number of int's - separated with blank");
        Scanner sc = new Scanner(s);
        int sum = 0;

        while (sc.hasNextInt())
            sum += sc.nextInt();

        JOptionPane.showMessageDialog(null, "Sum is: " + sum);
        sc.close();
    }

    private static void exercise_9_5() {
        for (int i = 1; i <= 30; i++) {
            System.out.format("%02d -> 2 in power of " + i + " = %15.2f\n", i, Math.pow(2, i));
        }
    }

    private static void programmeringUppgifter_9_1() {
        try {
            int antMilNow = Integer.parseInt(JOptionPane.showInputDialog("Dagens mäterställning i mil?"));
            int antMilLastYear = Integer.parseInt(JOptionPane.showInputDialog("Mäterställning för ett år sedan?"));
            int noOfLitersUsed = Integer.parseInt(JOptionPane.showInputDialog("Antal liter förbrukat bensin?"));

            int diffMil = antMilNow - antMilLastYear;
            double gasUsedPerMil = noOfLitersUsed / (double) diffMil;

            String output = "Dagens mäterställning: %14d\nMäterställning ett år sedan: %8d\n"
                    + "Antal ltr bensin förbrukat: %7d\nAntal körde mil: %20d\nFörbruk per mil: %20.2f\n";
            System.out.format(output, antMilNow, antMilLastYear, noOfLitersUsed, diffMil, gasUsedPerMil);
        } catch (NumberFormatException e) {
            System.out.println("Wrong format!");
        }
    }

    private static void programmeringUppgifter_9_2() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Skriv in pris på varan: ");
            int price = Integer.parseInt(br.readLine());
            System.out.println("Betala med vilken sedel: ");
            int billSize = Integer.parseInt(br.readLine());

            int remain = billSize - price;
            int bill100 = remain / 100;
            remain = remain % 100;
            int bill50 = remain / 50;
            remain = remain % 50;
            int bill20 = remain / 20;
            remain = remain % 20;
            int coin10 = remain / 10;
            remain = remain - 10;

            StringBuilder sb = new StringBuilder("Du får tillbaka:\n");
            if (bill100 > 0)
                sb.append(bill100).append("x 100 kr sedlar\n");
            if (bill50 > 0)
                sb.append(bill50).append("x 50 kr sedlar\n");
            if (bill20 > 0)
                sb.append(bill20).append("x 20 kr sedlar\n");
            if (coin10 > 0)
                sb.append(coin10).append("x 10 kr myntar\n");
            if (remain > 0)
                sb.append(remain).append("x 1 kr myntar\n");
            System.out.println(sb);

        } catch (NumberFormatException e) {
            System.out.println("Wrong format!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void programmeringUppgifter_9_4() {
        String[][] tips = new String[13][3];
        Random ran = new Random();
        String top_bottom = "-----------";

        for (int i = 0; i < tips.length; i++) {
            int num = ran.nextInt(1, 4);
            switch (num) {
                case 1 -> {
                    tips[i][0] = " 1 ";
                    tips[i][1] = "   ";
                    tips[i][2] = "   ";
                }
                case 2 -> {
                    tips[i][0] = "   ";
                    tips[i][1] = " X ";
                    tips[i][2] = "   ";
                }
                case 3 -> {
                    tips[i][0] = "   ";
                    tips[i][1] = "   ";
                    tips[i][2] = " 2 ";
                }
            }
        }

        System.out.println(top_bottom);
        for (int i = 0; i < tips.length; i++) {
            System.out.print("|");
            for (int j = 0; j < tips[i].length; j++)
                System.out.print(tips[i][j]);
            System.out.println("|");
        }
        System.out.println(top_bottom);
    }

    private static void programmeringUppgifter_9_5() {
        String s = JOptionPane.showInputDialog("Type in a number of words - separated with blank");
        Scanner sc = new Scanner(s);
        int noOfLines = 0, noOfWords = 0, noOfCharacters = 0;

        while (sc.hasNext()) {
            noOfWords++;
            noOfLines++;
            noOfCharacters += sc.next().length();
        }

        String output = "No of Words: " + noOfWords + "\nNo of lines: "
                + noOfLines + "\nNo of characters: " + noOfCharacters;
        JOptionPane.showMessageDialog(null, output);

        sc.close();
    }

    private static void programmeringUppgifter_9_6() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Skriv in en text: ");
            String txt = br.readLine();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            for (int i = 0; i < txt.length(); i++) {
                sb1.append(txt.charAt(i));
                switch (txt.charAt(i)) {
                    case 'a', 'e', 'i', 'o', 'u', 'y', 'å', 'ä', 'ö' -> {
                        sb1.append("pa");
                    }
                }
            }
            System.out.println(sb1);
            System.out.println("*********************************");

            int i = 0;
            while (i < txt.length()) {
                sb2.append(txt.charAt(i));
                switch (txt.charAt(i)) {
                    case 'a', 'e', 'i', 'o', 'u', 'y', 'å', 'ä', 'ö' -> i += 2;
                }
                i++;
            }
            System.out.println(sb2);
            System.out.println("*********************************");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void programmeringUppgifter_9_7() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Skriv in tid 1 med formen tt:mm: ");
            String t1 = br.readLine();
            System.out.println("Skriv in tid 2 med formen tt:mm: ");
            String t2 = br.readLine();

            int antMin1 = Integer.parseInt(t1.substring(0, 2)) * 60;
            antMin1 += Integer.parseInt(t1.substring(3));
            int antMin2 = Integer.parseInt(t2.substring(0, 2)) * 60;
            antMin2 += Integer.parseInt(t2.substring(3));

            if (antMin2 < antMin1) {
                int plus1Day = antMin2 + 1440;
                antMin2 = antMin1 - antMin2;
                System.out.println("Det är 1 dag & " + antMin2 + " minuter i mellan - (" + plus1Day + " minuter totalt)!");
            } else if (antMin1 < antMin2)
                System.out.println("Det är " + (antMin2 - antMin1) + " minuter i mellan!");
            else
                System.out.println("0 minuter - samma tid på dagen!");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Wrong format! - missing 0 in front when hour is only 1 digit");
        }
    }
}
