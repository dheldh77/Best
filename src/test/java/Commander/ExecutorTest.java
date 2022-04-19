package Commander;

import static org.junit.jupiter.api.Assertions.*;

import Commander.EmployeeService;
import Employee.Employee;
import Commander.Executor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ExecutorTest {
    @Test
    void addTest() {
        EmployeeService emplServ = new EmployeeService();

        Executor executor = new Executor(emplServ);
        String inputCmd = "ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV";
        ArrayList<String> cmd = new ArrayList<>(Arrays.asList(inputCmd.split(",")));

        assertEquals(10, cmd.size());
        executor.add(cmd);
    }

    @Test
    void delTest() {
        EmployeeService emplServ = new EmployeeService();
        Executor executor = new Executor(emplServ);

        String inputCmd = "ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV";
        ArrayList<String> cmd = new ArrayList<>(Arrays.asList(inputCmd.split(",")));
        executor.add(cmd);

        String inputCmd1 = "ADD, , , ,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO";
        ArrayList<String> cmd1 = new ArrayList<>(Arrays.asList(inputCmd1.split(",")));
        executor.add(cmd1);

        String inputCmd2 = "DEL,-p,-l, ,name,LVARW";
        ArrayList<String> cmd2 = new ArrayList<>(Arrays.asList(inputCmd2.split(",")));
        // 삭제된 Record 반환
        ArrayList<Employee> result = executor.delete(cmd2);

        assertEquals(1, result.size());
        assertEquals("88114052", result.get(0).getEmpNum());
        assertEquals("NQ LVARW", result.get(0).getName());
        assertEquals("CL4", result.get(0).getCareer());
        assertEquals("010-4528-3059", result.get(0).getPhoneNum());
        assertEquals("19911021", result.get(0).getBirthDate());
        assertEquals("PRO", result.get(0).getCerti());
    }

    @Test
    void modTest() {
        EmployeeService emplServ = new EmployeeService();
        Executor executor = new Executor(emplServ);

        String inputCmd = "ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV";
        ArrayList<String> cmd = new ArrayList<>(Arrays.asList(inputCmd.split(",")));
        executor.add(cmd);

        String inputCmd1 = "ADD, , , ,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO";
        ArrayList<String> cmd1 = new ArrayList<>(Arrays.asList(inputCmd1.split(",")));
        executor.add(cmd1);

        String inputCmd2 = "MOD,-p, , ,name,NQ LVARW,birthday,20050520";
        ArrayList<String> cmd2 = new ArrayList<>(Arrays.asList(inputCmd2.split(",")));

        // 변경 전 Record 반환
        ArrayList<Employee> result = executor.modify(cmd2);

        assertEquals(1, result.size());
        assertEquals("88114052", result.get(0).getEmpNum());
        assertEquals("NQ LVARW", result.get(0).getName());
        assertEquals("CL4", result.get(0).getCareer());
        assertEquals("010-4528-3059", result.get(0).getPhoneNum());
        assertEquals("19911021", result.get(0).getBirthDate());
        assertEquals("PRO", result.get(0).getCerti());
    }

    @Test
    void searchTest() {
        EmployeeService emplServ = new EmployeeService();
        Executor executor = new Executor(emplServ);

        String inputCmd = "ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV";
        ArrayList<String> cmd = new ArrayList<>(Arrays.asList(inputCmd.split(",")));
        executor.add(cmd);

        String inputCmd1 = "ADD, , , ,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO";
        ArrayList<String> cmd1 = new ArrayList<>(Arrays.asList(inputCmd1.split(",")));
        executor.add(cmd1);

        String inputCmd2 = "SCH, , , ,employeeNum,88114052";
        ArrayList<String> cmd2 = new ArrayList<>(Arrays.asList(inputCmd2.split(",")));

        // 찾은 Record 반환
        ArrayList<Employee> result = executor.search(cmd2);

        assertEquals(1, result.size());
        assertEquals("88114052", result.get(0).getEmpNum());
        assertEquals("NQ LVARW", result.get(0).getName());
        assertEquals("CL4", result.get(0).getCareer());
        assertEquals("010-4528-3059", result.get(0).getPhoneNum());
        assertEquals("19911021", result.get(0).getBirthDate());
        assertEquals("PRO", result.get(0).getCerti());
    }
}
