import Option.Option;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void printNoneTest() {
        ArrayList<Employee> employees = new ArrayList<>();

        InputOption inputOption = InputOption.getInstance();
        String[] cmd = {"MOD"," "," "," ","birthday","04"};
        inputOption.setOptions(cmd);

        Printer printer = new Printer("Selection");
        printer.print(employees);
        assertEquals("MOD,NONE", outContent.toString().replace("\n", "").replace("\r", ""));

    }

    @Test
    void printRecordCntTest() {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("VXIHXOTH JHOP", "15123099",
                "010-3112-2609", "19771211", "CL3", "ADV"));
        employees.add(new Employee("FB NTAWR", "17112609", "010-5645-6122", "19861203", "CL4", "PRO"));
        employees.add(new Employee("TTETHU HBO", "18115040", "010-4581-2050", "20080718", "CL3", "ADV"));
        employees.add(new Employee("NQ LVARW", "88114052", "010-4528-3059", "19911021", "CL4", "PRO"));
        employees.add(new Employee("SRERLALH HMEF", "19129568", "010-3091-9521", "19640910", "CL2", "PRO"));
        employees.add(new Employee("VSID TVO", "17111236", "010-3669-1077", "20120718", "CL1", "PRO"));
        employees.add(new Employee("TWU QSOLT", "18117906", "010-6672-7186", "20030413", "CL4", "PRO"));
        employees.add(new Employee("WN XV", "08123556", "010-7986-5047", "20100614", "CL1", "PRO"));
        employees.add(new Employee("SBILHUT LDEXRI", "02117175", "010-2814-1699", "19950704", "CL4", "ADV"));

        InputOption inputOption = InputOption.getInstance();
        String[] cmd = {"MOD"," "," "," ","birthday","04"};
        inputOption.setOptions(cmd);

        assertNotSame(inputOption.getActivatedOption(inputOption.OPTION1), Option.PRINT);

        Printer printer = new Printer("Selection");
        printer.print(employees);

        assertEquals("MOD,9", outContent.toString().replace("\n", "").replace("\r", ""));
    }

    @Test
    void printRecordTest() {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("VXIHXOTH JHOP", "15123099",
                "010-3112-2609", "19771211", "CL3", "ADV"));
        employees.add(new Employee("FB NTAWR", "17112609", "010-5645-6122", "19861203", "CL4", "PRO"));
        employees.add(new Employee("TTETHU HBO", "18115040", "010-4581-2050", "20080718", "CL3", "ADV"));
        employees.add(new Employee("NQ LVARW", "88114052", "010-4528-3059", "19911021", "CL4", "PRO"));
        employees.add(new Employee("SRERLALH HMEF", "19129568", "010-3091-9521", "19640910", "CL2", "PRO"));
        employees.add(new Employee("VSID TVO", "17111236", "010-3669-1077", "20120718", "CL1", "PRO"));
        employees.add(new Employee("TWU QSOLT", "18117906", "010-6672-7186", "20030413", "CL4", "PRO"));
        employees.add(new Employee("WN XV", "08123556", "010-7986-5047", "20100614", "CL1", "PRO"));
        employees.add(new Employee("SBILHUT LDEXRI", "02117175", "010-2814-1699", "19950704", "CL4", "ADV"));


        InputOption inputOption = InputOption.getInstance();
        String[] cmd = {"MOD","-p","-d"," ","birthday","04"};
        inputOption.setOptions(cmd);

        assertSame(inputOption.getActivatedOption(inputOption.OPTION1), Option.PRINT);

        Printer printer = new Printer("Selection");
        printer.print(employees);

        String result = "MOD,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO\r\n" +
                "MOD,02117175,SBILHUT LDEXRI,CL4,010-2814-1699,19950704,ADV\r\n" +
                "MOD,08123556,WN XV,CL1,010-7986-5047,20100614,PRO\r\n" +
                "MOD,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV\r\n" +
                "MOD,17111236,VSID TVO,CL1,010-3669-1077,20120718,PRO\r\n";

        assertEquals(result, outContent.toString());

    }

    @Test
    void printRecordSecondNumOrderTest() {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("VXIHXOTH JHOP", "15123099","010-3112-2609", "19771211", "CL3", "ADV"));
        employees.add(new Employee("FB NTAWR", "17112609", "010-5645-6122", "19861203", "CL4", "PRO"));
        employees.add(new Employee("TTETHU HBO", "18115040", "010-4581-2050", "20080718", "CL3", "ADV"));
        employees.add(new Employee("SRERLALH HMEF", "19129568", "010-3091-9521", "19640910", "CL2", "PRO"));
        employees.add(new Employee("VSID TVO", "17111236", "010-3669-1077", "20120718", "CL1", "PRO"));
        employees.add(new Employee("TWU QSOLT", "18117906", "010-6672-7186", "20030413", "CL4", "PRO"));


        InputOption inputOption = InputOption.getInstance();
        String[] cmd = {"MOD","-p","-d"," ","birthday","04"};
        inputOption.setOptions(cmd);

        assertSame(inputOption.getActivatedOption(inputOption.OPTION1), Option.PRINT);

        Printer printer = new Printer("Inner");
        printer.print(employees);

        String result = "MOD,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV\r\n" +
                "MOD,17111236,VSID TVO,CL1,010-3669-1077,20120718,PRO\r\n" +
                "MOD,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO\r\n" +
                "MOD,18115040,TTETHU HBO,CL3,010-4581-2050,20080718,ADV\r\n" +
                "MOD,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO\r\n";

        assertEquals(result, outContent.toString());

    }
}
