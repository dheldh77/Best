import Option.InputOption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SearchPolicyTest {
//all로 검색하는 부분 추가

    @Test
    @DisplayName("SearchPolicyTestByBirth")
    public void searchPolicyTestByBirth(){
        ArrayList<Employee>  employees=new ArrayList<>();
        employees.add(new Employee("min yujin", "20027866", "010-4567-2345", "19920922", "CL2", "PRO"));
        employees.add(new Employee("park seojoon", "19273944", "010-4394-2355", "18201120", "CL3", "PRO"));
        employees.add(new Employee("park minyoung", "19223944", "010-4394-9375", "18201120", "CL4", "EX"));
        employees.add(new Employee("min seojoon", "20223944", "010-44567-2323", "18211123", "CL3", "ADV"));


        BirthSearch birthSearch = new BirthSearch();

        InputOption inputOption = InputOption.getInstance();
        String[] options = {"", "-d", ""};
        inputOption.setOptions(options);

        assertEquals(2,birthSearch.search(employees,"20").size());

        String[] options2 = {"", "-m", ""};
        inputOption.setOptions(options2);

        assertEquals(3,birthSearch.search(employees,"11").size());

    }

    @Test
    @DisplayName("SearchPolicyTestByName")
    public void searchPolicyTestByName(){
        ArrayList<Employee>  employees=new ArrayList<>();
        employees.add(new Employee("min yujin", "20027866", "010-4567-2345", "19920922", "CL2", "PRO"));
        employees.add(new Employee("park seojoon", "19273944", "010-4394-2355", "18201120", "CL3", "PRO"));
        employees.add(new Employee("park minyoung", "19223944", "010-4394-9375", "18201120", "CL4", "EX"));
        employees.add(new Employee("min seojoon", "20223944", "010-44567-2323", "18211123", "CL3", "ADV"));


        NameSearch nameSearch = new NameSearch();

        InputOption inputOption = InputOption.getInstance();
        String[] options = {"", "-f", ""};
        inputOption.setOptions(options);

        assertEquals(2,nameSearch.search(employees,"min").size());

        String[] options2 = {"", "-l", ""};
        inputOption.setOptions(options2);

        assertEquals(0,nameSearch.search(employees,"sooyoung").size());

    }


    @Test
    @DisplayName("SearchPolicyTestByPhone")
    public void searchPolicyTestByPhone(){
        ArrayList<Employee>  employees=new ArrayList<>();
        employees.add(new Employee("min yujin", "20027866", "010-4567-2345", "19920922", "CL2", "PRO"));
        employees.add(new Employee("park seojoon", "19273944", "010-4394-2355", "18201120", "CL3", "PRO"));
        employees.add(new Employee("park minyoung", "19223944", "010-4394-9375", "18201120", "CL4", "EX"));
        employees.add(new Employee("min seojoon", "20223944", "010-4456-2323", "18211123", "CL3", "ADV"));


        PhoneSearch phoneSearch = new PhoneSearch();

        InputOption inputOption = InputOption.getInstance();
        String[] options = {"", "-m", ""};
        inputOption.setOptions(options);

        assertEquals(1,phoneSearch.search(employees,"4567").size());

        String[] options2 = {"", "-l", ""};
        inputOption.setOptions(options2);

        assertEquals(1,phoneSearch.search(employees,"2355").size());

    }
}