package Commander;

import Employee.Employee;
import Sort.SelectionSort;
import Sort.SortAlgorithm;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class SortTest {
    private ArrayList<Employee> orderedEmployees;

    @BeforeEach
    void setExpectedEmployees() {
        orderedEmployees = new ArrayList<>();

        orderedEmployees.add(new Employee("NQ LVARW", "88114052", "010-4528-3059", "19911021", "CL4", "PRO"));
        orderedEmployees.add(new Employee("SBILHUT LDEXRI", "02117175", "010-2814-1699", "19950704", "CL4", "ADV"));
        orderedEmployees.add(new Employee("WN XV", "08123556", "010-7986-5047", "20100614", "CL1", "PRO"));
        orderedEmployees.add(new Employee("VXIHXOTH JHOP", "15123099", "010-3112-2609", "19771211", "CL3", "ADV"));
        orderedEmployees.add(new Employee("VSID TVO", "17111236", "010-3669-1077", "20120718", "CL1", "PRO"));
        orderedEmployees.add(new Employee("FB NTAWR", "17112609", "010-5645-6122", "19861203", "CL4", "PRO"));
        orderedEmployees.add(new Employee("TTETHU HBO", "18115040", "010-4581-2050", "20080718", "CL3", "ADV"));
        orderedEmployees.add(new Employee("TWU QSOLT", "18117906", "010-6672-7186", "20030413", "CL4", "PRO"));
        orderedEmployees.add(new Employee("SRERLALH HMEF", "19129568", "010-3091-9521", "19640910", "CL2", "PRO"));
    }

    @Test
    void selectionSortTest() {
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
}
