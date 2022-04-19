package Search;

import Employee.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CertiSearchTest {

    Employee employee = new Employee("20027866","min yujin","CL2","010-4567-2345","19920922","PRO");
    Employee employee2 = new Employee("20027366","min yujin","CL2","010-4567-2345","18201120","PRO");
    @Test
    @DisplayName("CERTI test")
    public void certiTest(){
        CertiSearch certiSearch = new CertiSearch();
        assertTrue(certiSearch.search(employee,"PRO"));
        assertFalse(certiSearch.search(employee2,"EX"));
    }
}