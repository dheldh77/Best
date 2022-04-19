package Search;

import Employee.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeNumberSearchTest {

    Employee employee = new Employee("20027866","min yujin","CL2","010-4567-2345","19920922","PRO");
    Employee employee2 = new Employee("20027366","min yujin","CL2","010-4567-2345","18201120","PRO");

    @Test
    @DisplayName("employeeNum test")
    public void employeeNumTest(){
        EmployeeNumberSearch employeeNumberSearch = new EmployeeNumberSearch();
        assertTrue(employeeNumberSearch.search(employee, "20027866"));
        assertFalse(employeeNumberSearch.search(employee2, "20023534"));
    }
}