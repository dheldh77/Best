package Search;

import Employee.Employee;
import Option.InputOption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameSearchTest {

    Employee employee = new Employee("20027866","min yujin","CL2","010-4567-2345","19920922","PRO");
    Employee employee2 = new Employee("19273944","park seojoon","CL3","010-4567-2345","18201120","PRO");
    InputOption inputOption = InputOption.getInstance();
    @Test
    @DisplayName("FullNameSearch test")
    public void fullNameSearchTest(){

        String[]  cmd = {"SCH","","","","name","min yujin"};
        inputOption.setOptions(cmd);

        NameSearch nameSearch = new NameSearch();
        assertTrue(nameSearch.search(employee, "min yujin"));
        assertFalse(nameSearch.search(employee2, "min yujin"));

    }

    @Test
    @DisplayName("FirstNameSearch test")
    public void firstNameSearchTest(){

        String[]  cmd = {"SCH","","-f","","name","min"};
        inputOption.setOptions(cmd);

        NameSearch nameSearch = new NameSearch();
        assertTrue(nameSearch.search(employee, "min"));
        assertFalse(nameSearch.search(employee2, "min"));

    }

    @Test
    @DisplayName("SecondNameSearch test")
    public void secondNameSearchTest(){

        String[]  cmd = {"SCH","","-l","","name","yujin"};
        inputOption.setOptions(cmd);

        NameSearch nameSearch = new NameSearch();
        assertTrue(nameSearch.search(employee, "yujin"));
        assertFalse(nameSearch.search(employee2, "yujin"));

    }
}