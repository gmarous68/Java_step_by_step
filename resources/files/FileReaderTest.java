import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class FileReaderTest {
    public static void main(String args[]) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("resources/files/namelist.txt"));
            // initialize row number to 0
            int rowNo = 0;
            // declare variable for read lines of file
            String row;

            // while loop over all lines in file
            while((row = br.readLine()) != null) {
                rowNo++;
                System.out.println(rowNo + ": " + row);
            }
            // catch in case of IO errors
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}