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

    private ArrayList<ArrayList<String>> Read(){
        return null;
    }

    private void Execute(){

    }

    private void Print(){

    }

    public void run() {
        ArrayList<ArrayList<String>> cmd = Read();
        Execute();
        Print();
    }
}
