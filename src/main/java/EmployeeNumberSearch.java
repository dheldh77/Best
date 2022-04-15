public class EmployeeNumberSearch implements SearchPolicy{
    Employee emp = null;
    @Override
    public boolean search(String source) {
        if(source.equals(emp.getEmpNum()))
            return true;
        return false;
    }
}
