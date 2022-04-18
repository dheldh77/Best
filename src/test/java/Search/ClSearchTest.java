package Search;

import Employee.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//예외값 들어오면 어떻게 처리할지 협의
import static org.junit.jupiter.api.Assertions.*;

class ClSearchTest {

    Employee employee = new Employee("min yujin","20027866","010-4567-2345","19920922","CL2","PRO");
    Employee employee2 = new Employee("min yujin","20027866","010-4567-2345","18201120","CL3","PRO");

    @Test
    @DisplayName("CL test")
    public void clTest(){
        ClSearch clSearch = new ClSearch();
        assertTrue(clSearch.search(employee, "CL2"));
        assertFalse(clSearch.search(employee2, "CL2"));

    }
}