import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;


public class Dice {
    public static void createFile() {
        Random ran = new Random();
        StringBuilder sb = new StringBuilder();

        try (PrintWriter outStream = new PrintWriter(new BufferedWriter(new FileWriter("intNum.txt")))) {
            for (int i = 1; i <= 1000; i++) {
                sb.append(ran.nextInt(1, 7));

                if (i % 50 != 0) sb.append(" ");
                else sb.append("\n");
            }
            outStream.println(sb);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int[] createArray() {
        int[] intArr = new int[1000];
        int counter = 0;

        try (Scanner inStream = new Scanner(new File("intNum.txt"))) {
            for (int i = 0; i < intArr.length; i++) {
                if(inStream.hasNextLine()) {
                    while (inStream.hasNextInt()) {
                        intArr[counter++] = inStream.nextInt();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return intArr;
    }

    public static int[] analyseArray(int[] intArrA) {
        int[] intArrB = new int[6];

        for(int num : intArrA)
            intArrB[num-1] += 1;

        return intArrB;
    }
}
