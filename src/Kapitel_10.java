import javax.swing.JFileChooser;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Kapitel_10 {
    public static void app() {
//        exercise_10_2_1();
//        exercise_10_2_2();
//        exercise_10_3();
//        exercise_10_4();
//        exercise_10_5();
//        exercise_10_6();
//        exercise_10_7();
//        programmeringuppgift_10_1();
//        programmeringuppgift_10_2();
//        programmeringuppgift_10_3();
//        programmeringuppgift_10_4();
//        programmeringuppgift_10_5();
//        programmeringuppgift_10_6();
//        programmeringuppgift_10_7();
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
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("User " + userName + " has used computer the most: " + maxSum + " minutes!");
    }

    private static void exercise_10_5() {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Name of the file: ");
            String fileName1 = "resources/files/" + input.readLine();
            BufferedReader inStream = new BufferedReader(new FileReader(fileName1));

            System.out.println("Name of the new file: ");
            String fileName2 = "resources/files/" + input.readLine();
            PrintWriter outStream = new PrintWriter(new BufferedWriter(new FileWriter(fileName2)));

            String name = "";
            int points = 0;

            while ((name = inStream.readLine()) != null) {
                points = Integer.parseInt(inStream.readLine());
                if (points >= 50)
                    outStream.format("Approved: %22s: \tScore: %3d\n", name, points);
            }
            outStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void exercise_10_6() {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Name of the new file: ");
            String fileName = "resources/files/" + input.readLine();
            PrintWriter outStream = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));

            while (true) {
                System.out.println("Type in name?");
                String name = input.readLine();
                outStream.println(name);
                System.out.println("Again? Press enter -> otherwise exit with ctrl+d");
                if (input.readLine() == null)
                    break;
            }
            outStream.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void exercise_10_7() {
        try {
            String currDir = System.getProperty("user.dir");
            JFileChooser fc = new JFileChooser(currDir);
            if (fc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
                System.out.println("No file selected!");
                System.exit(0);
            }
            BufferedReader br = new BufferedReader(new FileReader(fc.getSelectedFile().getAbsolutePath()));

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

    private static void programmeringuppgift_10_1() {
        String currDir = System.getProperty("user.dir");
        JFileChooser fc = new JFileChooser(currDir);
        if (fc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
            System.out.println("No file selected!");
            System.exit(0);
        }

        double maxTemp = Integer.MIN_VALUE, totTemp = 0;
        int totDays = 0;
        String dayMax = "";

        try (Scanner sc = new Scanner(new File(fc.getSelectedFile().getAbsolutePath()))) {
            while (sc.hasNextLine()) {
                String dayNo = sc.next();
                totDays++;
                while (sc.hasNextDouble()) {
                    double temp = sc.nextDouble();
                    totTemp += temp;
                    if (temp > maxTemp) {
                        dayMax = dayNo;
                        maxTemp = temp;
                    }
                }
            }
            System.out.println("Max temp " + maxTemp + " C gr on day " + dayMax);
            System.out.println("Average temp in month: " + String.format("%.2f", (totTemp / totDays)) + " C gr");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void programmeringuppgift_10_2() {
        String currDir = System.getProperty("user.dir");
        JFileChooser fc = new JFileChooser(currDir);

        if (fc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
            System.out.println("No file selected!");
            System.exit(0);
        }

        try (Scanner sc = new Scanner(new File(fc.getSelectedFile().getAbsolutePath()))) {
            while (sc.hasNextLine()) {
                String txtLine = sc.nextLine().toLowerCase();
                txtLine = txtLine.replace("ae", "ä");
                txtLine = txtLine.replace("aa", "å");
                txtLine = txtLine.replace("oe", "ö");
                System.out.println(txtLine);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void programmeringuppgift_10_3() {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Name of the file: ");
            String fileName1 = "resources/files/" + input.readLine();
            Scanner inStream = new Scanner(new File(fileName1));

            System.out.println("Name of the new file: ");
            String fileName2 = "resources/files/" + input.readLine();
            PrintWriter outStream = new PrintWriter(new BufferedWriter(new FileWriter(fileName2)));

            while(inStream.hasNextLine()) {
                String nameAndAddress = inStream.nextLine();
                String personData = inStream.nextLine();
                Scanner pData = new Scanner(personData);
                while(pData.hasNextInt()) {
                    int year = pData.nextInt();
                    double height = pData.nextDouble() / 100;
                    int weight = pData.nextInt();
                    if(weight / Math.pow(height, 2) > 30) {
                        outStream.println(nameAndAddress);
                        outStream.println(personData);
                        outStream.println("BMI: " + String.format("%.2f", weight / Math.pow(height, 2)));
                    }
                }
                pData.close();
            }
            inStream.close();
            outStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void programmeringuppgift_10_4() {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Name of the file: ");
            String fileName1 = "resources/files/" + input.readLine();
            Scanner inStream = new Scanner(new File(fileName1));

            System.out.println("Name of the new file: ");
            String fileName2 = "resources/files/" + input.readLine();
            PrintWriter outStream = new PrintWriter(new BufferedWriter(new FileWriter(fileName2)));

            while(inStream.hasNextLine()) {
                String text = inStream.nextLine();
                if(text.contains("Google"))
                    outStream.println(text);
            }
            inStream.close();
            outStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void programmeringuppgift_10_5() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Name of the file: ");
            String fileName = "resources/files/" + sc.nextLine();
            BufferedReader inStream = new BufferedReader(new FileReader(fileName));

            int totNames = 0;

            while(true) {
                String name = inStream.readLine();
                if (name == null)
                    break;
                totNames++;
            }
            inStream.close();

            inStream = new BufferedReader(new FileReader(fileName));
            String name = "";
            int pos = (int) ((Math.random() * totNames) + 1);
            for (int i = 1; i <= pos; i++) {
                name = inStream.readLine();
            }
            System.out.println(name);
            inStream.close();

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void programmeringuppgift_10_6() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Type in a string: ");
            String txt = sc.nextLine();
            String resultStr = "";

            for (int i = 0; i < txt.length(); i++) {
                boolean consonant = switch (txt.charAt(i)) {
                    case 'a', 'e', 'i', 'o', 'u', 'y', 'å', 'ä', 'ö', ' ' -> false;
                    default -> true;
                };
                if(consonant)
                    resultStr += txt.charAt(i) + "o";
                resultStr += txt.charAt(i);
            }

            String fileName = "resources/files/translated1.txt";
            PrintWriter outStream = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            outStream.println(resultStr);
            outStream.close();

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void programmeringuppgift_10_7() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Type in a string: ");
            String txt = sc.nextLine();
            String resultStr = "";
            int i = 0;

            while(i < txt.length()) {
                boolean consonant = switch (txt.charAt(i)) {
                    case 'a', 'e', 'i', 'o', 'u', 'y', 'å', 'ä', 'ö', ' ' -> false;
                    default -> true;
                };
                if(consonant)
                    i += 2;
                resultStr += txt.charAt(i);
                i++;
            }

            String fileName = "resources/files/translated2.txt";
            PrintWriter outStream = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            outStream.println(resultStr);
            outStream.close();

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
