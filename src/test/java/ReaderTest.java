import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ReaderTest {
    @Test
    void readTest(){
        Reader reader = new Reader();
        List<String > lines = reader.read("C:\\Users\\DHDoh\\Downloads\\input_20_20.txt");
        assertEquals(lines.size(), 40);

        for(String line : lines){
            System.out.println(line);
        }
    }
}
