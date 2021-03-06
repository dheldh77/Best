package Commander;

import Employee.Employee;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CommanderTest {

    @Test
    void runTest() throws IOException {
        Commander commander = new Commander("src\\test\\resources\\input_20_20.txt", "src\\test\\resources\\output_20_20.txt");
        commander.init();
        commander.run();
    }

    @Test
    void initTest() throws IOException {
        Commander commander = mock(Commander.class);
        commander.init();
        verify(commander).init();
    }
    @Test
    void readTest() throws Exception {
        Commander commander = new Commander("src\\test\\resources\\input_20_20.txt", "src\\test\\resources\\output_20_20.txt");
        Method method = commander.getClass().getDeclaredMethod("Read", String.class);
        method.setAccessible(true);
        ArrayList<ArrayList<String>> result = (ArrayList<ArrayList<String>>) method.invoke(commander, "src\\test\\resources\\input_20_20.txt");
        assertEquals(40, result.size());
    }
    @Test
    void executeTest() throws Exception {
        Commander commander = new Commander("src\\test\\resources\\input_20_20.txt", "src\\test\\resources\\output_20_20.txt");

        EmployeeService empServ = new EmployeeService();
        ArrayList<String> cmd = new ArrayList<String>();
        cmd.add("ADD");
        cmd.add("");
        cmd.add("");
        cmd.add("");
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
        Commander commander = new Commander("src\\test\\resources\\input_20_20.txt", "src\\test\\resources\\output_20_20.txt");

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
        Method method = commander.getClass().getDeclaredMethod("Print", ArrayList.class);
        method.setAccessible(true);
        assertDoesNotThrow(() -> method.invoke(commander, cmd));
    }

}
