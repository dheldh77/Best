import Option.InputOption;

import java.util.ArrayList;
import java.util.Iterator;

public class Commander {
    Executor executor;
    Printer printer;
    EmployeeService empServ;

    public void init() {
        executor = new Executor();
        printer = new Printer();
        empServ = new EmployeeService();
    }

    private ArrayList<ArrayList<String>> Read(String fileName){
        return new Reader().read(fileName);
    }

    private ArrayList<Employee> Execute(ArrayList<String> cmd){
        switch(cmd.get(0)){
            case "ADD" :
//                return executor.add(cmd, empServ);
                break;
            case "MOD" :
//                return executor.modify(cmd, empServ);
                break;
            case "DEL" :
//                return executor.delete(cmd, empServ);
                break;
            case "SCH" :
//                return executor.search(cmd, empServ);
                break;
            default :
//                return null;
        }
        return null;
    }

    private void Print(InputOption printOption, ArrayList<Employee> employees){
//        printer.print(printOption, employees);
    }

    public void run() {
        ArrayList<ArrayList<String>> cmds = Read("src\\test\\resources\\input_20_20.txt");
        for (Iterator<ArrayList<String>> iter = cmds.stream().iterator(); iter.hasNext(); ) {
            ArrayList<String> cmd = iter.next();
            ArrayList<Employee> employees = Execute(cmd);
            Print(InputOption.getInstance(), employees);
        }
    }
}
