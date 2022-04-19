import Commander.EmployeeService;
import Employee.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class EmployeeServiceTest {
    EmployeeService empServ = new EmployeeService();

    @Test
    public void addTest(){
        EmployeeService empServMock = mock(EmployeeService.class);
        empServMock.add("15123099","VXIHXOTH JHOP",
                "CL3","010-3112-2609","19771211","ADV");
        verify(empServMock).add("15123099","VXIHXOTH JHOP",
                "CL3","010-3112-2609","19771211","ADV");
    }

    @Test
    public void deleteTest(){
        empServ.add("15123099","VXIHXOTH JHOP",
                "CL3","010-3112-2609","19771211","ADV");
        ArrayList<Employee> employees = empServ.delete("name", "VXIHXOTH JHOP");
        assertEquals(0, empServ.getEmployees().size());
        assertEquals("VXIHXOTH JHOP", employees.get(0).getName());

    }

    @Test
    public void modifyTest(){
        empServ.add("15123099","VXIHXOTH JHOP",
                "CL3","010-3112-2609","19771211","ADV");
        ArrayList<Employee> employees = empServ.modify("name", "VXIHXOTH JHOP", "cl", "CL4");
        assertEquals(1, empServ.getEmployees().size());
        assertEquals("CL3", employees.get(0).getCareer());
    }

    @Test
    public void searchTest(){
        empServ.add("15123099","VXIHXOTH JHOP",
                "CL3","010-3112-2609","19771211","ADV");
        ArrayList<Employee> employees = empServ.search("name", "VXIHXOTH JHOP");
        assertEquals("VXIHXOTH JHOP", employees.get(0).getName());
    }
}
