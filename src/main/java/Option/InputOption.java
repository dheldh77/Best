package Option;

import java.util.ArrayList;

public class InputOption {
    public final int OPTION1 = 0;
    public final int OPTION2 = 1;
    private static final InputOption INSTANCE = new InputOption();
    private ArrayList<ModeOption> options = new ArrayList<>();

    public static InputOption getInstance() {
        return INSTANCE;
    }

    public void setOptions(String[] cmd) {
        for (ModeOption mode : options) {
            mode.setOption(cmd);
        }
    }

    public  Option getActivatedOption(int optionNum) {
        return options.get(optionNum).getActivatedOption();
    }

    public String getOperationMode(int optionNum) {
        return options.get(optionNum).getOpeartionMode();
    }

    private InputOption() {
        options.add(FirstModeOption.getInstance());
        options.add(SecondModeOption.getInstance());
    }
}
