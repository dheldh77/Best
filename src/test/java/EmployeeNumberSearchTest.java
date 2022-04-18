import Employee.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeNumberSearchTest {

    Employee employee = new Employee("min yujin","20027866","010-4567-2345","19920922","CL2","PRO");
    Employee employee2 = new Employee("min yujin","19273944","010-4567-2345","18201120","CL3","PRO");

    @Test
    @DisplayName("employeeNum test")
    public void employeeNumTest(){
        EmployeeNumberSearch employeeNumberSearch = new EmployeeNumberSearch();
        assertTrue(employeeNumberSearch.search(employee, "20027866"));
        assertFalse(employeeNumberSearch.search(employee2, "2002354"));
    }
}