package Search;

import Employee.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CertiSearchTest {

    Employee employee = new Employee("min yujin","20027866","010-4567-2345","19920922","CL2","PRO");
    Employee employee2 = new Employee("min yujin","20027866","010-4567-2345","18201120","CL2","PRO");
    @Test
    @DisplayName("CERTI test")
    public void certiTest(){
        CertiSearch certiSearch = new CertiSearch();
        assertTrue(certiSearch.search(employee,"PRO"));
        assertFalse(certiSearch.search(employee2,"EX"));
    }
}