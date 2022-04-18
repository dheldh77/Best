import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameSearchTest {

    Employee employee = new Employee("min yujin","20027866","010-4567-2345","19920922","CL2","PRO");
    Employee employee2 = new Employee("park seojoon","19273944","010-4567-2345","18201120","CL3","PRO");

    @Test
    @DisplayName("FullNameSearch test")
    public void fullNameSearchTest(){
        NameSearch nameSearch = new NameSearch();
        assertTrue(nameSearch.search(employee, "min yujin"));
        assertFalse(nameSearch.search(employee2, "min yujin"));

    }

    @Test
    @DisplayName("FirstNameSearch test")
    public void firstNameSearchTest(){

        String[] options = {"", "-f", ""};
        InputOption inputOption = InputOption.getInstance();

        inputOption.setOptions(options);

        NameSearch nameSearch = new NameSearch();
        assertTrue(nameSearch.search(employee, "min"));
        assertFalse(nameSearch.search(employee2, "min"));

    }

    @Test
    @DisplayName("SecondNameSearch test")
    public void secondNameSearchTest(){

        String[] options = {"", "-l", ""};
        InputOption inputOption = InputOption.getInstance();

        inputOption.setOptions(options);

        NameSearch nameSearch = new NameSearch();
        assertTrue(nameSearch.search(employee, "yujin"));
        assertFalse(nameSearch.search(employee2, "yujin"));

    }
}