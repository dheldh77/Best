package Option;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InputOptionTest {
    InputOption inputOption = InputOption.getInstance();

    @Test
    public void Test_isSingleTonInstance() {
        InputOption inputOption1 = InputOption.getInstance();
        InputOption inputOption2 = InputOption.getInstance();

        ModeOption FirstModeOption1 = FirstModeOption.getInstance();
        ModeOption FirstModeOption2 = FirstModeOption.getInstance();

        ModeOption SecondModeOption1 = SecondModeOption.getInstance();
        ModeOption SecondModeOption2 = SecondModeOption.getInstance();

        assertAll(() -> assertTrue(inputOption1 == inputOption2),
                () -> assertTrue(FirstModeOption1 == FirstModeOption2),
                () -> assertTrue(SecondModeOption1 == SecondModeOption2));
    }

    @Test
    public void Test_Correct_ModeOption1() {
        String[] cmd = {"MOD","-p","","","name","FB NTAWR","birthday","20050520"};
        inputOption.setOptions(cmd);
        assertTrue(inputOption.getActivatedOption(inputOption.OPTION1) == Option.PRINT);
    }

    @Test
    public void Test_Correct_ModeOption2() {
        String[] cmd = {"MOD","","-f","","name","FB NTAWR","birthday","20050520"};
        inputOption.setOptions(cmd);
        assertTrue(inputOption.getActivatedOption(inputOption.OPTION2) == Option.FIRST_NAME);
    }

    @Test
    public void Test_Correct_getOperationMode() {
        String[] cmd = {"MOD","","-f","","name","FB NTAWR","birthday","20050520"};
        inputOption.setOptions(cmd);
        System.out.println(inputOption.getOperationMode(inputOption.OPTION1));
        assertTrue("MOD".equals(inputOption.getOperationMode(inputOption.OPTION1)));
    }

    @Test
    public void Test_incorrect_setModeOption2() {
        String[] cmd = {"MOD","","-l","","name","FB NTAWR","birthday","20050520"};
        inputOption.setOptions(cmd);
        assertTrue(inputOption.getActivatedOption(inputOption.OPTION2) == Option.LAST_NAME);
    }

    @Test
    public void Test_Correct_setModeOption1_Repitition() {
        String[] previousCmd = {"MOD","-p","","","name","FB NTAWR","birthday","20050520"};
        String[] nextCmd = {"MOD","","","","name","FB NTAWR","birthday","20050520"};
        inputOption.setOptions(previousCmd);
        inputOption.setOptions(nextCmd);
        assertTrue(inputOption.getActivatedOption(inputOption.OPTION1) == Option.NONE);
    }

    @Test
    public void Test_Correct_setModeOption2_Repitition() {
        String[] previousCmd = {"MOD","-p","-f","","name","FB NTAWR","birthday","20050520"};
        String[] nextCmd = {"MOD","","-l","","name","FB NTAWR","birthday","20050520"};
        inputOption.setOptions(previousCmd);
        inputOption.setOptions(nextCmd);
        assertTrue(inputOption.getActivatedOption(inputOption.OPTION2) == Option.LAST_NAME);
    }

}

