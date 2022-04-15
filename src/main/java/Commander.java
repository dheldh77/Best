import java.util.ArrayList;

public class Commander {
    Reader reader;
    Executor executor;
    Printer printer;
    EmployeeService empService;

    public void init() {
        reader = new Reader();
        executor = new Executor();
        printer = new Printer();
        empService = new EmployeeService();
    }

    private ArrayList<ArrayList<String>> Read(String fileName){
        return reader.read(fileName);
    }

    private void Execute(){

    }

    private void Print(){

    }

    public void run() {
        ArrayList<ArrayList<String>> cmd = Read("src\\test\\resources\\input_20_20.txt");
        Execute();
        Print();
    }
}
