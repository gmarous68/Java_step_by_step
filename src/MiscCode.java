import javax.swing.*;
import java.io.*;
import java.util.Scanner;


public class MiscCode {
    public static void app() {
//        fibonacci(5);
//        momsCompute();
//        leapYear();
//        ternaryOp();
//        newSwitch();
//        antBlank();
//        bankProgram();
//        bufferedReaderTest();
//        scannerTest1();
//        scannerTest2();
//        arrayTest();
//        readFileTest();
//        fileCopyDemo();
//        distanceDemo();
//        rectangleDemo();
    }

    private static void fibonacci(int x) {
        /* Print the Fibonacci sequence for values <= x */
        int lo = 1, hi = 1;
        System.out.print(lo + " ");

        while (hi <= x) {
            System.out.print(hi + " ");
            hi = lo + hi;
            lo = hi - lo;
        }
        System.out.println();
    }

    private static void momsCompute() {
        double itemPriceDouble = Double.parseDouble(JOptionPane.showInputDialog("Vad är varans totala pris?"));
        int taxRateDouble = Integer.parseInt(JOptionPane.showInputDialog("Vad är momsen i heltal?"));

        //double itemPriceDoubleWithoutTax = itemPriceDouble / (1 + (double)taxRateDouble / 100);
        //double momsPrice = itemPriceDouble - itemPriceDoubleWithoutTax;
        double momsPrice = itemPriceDouble / (taxRateDouble * 0.01 + 1);
        double moms = itemPriceDouble - momsPrice;


        JOptionPane.showMessageDialog(null, "Varans pris exkl. moms: " + String.format("%.2f", momsPrice) +
                "\n" + "Momspriset: " + String.format("%.2f", moms));
    }

    private static void leapYear() {
        var sc = new Scanner(System.in);
        System.out.println("Type in a year: ");
        int year = sc.nextInt();

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            System.out.println("It's a leap year!");
        else
            System.out.println("It's NOT a leap year!");
    }

    private static void ternaryOp() {
        int time = Integer.parseInt(JOptionPane.showInputDialog("Tim of day: "));

        String message = (time < 18) ? "Good day." : "Good evening.";
        System.out.println(message);
    }

    private static void newSwitch() {
        String month = JOptionPane.showInputDialog("Which month: (type 3 first letters in month)");
        int days = switch (month.toLowerCase()) {
            case "apr", "jun", "sep", "nov" -> 30;
            case "jan", "mar", "may", "jul", "aug", "oct", "dec" -> 31;
            case "feb" -> 28;
            default -> {
                System.out.println("Illegal option types in!");
                yield 0;
            }
        };
        System.out.println(month + " has " + days + " days!");
    }

    private static void antBlank() {
        int summa = 0;
        String text = JOptionPane.showInputDialog("Tasta in en sträng: ");

        for (int i = 0; i < text.length(); i++) {
            if (Character.isWhitespace(text.charAt(i)))
                summa++;
        }
        JOptionPane.showMessageDialog(null, "Antal blanka tecken: " + summa);
    }

    private static void bankProgram() {
        int procent = Integer.parseInt(JOptionPane.showInputDialog("Skriva in procent: "));
        int antYear = Integer.parseInt(JOptionPane.showInputDialog("Skriva in ant år: "));

        StringBuilder str = new StringBuilder("År    Kapital\n");
        double summa = 1000;

        for (int i = 0; i < antYear; i++) {
            summa += (summa * procent) / 100;
            str.append((i + 1)).append("     ").append(String.format("%.2f", summa)).append(" kr\n");
        }
        JOptionPane.showMessageDialog(null, str);
    }

    private static void bufferedReaderTest() {
        System.out.println("Mata in et antal heltal och tryck på Enter/Retur ");
        System.out.println("Avsluta med tom sträng & Enter ");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int maxValue = Integer.MIN_VALUE;

        while (true) {
            String txt = null;
            try {
                txt = input.readLine();
                if (txt == null || txt.isEmpty())
                    break;

                int num = Integer.parseInt(txt);
                if (num > maxValue)
                    maxValue = num;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Max value: " + maxValue);
    }

    private static void scannerTest1() {
        System.out.println("Mata in et antal heltal och tryck på Enter/Retur ");
        System.out.println("Avsluta med tom sträng & Enter ");
        Scanner scan = new Scanner(System.in);
        int maxValue = Integer.MIN_VALUE;
        int num = 0;

        while (scan.hasNextLine()) {
            String txt = scan.nextLine();

            if (txt == null || txt.isEmpty())
                break;

            try {
                num = Integer.parseInt(txt);
            } catch(NumberFormatException e) {
                System.out.println("Du måste skriva in ett heltal!");
            }
            maxValue = Math.max(num, maxValue);
        }
        System.out.println("Max value: " + maxValue);
        scan.close();
    }

    private static void scannerTest2() {
        String s = "2 6 19 -3 6";
        Scanner sc = new Scanner(s);
        int sum = 0;

        while(sc.hasNextInt()) {
            sum += sc.nextInt();
        }
        System.out.println("Summa: " + sum);
    }

    private static void arrayTest() {
        String[][] names = {
                {"Mr. ", "Mrs. ", "Ms. "},
                {"Smith", "Jones"}
        };

        for (int i = 0; i < names[0].length; i++) {
            for (int j = 0; j < names[1].length; j++) {
                System.out.println(names[0][i] + names[1][j]);
            }
        }
    }

    private static void readFileTest() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("resources/files/namelist.txt"));
            int rowNo = 0;
            String row;

            while((row = br.readLine()) != null) {
                rowNo++;
                System.out.println(rowNo + ": " + row);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void fileCopyDemo() {
        try(BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Name of the file: ");
            String fileName1 = "resources/files/" + input.readLine();
            BufferedReader inStream = new BufferedReader(new FileReader(fileName1));

            System.out.println("Name of the new file: ");
            String fileName2 = "resources/files/" + input.readLine();
            PrintWriter outStream = new PrintWriter(new BufferedWriter(new FileWriter(fileName2)));

            int rowNo = 0;
            String row;
            while((row = inStream.readLine()) != null) {
                 rowNo++;
                 outStream.println(rowNo + ": " + row);
            }
            outStream.close();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void distanceDemo() {
        Point pkt1 = new Point();
        pkt1.x = 0;
        pkt1.y = 0;

        Point pkt2 = new Point();
        pkt2.x = 3;
        pkt2.y = 4;

        System.out.print("Distance between those two points: ");
        System.out.println(Point.distance(pkt1, pkt2));
        System.out.println("*********************************");

        Point p3 = Point.midPoint(pkt1, pkt2);
        System.out.print("Middelpoint between is: ");
        System.out.println("(" + p3.x + ", " + p3.y + ")");
    }

    private static void rectangleDemo() {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();
        try {
            r1.setHeight(10);
            r1.setWidth(20);
            System.out.println(r1.perimeter());
            System.out.println(r1.area());
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Point{
    double x;
    double y;

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(
                (p1.x - p2.x) * (p1.x - p2.x) +
                        (p1.y - p2.y) * (p1.y - p2.y)
        );
    }

    public static Point midPoint(Point p1, Point p2) {
        Point p = new Point();
        p.x = (p1.x + p2.x) / 2;
        p.y = (p1.y + p2.y) / 2;
        return p;
    }
}

class Rectangle {
    private double height;
    private double width;

    public double area() {
        return height * width;
    }

    public double perimeter() {
        return height * 2 + width * 2;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height >= 0)
            this.height = height;
        else
            throw new IllegalArgumentException("Negative height");
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width >= 0)
            this.width = width;
        else
            throw new IllegalArgumentException("Negative width");
    }
}