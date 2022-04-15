import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Reader {
    //private Option option;
    public List<String> read(String filename) {
        try {
            return Files.readAllLines(Paths.get(filename));
        } catch (IOException e1) {
            e1.printStackTrace();
            return null;
        }
        // option.setReadOption(...);
    }
}
