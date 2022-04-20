package Commander;

import Employee.Employee;
import Option.Option;
import Option.InputOption;

import org.junit.jupiter.api.*;

import java.io.*;
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

        String outputFileName = "src\\test\\resources\\outputTest.txt";
        Printer printer = new Printer("Inner", outputFileName);
        printer.print(employees);

        printer.EndPrint();

        String outputResult = readOutputFile(outputFileName);

        assertEquals("MOD,NONE\n", outputResult);

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

        String outputFileName = "src\\test\\resources\\outputTest.txt";
        Printer printer = new Printer("Inner", outputFileName);
        printer.print(employees);

        printer.EndPrint();

        String outputResult = readOutputFile(outputFileName);

        assertEquals("MOD,9\n", outputResult);
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

        String outputFileName = "src\\test\\resources\\outputTest.txt";
        Printer printer = new Printer("Inner", outputFileName);
        printer.print(employees);

        printer.EndPrint();

        String outputResult = readOutputFile(outputFileName);

        String result = "MOD,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO\n" +
                "MOD,02117175,SBILHUT LDEXRI,CL4,010-2814-1699,19950704,ADV\n" +
                "MOD,08123556,WN XV,CL1,010-7986-5047,20100614,PRO\n" +
                "MOD,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV\n" +
                "MOD,17111236,VSID TVO,CL1,010-3669-1077,20120718,PRO\n";

        assertEquals(result, outputResult);

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

        String outputFileName = "src\\test\\resources\\outputTest.txt";
        Printer printer = new Printer("Inner", outputFileName);
        printer.print(employees);

        printer.EndPrint();

        String outputResult = readOutputFile(outputFileName);

        String result = "MOD,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV\n" +
                "MOD,17111236,VSID TVO,CL1,010-3669-1077,20120718,PRO\n" +
                "MOD,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO\n" +
                "MOD,18115040,TTETHU HBO,CL3,010-4581-2050,20080718,ADV\n" +
                "MOD,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO\n";

        assertEquals(result, outputResult);
    }

    private String readOutputFile(String outputFileName) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();

        File file = new File(outputFileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
