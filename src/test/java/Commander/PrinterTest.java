package Commander;

import Employee.Employee;
import Option.Option;
import Option.InputOption;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
    void printNoneTest() throws IOException {
        ArrayList<Employee> employees = new ArrayList<>();

        InputOption inputOption = InputOption.getInstance();

        String[] cmd = {"MOD", " ", " ", " ", "birthday", "04"};

        inputOption.setOptions(cmd);

        Printer printer = new Printer("Selection", "src\\test\\resources\\output_20_20.txt");
        printer.print(employees);
        assertEquals("MOD,NONE", outContent.toString().replace("\n", "").replace("\r", ""));

    }

    @Test
    void printRecordCntTest() throws IOException {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV"));
        employees.add(new Employee("17112609", "FB NTAWR", "CL4", "010-5645-6122", "19861203", "PRO"));
        employees.add(new Employee("18115040", "TTETHU HBO", "CL3", "010-4581-2050", "20080718", "ADV"));
        employees.add(new Employee("88114052", "NQ LVARW", "CL4", "010-4528-3059", "19911021", "PRO"));
        employees.add(new Employee("19129568", "SRERLALH HMEF", "CL2", "010-3091-9521", "19640910", "PRO"));
        employees.add(new Employee("17111236", "VSID TVO", "CL1", "010-3669-1077", "20120718", "PRO"));
        employees.add(new Employee("18117906", "TWU QSOLT", "CL4", "010-6672-7186", "20030413", "PRO"));
        employees.add(new Employee("08123556", "WN XV", "CL1", "010-7986-5047", "20100614", "PRO"));
        employees.add(new Employee("02117175", "SBILHUT LDEXRI", "CL4", "010-2814-1699", "19950704", "ADV"));

        InputOption inputOption = InputOption.getInstance();
        String[] cmd = {"MOD", " ", " ", " ", "birthday", "04"};

        inputOption.setOptions(cmd);

        assertNotSame(inputOption.getActivatedOption(inputOption.OPTION1), Option.PRINT);

        Printer printer = new Printer("Selection", "src\\test\\resources\\output_20_20.txt");
        printer.print(employees);

        assertEquals("MOD,9", outContent.toString().replace("\n", "").replace("\r", ""));
    }

    @Test
    void printRecordTest() throws IOException {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV"));
        employees.add(new Employee("17112609", "FB NTAWR", "CL4", "010-5645-6122", "19861203", "PRO"));
        employees.add(new Employee("18115040", "TTETHU HBO", "CL3", "010-4581-2050", "20080718", "ADV"));
        employees.add(new Employee("88114052", "NQ LVARW", "CL4", "010-4528-3059", "19911021", "PRO"));
        employees.add(new Employee("19129568", "SRERLALH HMEF", "CL2", "010-3091-9521", "19640910", "PRO"));
        employees.add(new Employee("17111236", "VSID TVO", "CL1", "010-3669-1077", "20120718", "PRO"));
        employees.add(new Employee("18117906", "TWU QSOLT", "CL4", "010-6672-7186", "20030413", "PRO"));
        employees.add(new Employee("08123556", "WN XV", "CL1", "010-7986-5047", "20100614", "PRO"));
        employees.add(new Employee("02117175", "SBILHUT LDEXRI", "CL4", "010-2814-1699", "19950704", "ADV"));


        InputOption inputOption = InputOption.getInstance();
        String[] cmd = {"MOD", "-p", "-d", " ", "birthday", "04"};

        inputOption.setOptions(cmd);

        assertSame(inputOption.getActivatedOption(inputOption.OPTION1), Option.PRINT);

        Printer printer = new Printer("Selection", "src\\test\\resources\\output_20_20.txt");
        printer.print(employees);

        String result = "MOD,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO\r\n" +
                "MOD,02117175,SBILHUT LDEXRI,CL4,010-2814-1699,19950704,ADV\r\n" +
                "MOD,08123556,WN XV,CL1,010-7986-5047,20100614,PRO\r\n" +
                "MOD,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV\r\n" +
                "MOD,17111236,VSID TVO,CL1,010-3669-1077,20120718,PRO\r\n";

        assertEquals(result, outContent.toString());

    }

    @Test
    void printRecordSecondNumOrderTest() throws IOException {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV"));
        employees.add(new Employee("17112609", "FB NTAWR", "CL4", "010-5645-6122", "19861203", "PRO"));
        employees.add(new Employee("18115040", "TTETHU HBO", "CL3", "010-4581-2050", "20080718", "ADV"));
        employees.add(new Employee("19129568", "SRERLALH HMEF", "CL2", "010-3091-9521", "19640910", "PRO"));
        employees.add(new Employee("17111236", "VSID TVO", "CL1", "010-3669-1077", "20120718", "PRO"));
        employees.add(new Employee("18117906", "TWU QSOLT", "CL4", "010-6672-7186", "20030413", "PRO"));

        InputOption inputOption = InputOption.getInstance();
        String[] cmd = {"MOD", "-p", "-d", " ", "birthday", "04"};

        inputOption.setOptions(cmd);

        assertSame(inputOption.getActivatedOption(inputOption.OPTION1), Option.PRINT);

        Printer printer = new Printer("Inner", "src\\test\\resources\\output_20_20.txt");
        printer.print(employees);

        String result = "MOD,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV\r\n" +
                "MOD,17111236,VSID TVO,CL1,010-3669-1077,20120718,PRO\r\n" +
                "MOD,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO\r\n" +
                "MOD,18115040,TTETHU HBO,CL3,010-4581-2050,20080718,ADV\r\n" +
                "MOD,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO\r\n";

        assertEquals(result, outContent.toString());

    }
}
