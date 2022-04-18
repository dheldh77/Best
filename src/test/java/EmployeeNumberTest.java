import Employee.EmployeeNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeNumberTest {
    EmployeeNumber employeeNumber = new EmployeeNumber("18050301");

    @Test
    void getEmployeeNumber(){
        assertEquals(employeeNumber.getEmployeeNumber(), "18050301");
    }

    @Test
    void getYear(){
        assertEquals(employeeNumber.getYear(), 2018);
    }

    @Test
    void getSecondNum(){
        assertEquals(employeeNumber.getSecondNum(), 50301);
    }

    @Test
    void setEmployeeNumber(){
        employeeNumber.setEmployeeNumber("79243512");
        assertEquals(employeeNumber.getEmployeeNumber(), "79243512");
        assertEquals(employeeNumber.getYear(), 1979);
        assertEquals(employeeNumber.getSecondNum(), 243512);
    }
}