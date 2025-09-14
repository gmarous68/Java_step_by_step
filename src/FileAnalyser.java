import java.io.FileInputStream;
import java.io.IOException;

public class FileAnalyser {
    public static void calculateCharacters() {
        try (FileInputStream fi = new FileInputStream("intNumTotal.txt")) {

            byte[] content = fi.readAllBytes();
            System.out.println("Number of all characters (including line break, space, tab, etc.)"
                    + " in file \"intNumTotal.txt\"): " + content.length);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}