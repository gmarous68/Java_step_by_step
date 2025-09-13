import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Inlämningsuppgift_2 {
    public static void main(String[] args) {
        // Create file intNum.txt
        Dice.createFile();
        // Create array from file intNum.txt
        var intArr1 = Dice.createArray();
        // Count equal numbers and put in array
        var intArr2 = Dice.analyseArray(intArr1);

        // To Console
        for(int i=0; i<intArr2.length; i++)
            System.out.format("Total number of " + (i+1) + " in intNum.txt file = %4d\n", intArr2[i]);

        // To file "intNumTotal.txt"
        try {
            PrintWriter outStream = new PrintWriter(new BufferedWriter(new FileWriter("intNumTotal.txt")));

            String output = "Number of int occurrences in file intNum.txt:\n";
            output += "\t1\t\t2\t\t3\t\t4\t\t5\t\t6\n";
            output += "%5d\t%5d\t%5d\t%5d\t%5d\t%5d";
            outStream.format(output, intArr2[0], intArr2[1], intArr2[2], intArr2[3], intArr2[4], intArr2[5]);

            outStream.close();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

        // Compute number of all char in file intNumTotal.txt
        FileAnalyser.calculateCharacters();
    }
}
