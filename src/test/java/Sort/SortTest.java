package Sort;

import Employee.Employee;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class SortTest {
    private ArrayList<Employee> orderedEmployees;
    private ArrayList<Employee> employees;

    @BeforeEach
    void setExpectedEmployees() {
        orderedEmployees = new ArrayList<>();

        orderedEmployees.add(new Employee("88114052", "NQ LVARW", "CL4", "010-4528-3059", "19911021", "PRO"));
        orderedEmployees.add(new Employee("02117175", "SBILHUT LDEXRI", "CL4", "010-2814-1699", "19950704", "ADV"));
        orderedEmployees.add(new Employee("08123556", "WN XV", "CL1", "010-7986-5047", "20100614", "PRO"));
        orderedEmployees.add(new Employee("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV"));
        orderedEmployees.add(new Employee("17111236", "VSID TVO", "CL1", "010-3669-1077", "20120718", "PRO"));
        orderedEmployees.add(new Employee("17112609", "FB NTAWR", "CL4", "010-5645-6122", "19861203", "PRO"));
        orderedEmployees.add(new Employee("18115040", "TTETHU HBO", "CL3", "010-4581-2050", "20080718", "ADV"));
        orderedEmployees.add(new Employee("18117906", "TWU QSOLT", "CL4", "010-6672-7186", "20030413", "PRO"));
        orderedEmployees.add(new Employee("19129568", "SRERLALH HMEF", "CL2", "010-3091-9521", "19640910", "PRO"));
    }

    @Test
    void selectionSortTest() {
        addEmployees();

        SortAlgorithm sortAlgo = new SelectionSort();
        sortAlgo.executeSort(employees);

        for (int i = 0; i < employees.size(); i++) {
            assertEquals(orderedEmployees.get(i).getName(), employees.get(i).getName());
            assertEquals(orderedEmployees.get(i).getEmpNum(), employees.get(i).getEmpNum());
            assertEquals(orderedEmployees.get(i).getPhoneNum(), employees.get(i).getPhoneNum());
            assertEquals(orderedEmployees.get(i).getBirthDate(), employees.get(i).getBirthDate());
            assertEquals(orderedEmployees.get(i).getCareer(), employees.get(i).getCareer());
            assertEquals(orderedEmployees.get(i).getCerti(), employees.get(i).getCerti());
        }
    }

    @Test
    void InnerSortTest() {
        addEmployees();

        for (Employee employee: employees){
            System.out.println(employee.toString());
        }

        SortAlgorithm sortAlgo = new SelectionSort();
        sortAlgo.executeSort(employees);

        System.out.println("------------ After Sort ------------");
        for (Employee employee: employees){
            System.out.println(employee.toString());
        }

        for (int i = 0; i < employees.size(); i++) {
            assertEquals(orderedEmployees.get(i).getName(), employees.get(i).getName());
            assertEquals(orderedEmployees.get(i).getEmpNum(), employees.get(i).getEmpNum());
            assertEquals(orderedEmployees.get(i).getPhoneNum(), employees.get(i).getPhoneNum());
            assertEquals(orderedEmployees.get(i).getBirthDate(), employees.get(i).getBirthDate());
            assertEquals(orderedEmployees.get(i).getCareer(), employees.get(i).getCareer());
            assertEquals(orderedEmployees.get(i).getCerti(), employees.get(i).getCerti());
        }
    }

    private void addEmployees() {
        employees = new ArrayList<>();

        employees.add(new Employee("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV"));
        employees.add(new Employee("17112609", "FB NTAWR", "CL4", "010-5645-6122", "19861203", "PRO"));
        employees.add(new Employee("18115040", "TTETHU HBO", "CL3", "010-4581-2050", "20080718", "ADV"));
        employees.add(new Employee("88114052", "NQ LVARW", "CL4", "010-4528-3059", "19911021", "PRO"));
        employees.add(new Employee("19129568", "SRERLALH HMEF", "CL2", "010-3091-9521", "19640910", "PRO"));
        employees.add(new Employee("17111236", "VSID TVO", "CL1", "010-3669-1077", "20120718", "PRO"));
        employees.add(new Employee("18117906", "TWU QSOLT", "CL4", "010-6672-7186", "20030413", "PRO"));
        employees.add(new Employee("08123556", "WN XV", "CL1", "010-7986-5047", "20100614", "PRO"));
        employees.add(new Employee("02117175", "SBILHUT LDEXRI", "CL4", "010-2814-1699", "19950704", "ADV"));
    }
}
