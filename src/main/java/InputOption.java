import java.util.ArrayList;
import java.util.HashMap;

public class InputOption {
    private static final InputOption INSTANCE = new InputOption();
    private ArrayList<Boolean> options;
    private HashMap<String, Option> parameters;

    private InputOption() {
        options = new ArrayList<>();
        parameters = new HashMap<>();
        for(Option opt : Option.values())
            options.add(false);
        setParameterMap();
    }

    private void setParameterMap() {
        parameters.put("-f", Option.FIRST);
        parameters.put("-m", Option.MIDDLE_OR_MONTH);
        parameters.put("-l", Option.LAST);
        parameters.put("-y", Option.YEAR);
        parameters.put("-d", Option.DAY);
        parameters.put("-p", Option.PRINT);
    }

    public static InputOption getInstance() {
        return INSTANCE;
    }

    public boolean isValidOption(Option option) {
        return options.get(option.ordinal());
    }

    public void setOptions(String[] args){
        clearOption();
        for(String opt : args) {
            if (opt.equals("")) continue;
            setOption(opt);
        }
    }

    private void setOption(String opt){
        options.set(parameters.get(opt).ordinal(), true);
    }

    private void clearOption() {
        for(int i = 0; i < options.size(); i++)
            options.set(i, false);
    }
}
