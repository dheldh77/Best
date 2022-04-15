import java.util.ArrayList;

public interface SearchPolicy {
    //type이랑 value넘겨줌
    boolean search(String source);
    default ArrayList<Employee> search(String type, String source) {
        ArrayList<Employee> employees = null;  //main에 있는 employees배열??
        ArrayList<Employee> pickedEmployees = new ArrayList<>();
        
        switch (type)
        {
            case "employeeNum":
                for(Employee emp : employees) {
                    if(empNumSearch(source))
                        pickedEmployees.add(emp);
                }
                break;
            case "name":
                for(Employee emp : employees) {
                    if(new NameSearch().search(source))
                        pickedEmployees.add(emp);
                }
                break;
            case "cl":
                for(Employee emp : employees) {
                    if(clSearch(source))
                        pickedEmployees.add(emp);
                }
                break;
            case "phoneNum":
                for(Employee emp : employees) {
                    if (new PhoneSearch().search(source))
                        pickedEmployees.add(emp);
                }
                break;
            case "birthday":
                for(Employee emp : employees) {
                    if (new BirthSearch().search(source))
                        pickedEmployees.add(emp);
                }
                break;
            case "certi":
                for(Employee emp : employees) {
                    if(certiSearch(source))
                        pickedEmployees.add(emp);
                }
                break;

        }
        return pickedEmployees;
    }

    Employee emp = new Employee();
    default boolean certiSearch(String source){
        if(source.equals(emp.getCerti()))
            return true;
        return false;
    };

    default boolean clSearch(String source){
        if(source.equals(emp.getCl()))
            return true;
        return false;
    };

    default boolean empNumSearch(String source){
        if(source.equals(emp.getEmpNum()))
            return true;
        return false;
    }



}
