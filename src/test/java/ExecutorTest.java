import static org.junit.jupiter.api.Assertions.*;
import Employee.Employee;
import Option.Option;
import Option.InputOption;
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

        // 삭제된 Record 반환
        ArrayList<Employee> result = executor.delete(cmd1);

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

        // 변경 전 Record 반환
        ArrayList<Employee> result = executor.modify(cmd1);

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

        // 찾은 Record 반환
        ArrayList<Employee> result = executor.search(cmd1);

        assertEquals(1, result.size());
        assertEquals("88114052", result.get(0).getEmpNum());
        assertEquals("NQ LVARW", result.get(0).getName());
        assertEquals("CL4", result.get(0).getCareer());
        assertEquals("010-4528-3059", result.get(0).getPhoneNum());
        assertEquals("19911021", result.get(0).getBirthDate());
        assertEquals("PRO", result.get(0).getCerti());
    }
}
