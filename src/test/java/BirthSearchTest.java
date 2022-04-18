
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BirthSearchTest {

    Employee employee = new Employee("min yujin","20027866","010-4567-2345","19920922","CL2","PRO");
    Employee employee2 = new Employee("min yujin","20027866","010-4567-2345","18201120","CL2","PRO");
    @Test
    @DisplayName("YEAR test")
    public void birthTestYear() {
        BirthSearch birthSearch = new BirthSearch();
        String[] options = {"", "-y", ""};
        InputOption inputOption = InputOption.getInstance();

        inputOption.setOptions(options);

        assertTrue(birthSearch.search(employee,"1992"));
        assertFalse(birthSearch.search(employee2,"1992"));

    }
    @Test
    @DisplayName("MONTH test")
    public void birthTestMonth() {
        BirthSearch birthSearch = new BirthSearch();
        String[] options = {"", "-m", ""};
        InputOption inputOption = InputOption.getInstance();

        inputOption.setOptions(options);

        assertTrue(birthSearch.search(employee,"09"));
        assertFalse(birthSearch.search(employee2,"09"));

    }

    @Test
    @DisplayName("DAY test")
    public void birthTestDay() {
        BirthSearch birthSearch = new BirthSearch();
        String[] options = {"", "-d", ""};
        InputOption inputOption = InputOption.getInstance();

        inputOption.setOptions(options);

        assertTrue(birthSearch.search(employee,"22"));
        assertFalse(birthSearch.search(employee2,"22"));
    }

    @Test
    @DisplayName("DATE test")
    public void birthTestDate() {
        BirthSearch birthSearch = new BirthSearch();
        String[] options = {"", "", ""};
        InputOption inputOption = InputOption.getInstance();

        inputOption.setOptions(options);

        assertTrue(birthSearch.search(employee,"19920922"));
        assertFalse(birthSearch.search(employee2,"19920922"));
    }

}