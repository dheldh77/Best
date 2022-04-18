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
        empServMock.add("VXIHXOTH JHOP","15123099",
                "010-3112-2609","19771211","CL3","ADV");
        verify(empServMock).add("VXIHXOTH JHOP","15123099",
                "010-3112-2609","19771211","CL3","ADV");
    }

    @Test
    public void deleteTest(){
        empServ.add("VXIHXOTH JHOP","15123099",
                "010-3112-2609","19771211","CL3","ADV");
        ArrayList<Employee> employees = empServ.delete("name", "VXIHXOTH JHOP");
        assertEquals(0, empServ.getEmployees().size());
        assertEquals("VXIHXOTH JHOP", employees.get(0).getName());

    }

    @Test
    public void modifyTest(){
        empServ.add("VXIHXOTH JHOP","15123099",
                "010-3112-2609","19771211","CL3","ADV");
        ArrayList<Employee> employees = empServ.modify("name", "VXIHXOTH JHOP", "cl", "CL4");
        assertEquals(1, empServ.getEmployees().size());
        assertEquals("CL5", employees.get(0).getCareer());
    }

    @Test
    public void searchTest(){
        empServ.add("VXIHXOTH JHOP","15123099",
                "010-3112-2609","19771211","CL3","ADV");
        ArrayList<Employee> employees = empServ.search("name", "VXIHXOTH JHOP");
        assertEquals("VXIHXOTH JHOP", employees.get(0).getName());
    }
}
