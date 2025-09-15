import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;


public class Dice {
    private static final int TOTAL_ROLLS = 1000;
    private static final int DICE_SIDES = 6;
    private static final int LINE_BREAK = 50;
    private static final String FILE_NAME = "intNum.txt";

    public static void createFile() {
        Random ran = new Random();
        StringBuilder sb = new StringBuilder();

        try (PrintWriter outStream = new PrintWriter(new BufferedWriter(new FileWriter("intNum.txt")))) {
            for (int i = 1; i <= TOTAL_ROLLS; i++) {
                sb.append(ran.nextInt(1, 7));

                if (i % LINE_BREAK != 0) sb.append(" ");
                else sb.append("\n");
            }
            outStream.println(sb);
        } catch (IOException e) {
            System.out.println("Failed to write file: " + e.getMessage());
        }
    }

    public static int[] createArray() {
        int[] intArr = new int[TOTAL_ROLLS];
        int counter = 0;

        try (Scanner inStream = new Scanner(new File(FILE_NAME))) {
            for (int i = 0; i < intArr.length; i++) {
                if(inStream.hasNextLine())
                    while (inStream.hasNextInt())
                        intArr[counter++] = inStream.nextInt();
            }
        } catch (IOException e) {
            System.out.println("Failed to read file: " + e.getMessage());
        }
        return intArr;
    }

    public static int[] analyseArray(int[] intArrA) {
        int[] intArrB = new int[DICE_SIDES];

        for(int num : intArrA)
            intArrB[num-1] += 1;

        return intArrB;
    }
}
