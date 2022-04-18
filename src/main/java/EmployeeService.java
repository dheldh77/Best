import Employee.Employee;

import java.util.ArrayList;

public class EmployeeService {
    private SearchPolicy searchPolicy;

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    private ArrayList<Employee> employees;

    EmployeeService(){
        employees = new ArrayList<Employee>();
    }

    public void add(String employeeNum, String name, String careerLevel, String phoneNum, String birthday, String certi){
        employees.add(new Employee(employeeNum, name, careerLevel, phoneNum, birthday, certi));
    }

    public ArrayList<Employee> delete(String type, String value){
        ArrayList<Employee> targetEmployee = search(type, value);
        ArrayList<Employee> cloneEmployee = (ArrayList<Employee>) targetEmployee.clone();
        for(Employee emp : targetEmployee){
            employees.remove(emp);
        }
        return cloneEmployee;
    }

    public ArrayList<Employee> modify(String fromType, String fromValue, String toType, String toValue){
        ArrayList<Employee> targetEmployee = searchPolicy.search(fromType, fromValue);
        for(Employee emp : targetEmployee){
            changeEmpInfo(emp, toType, toValue);
        }
        return (ArrayList<Employee>) targetEmployee.clone();
    }

    private void changeEmpInfo(Employee emp, String toType, String toValue){
        switch (toType)
        {
            case "employeeNum":
                emp.setEmployeeNum(toValue);
                break;
            case "name":
                emp.setName(toValue);
                break;
            case "cl":
                emp.setCareer(toValue);
                break;
            case "phoneNum":
                emp.setPhoneNum(toValue);
                break;
            case "birthday":
                emp.setBirthDay(toValue);
                break;
            case "certi":
                emp.setCerti(toValue);
                break;
        }
    }

    public ArrayList<Employee> search(String type, String value) {
        ArrayList<Employee> targetEmployee = searchPolicy.search(type, value);
        return (ArrayList<Employee>) targetEmployee.clone();
    }
}