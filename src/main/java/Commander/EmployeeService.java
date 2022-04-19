package Commander;

import Employee.Employee;
import Search.*;

import java.util.ArrayList;

public class EmployeeService {
    private SearchPolicy searchPolicy;
    private ArrayList<Employee> employees;

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public EmployeeService(){
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
        ArrayList<Employee> targetEmployee = searchPolicy.search(employees, fromValue);
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

    private void choosePolicy(String type){
        switch (type)
        {
            case "employeeNum":
                searchPolicy = new EmployeeNumberSearch();
                break;
            case "name":
                searchPolicy = new NameSearch();
                break;
            case "cl":
                searchPolicy = new ClSearch();
                break;
            case "phoneNum":
                searchPolicy = new PhoneNumberSearch();
                break;
            case "birthday":
                searchPolicy = new BirthdaySearch();
                break;
            case "certi":
                searchPolicy = new CertiSearch();
                break;
        }
    }

    public ArrayList<Employee> search(String type, String value) {
        choosePolicy(type);
        ArrayList<Employee> targetEmployee = searchPolicy.search(employees, value);
        return (ArrayList<Employee>) targetEmployee.clone();
    }
}