package Search;

import Employee.Employee;

public class ClSearch implements SearchPolicy {

    @Override
    public boolean search(Employee emp, String source) {
        return source.equals(emp.getCareer());
    }
}
