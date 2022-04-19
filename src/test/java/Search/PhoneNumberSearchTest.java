package Search;

import Employee.Employee;
import Option.InputOption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberSearchTest {

    Employee employee = new Employee("20027866","min yujin","CL2","010-4567-2345","19920922","PRO");
    Employee employee2 = new Employee("19273944","park seojoon","CL3","010-4527-2344","18201120","PRO");
    InputOption inputOption = InputOption.getInstance();
    PhoneNumberSearch phoneNumberSearch = new PhoneNumberSearch();

    @Test
    @DisplayName("FullNumberSearch test")
    public void fullNumberSearchTest(){

        String[]  cmd = {"SCH","","","","phoneNum","010-4567-2345"};
        inputOption.setOptions(cmd);

        assertTrue(phoneNumberSearch.search(employee, "010-4567-2345"));
        assertFalse(phoneNumberSearch.search(employee2, "010-4567-2345"));

    }

    @Test
    @DisplayName("MiddleNumberSearch test")
    public void middleNumberSearchTest(){

        String[]  cmd = {"SCH","","-m","","phoneNum","4567"};
        inputOption.setOptions(cmd);

        assertTrue(phoneNumberSearch.search(employee, "4567"));
        assertFalse(phoneNumberSearch.search(employee2, "4567"));

    }

    @Test
    @DisplayName("SecondNameSearch test")
    public void secondNameSearchTest(){

        String[]  cmd = {"SCH","","-l","","phoneNum","2345"};
        inputOption.setOptions(cmd);

        assertTrue(phoneNumberSearch.search(employee, "2345"));
        assertFalse(phoneNumberSearch.search(employee2, "2345"));

    }
}