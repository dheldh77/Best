package Search;

import Employee.Employee;
import Option.InputOption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchPolicyTest {
//all로 검색하는 부분 추가
    ArrayList<Employee>  employees;
    InputOption inputOption = InputOption.getInstance();

    @Test
    @DisplayName("SearchPolicyTestByEmployeeNum")
    public void searchPolicyTestByEmployeeNum(){
        putEmployees();
        EmployeeNumberSearch employeeNumberSearch = new EmployeeNumberSearch();

        assertEquals(1,employeeNumberSearch.search(employees,"20027866").size());
        assertEquals(0,employeeNumberSearch.search(employees,"20207866").size());

    }


    @Test
    @DisplayName("SearchPolicyTestByName")
    public void searchPolicyTestByName(){
        putEmployees();
        NameSearch nameSearch = new NameSearch();

        String[]  cmd = {"SCH","","","","name","min"};
        inputOption.setOptions(cmd);

        assertEquals(1,nameSearch.search(employees,"park minyoung").size());

        String[]  cmd1 = {"SCH","","-f","","name","min"};
        inputOption.setOptions(cmd1);

        assertEquals(2,nameSearch.search(employees,"min").size());

        String[]  cmd2 = {"SCH","","-l","","name","sooyoung"};
        inputOption.setOptions(cmd2);

        assertEquals(0,nameSearch.search(employees,"sooyoung").size());

    }

    @Test
    @DisplayName("SearchPolicyTestByCL")
    public void searchPolicyTestByCL(){
        putEmployees();
        ClSearch clSearch = new ClSearch();

        assertEquals(1,clSearch.search(employees,"CL2").size());
        assertEquals(2,clSearch.search(employees,"CL3").size());

    }


    @Test
    @DisplayName("SearchPolicyTestByPhone")
    public void searchPolicyTestByPhone(){
        putEmployees();
        PhoneNumberSearch phoneNumberSearch = new PhoneNumberSearch();

        String[]  cmd = {"SCH","","","","phoneNum","4567"};
        inputOption.setOptions(cmd);

        assertEquals(1, phoneNumberSearch.search(employees,"010-4394-2355").size());

        String[]  cmd1 = {"SCH","","-m","","phoneNum","4567"};
        inputOption.setOptions(cmd1);

        assertEquals(1, phoneNumberSearch.search(employees,"4567").size());

        String[]  cmd2 = {"SCH","","-l","","phoneNum","2355"};
        inputOption.setOptions(cmd2);

        assertEquals(1, phoneNumberSearch.search(employees,"2355").size());

    }


    @Test
    @DisplayName("SearchPolicyTestByBirth")
    public void searchPolicyTestByBirth(){
        putEmployees();
        BirthdaySearch birthSearch = new BirthdaySearch();

        assertEquals(1,birthSearch.search(employees,"19920922").size());


        String[]  cmd = {"SCH","","-d","","birthday","20"};
        inputOption.setOptions(cmd);

        assertEquals(2,birthSearch.search(employees,"20").size());

        String[]  cmd1 = {"SCH","","-m","","birthday","11"};
        inputOption.setOptions(cmd1);

        assertEquals(3,birthSearch.search(employees,"11").size());

        String[]  cmd2 = {"SCH","","-y","","birthday","1992"};
        inputOption.setOptions(cmd2);

        assertEquals(1,birthSearch.search(employees,"1992").size());

    }

    @Test
    @DisplayName("SearchPolicyTestByCerti")
    public void searchPolicyTestByCerti(){
        putEmployees();
        CertiSearch certiSearch = new CertiSearch();

        assertEquals(2,certiSearch.search(employees,"PRO").size());
        assertEquals(1,certiSearch.search(employees,"EX").size());

    }

    private void putEmployees() {
        employees=new ArrayList<>();
        employees.add(new Employee("20027866", "min yujin", "CL2","010-4567-2345", "19920922",  "PRO"));
        employees.add(new Employee("19973944","park seojoon",  "CL3","010-4394-2355", "18201120",  "PRO"));
        employees.add(new Employee("19223944","park minyoung",  "CL4","010-4394-9375", "18201120",  "EX"));
        employees.add(new Employee("20223944","min seojoon",  "CL3","010-4456-2323", "18211123",  "ADV"));

    }


}