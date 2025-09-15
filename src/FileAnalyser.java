import java.io.FileInputStream;
import java.io.IOException;

public class FileAnalyser {
    public static void calculateCharacters() {
        final String FILE_NAME = "intNumTotal.txt";
        try (FileInputStream fi = new FileInputStream(FILE_NAME)) {

            byte[] content = fi.readAllBytes();
            System.out.println("Number of all characters (including line break, space, tab, etc.)"
                    + " in file \"intNumTotal.txt\"): " + content.length);

        } catch (IOException e) {
            System.out.println("Error reading file \"" + FILE_NAME + "\": " + e.getMessage());
        }
    }
}