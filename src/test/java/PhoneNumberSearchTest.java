import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberSearchTest {

    Employee employee = new Employee("min yujin","20027866","010-4567-2345","19920922","CL2","PRO");
    Employee employee2 = new Employee("park seojoon","19273944","010-4394-2355","18201120","CL3","PRO");
    PhoneNumberSearch phoneNumberSearch = new PhoneNumberSearch();

    @Test
    @DisplayName("FullNumberSearch test")
    public void fullNumberSearchTest(){
        assertTrue(phoneNumberSearch.search(employee, "010-4567-2345"));
        assertFalse(phoneNumberSearch.search(employee2, "010-4567-2345"));

    }

    @Test
    @DisplayName("MiddleNumberSearch test")
    public void middleNumberSearchTest(){

        String[] options = {"", "-m", ""};
        InputOption inputOption = InputOption.getInstance();
        inputOption.setOptions(options);

        assertTrue(phoneNumberSearch.search(employee, "4567"));
        assertFalse(phoneNumberSearch.search(employee2, "4567"));

    }

    @Test
    @DisplayName("SecondNameSearch test")
    public void secondNameSearchTest(){

        String[] options = {"", "-l", ""};
        InputOption inputOption = InputOption.getInstance();
        inputOption.setOptions(options);

        assertTrue(phoneNumberSearch.search(employee, "2345"));
        assertFalse(phoneNumberSearch.search(employee2, "2345"));

    }
}