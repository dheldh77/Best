package Search;

import Employee.Employee;
import java.util.ArrayList;

public interface SearchPolicy {
    boolean search(Employee emp,String source);
    default ArrayList<Employee> search(ArrayList<Employee> employees,String source) {
        ArrayList<Employee> pickedEmployees = new ArrayList<>();

        for(Employee emp : employees) {
            if(search(emp,source))
                pickedEmployees.add(emp);
        }
        return pickedEmployees;
    }

}
