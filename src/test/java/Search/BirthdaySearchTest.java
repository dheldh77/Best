package Search;

import Employee.Employee;
import Option.InputOption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BirthdaySearchTest {

    Employee employee = new Employee("20027866","min yujin","CL2","010-4567-2345","19920922","PRO");
    Employee employee2 = new Employee("20027366","min yujin","CL2","010-4567-2345","18201120","PRO");
    BirthdaySearch birthdaySearch = new BirthdaySearch();
    InputOption inputOption = InputOption.getInstance();;

    @Test
    @DisplayName("DATE test")
    public void birthTestDate() {

        String[] cmd = {"SCH","","","","birthday","19920922"};
        inputOption.setOptions(cmd);

        assertTrue(birthdaySearch.search(employee,"19920922"));
        assertFalse(birthdaySearch.search(employee2,"19920922"));
    }



    @Test
    @DisplayName("YEAR test")
    public void birthTestYear() {

        String[] cmd = {"SCH","","-y","","birthday","1992"};
        inputOption.setOptions(cmd);

        assertTrue(birthdaySearch.search(employee,"1992"));
        assertFalse(birthdaySearch.search(employee2,"1992"));

    }
    @Test
    @DisplayName("MONTH test")
    public void birthTestMonth() {
        String[]  cmd = {"SCH","","-m","","birthday","09"};
        inputOption.setOptions(cmd);

        assertTrue(birthdaySearch.search(employee,"09"));
        assertFalse(birthdaySearch.search(employee2,"09"));

    }

    @Test
    @DisplayName("DAY test")
    public void birthTestDay() {
        String[]  cmd = {"SCH","","-d","","birthday","22"};
        inputOption.setOptions(cmd);

        assertTrue(birthdaySearch.search(employee,"22"));
        assertFalse(birthdaySearch.search(employee2,"22"));
    }



}