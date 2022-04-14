import java.util.ArrayList;

public class InputOption {
    private static final InputOption INSTANCE = new InputOption();
    private ArrayList<Integer> selectOptions;
    private ArrayList<Integer> printOptions;

    private InputOption() {
    }

    public static InputOption getInstance() {
        return INSTANCE;
    }
}
