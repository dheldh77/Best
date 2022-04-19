import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ReaderTest {
    @Test
    void readTest(){
        Reader reader = new Reader();
        ArrayList<ArrayList<String>> lines = reader.read("src\\test\\resources\\input_20_20.txt");

        assertEquals(lines.size(), 40);

        for(ArrayList<String> line : lines){
            System.out.println(line);
        }
    }
}
