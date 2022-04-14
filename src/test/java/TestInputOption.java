import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestInputOption {
    InputOption inputOption = InputOption.getInstance();

    @Test
    public void Test_isValidOption(){
        assertFalse(inputOption.isValidOption(Option.DAY));
    }

    @Test
    public void Test_setOptions(){
        String[] opts = {"-p", "-f", };
        inputOption.setOptions(opts);
        assertTrue(inputOption.isValidOption(Option.PRINT));
        assertTrue(inputOption.isValidOption(Option.FIRST));
        assertFalse(inputOption.isValidOption(Option.DAY));
    }
}

