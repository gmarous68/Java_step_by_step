import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileAnalyser {
    public static void calculateCharacters() {
        try (PrintWriter outStream = new PrintWriter(new BufferedWriter(new FileWriter("intNumTotal.txt")))) {

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
