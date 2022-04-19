package Employee;

import Employee.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeTest {
    Employee employee = new Employee("VXIHXOTH JHOP","15123099",
                                  "010-3112-2609","19771211","CL3","ADV");

    @Test
    void getNameTest() {
        assertEquals("VXIHXOTH JHOP", employee.getName());
    }

    @Test
    void getFirstName() {
        assertEquals("VXIHXOTH", employee.getFirstName());
    }

    @Test
    void getSecondName() {
        assertEquals("JHOP", employee.getSecondName());
    }

    @Test
    void setName() {
        employee.setName("FB NTAWR");
        assertEquals("FB NTAWR", employee.getName());
    }

    @Test
    void setFirstName() {
        employee.setFirstName("FB");
        assertEquals("FB", employee.getFirstName());
        assertEquals("FB JHOP", employee.getName());
    }

    @Test
    void setSecondName() {
        employee.setSecondName("NTAWR");
        assertEquals("NTAWR", employee.getSecondName());
        assertEquals("VXIHXOTH NTAWR", employee.getName());
    }

    @Test
    void getEmpNum() {
        assertEquals("15123099", employee.getEmpNum());
    }

    @Test
    void getEmpNumYear() {
        assertEquals(2015, employee.getEmpNumYear());
    }

    @Test
    void getEmpNumSecondNum() {
        assertEquals(123099, employee.getEmpNumSecondNum());
    }

    @Test
    void setEmployeeNum() {
        employee.setEmployeeNum("95257398");
        assertEquals("95257398", employee.getEmpNum());
        assertEquals(1995, employee.getEmpNumYear());
        assertEquals(257398, employee.getEmpNumSecondNum());
    }

    @Test
    void getPhoneNum() {
        assertEquals("010-3112-2609", employee.getPhoneNum());
    }

    @Test
    void getPhoneMiddleNum() {
        assertEquals("3112", employee.getPhoneMiddleNum());
    }

    @Test
    void getPhoneEndNum() {
        assertEquals("2609", employee.getPhoneEndNum());
    }

    @Test
    void setPhoneNum() {
        employee.setPhoneNum("010-5645-6122");
        assertEquals("010-5645-6122", employee.getPhoneNum());
        assertEquals("5645", employee.getPhoneMiddleNum());
        assertEquals("6122", employee.getPhoneEndNum());
    }

    @Test
    void setPhoneMiddleNum() {
        employee.setPhoneMiddleNum("5645");
        assertEquals("010-5645-2609", employee.getPhoneNum());
        assertEquals("5645", employee.getPhoneMiddleNum());
    }

    @Test
    void setPhoneEndNum() {
        employee.setPhoneEndNum("6122");
        assertEquals("010-3112-6122", employee.getPhoneNum());
        assertEquals("3112", employee.getPhoneMiddleNum());
    }

    @Test
    void getBirthDate() {
        assertEquals("19771211", employee.getBirthDate());
    }

    @Test
    void getBirthYear() {
        assertEquals("1977", employee.getBirthYear());
    }

    @Test
    void getBirthMonth() {
        assertEquals("12", employee.getBirthMonth());
    }

    @Test
    void getBirthDay() {
        assertEquals("11", employee.getBirthDay());
    }

    @Test
    void setBirthDate() {
        employee.setBirthDate("20010503");
        assertEquals("20010503", employee.getBirthDate());
    }

    @Test
    void setBirthYear() {
        employee.setBirthYear("2001");
        assertEquals("2001", employee.getBirthYear());
        assertEquals("20011211", employee.getBirthDate());
    }

    @Test
    void setBirthMonth() {
        employee.setBirthMonth("05");
        assertEquals("05", employee.getBirthMonth());
        assertEquals("19770511", employee.getBirthDate());
    }

    @Test
    void setBirthDay() {
        employee.setBirthDay("03");
        assertEquals("03", employee.getBirthDay());
        assertEquals("19771203", employee.getBirthDate());
    }

    @Test
    void getCareer() {
        assertEquals("CL3", employee.getCareer());
    }

    @Test
    void setCareer() {
        employee.setCareer("CL2");
        assertEquals("CL2", employee.getCareer());
    }

    @Test
    void getCerti() {
        assertEquals("ADV", employee.getCerti());
    }

    @Test
    void setCerti() {
        employee.setCerti("PRO");
        assertEquals("PRO", employee.getCerti());
    }

}