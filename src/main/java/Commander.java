import java.util.ArrayList;
import java.util.Iterator;

public class Commander {
    EmployeeService empServ;
    Executor executor;
    Printer printer;


    public void init() {
        empServ = new EmployeeService();
//        executor = new Executor(empServ);
        printer = new Printer("Selection");
    }

    private ArrayList<ArrayList<String>> Read(String fileName){
        return new Reader().read(fileName);
    }

    private ArrayList<Employee> Execute(ArrayList<String> cmd){
        switch(cmd.get(0)){
            case "ADD" :
//                return executor.add(cmd);
                break;
            case "MOD" :
//                return executor.modify(cmd);
                break;
            case "DEL" :
//                return executor.delete(cmd);
                break;
            case "SCH" :
//                return executor.search(cmd);
                break;
            default :
//                return null;
        }
        return null;
    }

    private void Print(String cmd, ArrayList<Employee> employees){
        printer.print(cmd, employees);
    }

    public void run() {
        ArrayList<ArrayList<String>> cmds = Read("src\\test\\resources\\input_20_20.txt");
        for (Iterator<ArrayList<String>> iter = cmds.stream().iterator(); iter.hasNext(); ) {
            ArrayList<String> cmd = iter.next();
            ArrayList<Employee> employees = Execute(cmd);
            Print(cmd.get(0), employees);
        }
    }
}
