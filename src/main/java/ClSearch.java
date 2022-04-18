import Employee.Employee;

public class ClSearch implements SearchPolicy{

    @Override
    public boolean search(Employee emp, String source) {
        if(source.equals(emp.getCareer()))
            return true;
        return false;
    }
}
