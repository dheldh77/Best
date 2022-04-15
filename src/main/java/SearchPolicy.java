import java.util.ArrayList;

public interface SearchPolicy {
    //type이랑 value넘겨줌
    boolean search(String source);
    default ArrayList<Employee> search(String type, String source) {
        ArrayList<Employee> employees = null;  //main에 있는 employees배열??
        ArrayList<Employee> pickedEmployees = new ArrayList<>();

        for(Employee emp : employees) {
            if(search(source))
                pickedEmployees.add(emp);
        }

        return pickedEmployees;
    }

}
