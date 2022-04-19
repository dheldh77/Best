package Commander;

import Employee.Employee;
import Option.InputOption;

import java.util.ArrayList;

public class Executor {
    private EmployeeService emplServ;
    private InputOption inputOption;

    public Executor(EmployeeService emplServ) {
        this.emplServ = emplServ;
        this.inputOption = InputOption.getInstance();
    }

    // EmployeeService를 위임하여 add/del/mod/search 수행
    public void add(ArrayList<String> cmd) {
        emplServ.add(cmd.get(4), cmd.get(5), cmd.get(6), cmd.get(7), cmd.get(8), cmd.get(9));
    }

    public ArrayList<Employee> delete(ArrayList<String> cmd) {
        inputOption.setOptions(cmd.toArray(new String[0]));
        return emplServ.delete(cmd.get(4), cmd.get(5));

    }

    public ArrayList<Employee> modify(ArrayList<String> cmd) {
        inputOption.setOptions(cmd.toArray(new String[0]));
        return emplServ.modify(cmd.get(4), cmd.get(5),cmd.get(6), cmd.get(7));
    }

    public ArrayList<Employee> search(ArrayList<String> cmd) {
        inputOption.setOptions(cmd.toArray(new String[0]));
        return emplServ.search(cmd.get(4), cmd.get(5));
    }

}
