
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BirthdaySearchTest {

    Employee employee = new Employee("min yujin","20027866","010-4567-2345","19920922","CL2","PRO");
    Employee employee2 = new Employee("min yujin","20027866","010-4567-2345","18201120","CL2","PRO");
    BirthdaySearch birthdaySearch = new BirthdaySearch();

    @Test
    @DisplayName("YEAR test")
    public void birthTestYear() {
        String[] options = {"", "-y", ""};
        InputOption inputOption = InputOption.getInstance();

        inputOption.setOptions(options);

        assertTrue(birthdaySearch.search(employee,"1992"));
        assertFalse(birthdaySearch.search(employee2,"1992"));

    }
    @Test
    @DisplayName("MONTH test")
    public void birthTestMonth() {
        String[] options = {"", "-m", ""};
        InputOption inputOption = InputOption.getInstance();

        inputOption.setOptions(options);

        assertTrue(birthdaySearch.search(employee,"09"));
        assertFalse(birthdaySearch.search(employee2,"09"));

    }

    @Test
    @DisplayName("DAY test")
    public void birthTestDay() {
        String[] options = {"", "-d", ""};
        InputOption inputOption = InputOption.getInstance();

        inputOption.setOptions(options);

        assertTrue(birthdaySearch.search(employee,"22"));
        assertFalse(birthdaySearch.search(employee2,"22"));
    }

    @Test
    @DisplayName("DATE test")
    public void birthTestDate() {
        String[] options = {"", "", ""};
        InputOption inputOption = InputOption.getInstance();

        inputOption.setOptions(options);

        assertTrue(birthdaySearch.search(employee,"19920922"));
        assertFalse(birthdaySearch.search(employee2,"19920922"));
    }

}