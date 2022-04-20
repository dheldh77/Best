package Option;

public class SecondModeOption extends ModeOption {
    private static final ModeOption INSTANCE = new SecondModeOption();

    public static ModeOption getInstance() {
        return INSTANCE;
    }

    @Override
    protected void setOption(String[] cmd) {
        super.setOption(cmd);
        setActivatedOption(cmd[4] + " " + cmd[2]);
    }

    @Override
    protected void setUpEnableOptionList() {
        putEnableOption("name -f", Option.FIRST_NAME);
        putEnableOption("name -l", Option.LAST_NAME);
        putEnableOption("phoneNum -m", Option.MIDDLE_PHONENUMBER);
        putEnableOption("phoneNum -l", Option.LAST_PHONENUMBER);
        putEnableOption("birthday -y", Option.BIRTHDAY_YEAR);
        putEnableOption("birthday -m", Option.BIRTHDAY_MONTH);
        putEnableOption("birthday -d", Option.BIRTHDAY_DAY);
    }

    private SecondModeOption() {
        clearOption();
        setUpEnableOptionList();
    }
}
