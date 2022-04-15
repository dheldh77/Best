import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
        Commander commander = new Commander();
        Method method = commander.getClass().getDeclaredMethod("Read", String.class);
        method.setAccessible(true);
        ArrayList<ArrayList<String>> result = (ArrayList<ArrayList<String>>) method.invoke(commander, "src\\test\\resources\\input_20_20.txt");
        assertEquals(40, result.size());
    }
    @Test
    void executeTest() throws Exception {
        Commander commander = new Commander();
        EmployeeService empServ = new EmployeeService();
        ArrayList<String> cmd = new ArrayList<String>();
        cmd.add("ADD");
        cmd.add("ADD");
        cmd.add("ADD");
        cmd.add("ADD");
        cmd.add("ADD");
        commander.init();
        Method method = commander.getClass().getDeclaredMethod("Execute", ArrayList.class);
        method.setAccessible(true);
        ArrayList<Employee> result = (ArrayList<Employee>) method.invoke(commander, cmd);
        assertNull(result);
    }
    @Test
    void printTest() throws Exception{
        Commander commander = new Commander();
        EmployeeService empServ = new EmployeeService();
        ArrayList<String> cmd = new ArrayList<String>();
        cmd.add("ADD");
        cmd.add("ADD");
        cmd.add("ADD");
        cmd.add("ADD");
        cmd.add("ADD");
        commander.init();
        Method method = commander.getClass().getDeclaredMethod("Print", InputOption.class, ArrayList.class);
        method.setAccessible(true);
        method.invoke(commander, InputOption.getInstance(), cmd);
//        verify(commander).print();
    }
}
