public class EmployeeNumberSearch implements SearchPolicy{

    @Override
    public boolean search(Employee emp, String source) {
        if(source.equals(emp.getEmpNum()))
            return true;
        return false;
    }
}
