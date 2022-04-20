package Option;


import java.util.HashMap;

public abstract class ModeOption {
    private String opeartionMode;
    private Option activatedOption;
    private HashMap<String, Option> enableOptionList = new HashMap<>();

    public Option getActivatedOption() {
        return this.activatedOption;
    }

    public String getOpeartionMode() {
        return this.opeartionMode;
    }

    protected void putEnableOption(String input, Option opt) {
        enableOptionList.put(input, opt);
    }

    protected void setOption(String[] cmd) {
        clearOption();
        setOperationMode(cmd[0]);
    }

    protected void clearOption() {
        this.opeartionMode = "";
        this.activatedOption = Option.NONE;

    }

    protected void setActivatedOption(String opt) {
        if (enableOptionList.containsKey(opt)) {
            activatedOption = enableOptionList.get(opt);
            return;
        }
        activatedOption = Option.NONE;
    }

    protected abstract void setUpEnableOptionList();

    private void setOperationMode(String operationMode) {
        this.opeartionMode = operationMode;
    }
}
