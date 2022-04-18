//import org.junit.After;
//import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CommanderTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

//    @Before
//    void setUp() {
//        System.setOut(new PrintStream(outputStreamCaptor));
//    }
//
//    @Test
//    void runTest() {
//        Commander commander = new Commander();
//        assertEquals("SCH,02117175,SBILHUT LDEXRI,CL4,010-2814-1699,19950704,ADV\n" +
//                "MOD,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO\n" +
//                "SCH,NONE\n" +
//                "DEL,1\n" +
//                "DEL,08117441,BMU MPOSXU,CL3,010-2703-3153,20010215,ADV\n" +
//                "SCH,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO\n" +
//                "SCH,01122329,DN WD,CL4,010-7174-5680,20071117,PRO\n" +
//                "SCH,03113260,HH LTUPF,CL2,010-5798-5383,19791018,PRO\n" +
//                "SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO\n" +
//                "SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO\n" +
//                "SCH,6\n" +
//                "SCH,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO\n" +
//                "SCH,01122329,DN WD,CL4,010-7174-5680,20071117,PRO\n" +
//                "SCH,02117175,SBILHUT LDEXRI,CL4,010-2814-1699,19950704,ADV\n" +
//                "SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO\n" +
//                "SCH,08108827,RTAH VNUP,CL4,010-9031-2726,19780417,ADV\n" +
//                "SCH,1\n" +
//                "MOD,17112609,FB NTAWR,CL4,010-5645-6122,20050520,PRO\n" +
//                "MOD,08123556,WN XV,CL1,010-7986-5047,20100614,PRO\n" +
//                "SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO\n" +
//                "SCH,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO\n" +
//                "SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO\n" +
//                "SCH,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV\n" +
//                "SCH,NONE\n" +
//                "SCH,10127115,KBU MHU,CL3,010-3284-4054,19660814,ADV\n" +
//                "MOD,85125741,FBAH RTIJ,CL1,010-8900-1478,19780228,ADV\n" +
//                "SCH,NONE\n" +
//                "MOD,1\n" +
//                "SCH,1\n", outputStreamCaptor.toString().trim());
//    }
//
//    @After
//    void tearDown() {
//        System.setOut(standardOut);
//    }



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
        Commander commander = new Commander();
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
