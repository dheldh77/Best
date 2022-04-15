import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestInputOption {
    InputOption inputOption = InputOption.getInstance();

    @Test
    public void Test_isSingleTonInstance() {
        InputOption inputOption1 = InputOption.getInstance();
        InputOption inputOption2 = InputOption.getInstance();

        assertTrue(inputOption1 == inputOption2);
    }

    @Test
    public void Test_isActivatedOption(){
        assertFalse(inputOption.isActivatedOption(Option.DAY));
    }

    @Test
    public void Test_setOptions(){
        String[] options = {"-p", "-f", ""};
        inputOption.setOptions(options);
        assertAll(() -> assertTrue(inputOption.isActivatedOption(Option.PRINT)),
                () -> assertTrue(inputOption.isActivatedOption(Option.FIRST)),
                () -> assertFalse(inputOption.isActivatedOption(Option.DAY)));
    }

    @Test
    public void Test_repitition(){
        String[] previousOptions = {"-p", "-f", ""};
        String[] nextOptions = {"", "-m", ""};

        inputOption.setOptions(previousOptions);
        inputOption.setOptions(nextOptions);

        assertAll(() -> assertFalse(inputOption.isActivatedOption(Option.PRINT)),
                () -> assertTrue(inputOption.isActivatedOption(Option.MIDDLE_OR_MONTH)));
    }

    @Test
    public void Test_isInvalidOption() {
        String[] options = {"-p", "-f", "-l"};
        inputOption.setOptions(options);
        assertFalse(inputOption.isActivatedOption(Option.FIRST));
    }
}

