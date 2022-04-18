import Employee.Employee;
import java.util.ArrayList;

public class Commander {
    Executor executor;
    Printer printer;
    EmployeeService empServ;

    public void init() {
//        executor = new Executor(empServ);
        printer = new Printer("Inner");
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

    private void Print(ArrayList<Employee> employees){
        printer.print(employees);
    }

    public void run() {
        for (ArrayList<String> cmd : Read("src\\test\\resources\\input_20_20.txt")) {
            ArrayList<Employee> employees = Execute(cmd);
            Print(employees);
        }
    }
}
