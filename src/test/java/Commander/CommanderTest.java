package Commander;

import Commander.Commander;
import Commander.EmployeeService;
import Employee.Employee;
import Option.InputOption;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CommanderTest {

    @Test
    void initTest(){
        Commander commander = mock(Commander.class);
        commander.init();
        verify(commander).init();
    }
    @Test
    void readTest() throws Exception {
        Commander commander = new Commander("src\\test\\resources\\input_20_20.txt", "output");
        Method method = commander.getClass().getDeclaredMethod("Read");
        method.setAccessible(true);
        ArrayList<ArrayList<String>> result = (ArrayList<ArrayList<String>>) method.invoke(commander);
        assertEquals(40, result.size());
    }
    @Test
    void executeTest() throws Exception {
        Commander commander = new Commander("src\\test\\resources\\input_20_20.txt", "output");

        EmployeeService empServ = new EmployeeService();
        ArrayList<String> cmd = new ArrayList<String>();
        cmd.add("ADD");
        cmd.add("15123099");
        cmd.add("VXIHXOTH JHOP");
        cmd.add("CL3");
        cmd.add("010-3112-2609");
        cmd.add("19771211");
        cmd.add("ADV");
        commander.init();
        Method method = commander.getClass().getDeclaredMethod("Execute", ArrayList.class);
        method.setAccessible(true);
        ArrayList<Employee> result = (ArrayList<Employee>) method.invoke(commander, cmd);
        assertNull(result);
    }

    @Test
    void printTest() throws Exception{
        Commander commander = new Commander("src\\test\\resources\\input_20_20.txt", "output");

        EmployeeService empServ = new EmployeeService();
        ArrayList<String> cmd = new ArrayList<String>();
        cmd.add("ADD");
        cmd.add("15123099");
        cmd.add("VXIHXOTH JHOP");
        cmd.add("CL3");
        cmd.add("010-3112-2609");
        cmd.add("19771211");
        cmd.add("ADV");
        commander.init();
        Method method = commander.getClass().getDeclaredMethod("Print", InputOption.class, ArrayList.class);
        method.setAccessible(true);
        assertDoesNotThrow(() -> method.invoke(commander, InputOption.getInstance(), cmd));
    }

}
