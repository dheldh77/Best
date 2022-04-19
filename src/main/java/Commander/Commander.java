package Commander;

import Employee.Employee;
import java.util.ArrayList;

public class Commander {
    EmployeeService empServ;
    Executor executor;
    Printer printer;
    String inputTxt;
    String outputTxt;

    public Commander(String inputTxt, String outputTxt){
        this.inputTxt = inputTxt;
        this.outputTxt = outputTxt;
    }

    public void init() {
        empServ = new EmployeeService();
        executor = new Executor(empServ);
        printer = new Printer("Inner");
    }

    private ArrayList<ArrayList<String>> Read(String fileName){
        return new Reader().read(fileName);
    }

    private ArrayList<Employee> Execute(ArrayList<String> cmd){
        switch(cmd.get(0)){
            case "ADD" :
                executor.add(cmd);
                break;
            case "MOD" :
                return executor.modify(cmd);
            case "DEL" :
                return executor.delete(cmd);
            case "SCH" :
                return executor.search(cmd);
        }
        return null;
    }

    private void Print(ArrayList<Employee> employees){
        printer.print(employees);
    }

    public void run() {
        ArrayList<ArrayList<String>> cmds = Read(inputTxt);
        for (ArrayList<String> cmd : cmds) {
            ArrayList<Employee> employees = Execute(cmd);
            if (employees == null) continue;
            Print(employees);
        }
    }
}
