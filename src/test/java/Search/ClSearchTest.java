package Search;

import Employee.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//예외값 들어오면 어떻게 처리할지 협의
import static org.junit.jupiter.api.Assertions.*;

class ClSearchTest {

    Employee employee = new Employee("20027866","min yujin","CL2","010-4567-2345","19920922","PRO");
    Employee employee2 = new Employee("20027366","min yujin","CL3","010-4567-2345","18201120","PRO");

    @Test
    @DisplayName("CL test")
    public void clTest(){
        ClSearch clSearch = new ClSearch();
        assertTrue(clSearch.search(employee, "CL2"));
        assertFalse(clSearch.search(employee2, "CL2"));

    }
}