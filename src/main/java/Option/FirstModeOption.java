package Option;

public class FirstModeOption extends ModeOption {
    private static final ModeOption INSTANCE = new FirstModeOption();

    public static ModeOption getInstance() {
        return INSTANCE;
    }

    @Override
    protected void setOption(String[] cmd) {
        super.setOption(cmd);
        setActivatedOption(cmd[1]);
    }

    @Override
    protected void setUpEnableOptionList() {
        putEnableOption("-p", Option.PRINT);
    }

    private FirstModeOption() {
        clearOption();
        setUpEnableOptionList();
    }
}
