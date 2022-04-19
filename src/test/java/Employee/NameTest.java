package Employee;

import Employee.Name;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {
    Name name = new Name("VXIHXOTH JHOP");
    @Test
    public void FirstName_Getter(){
        assertEquals(name.getFirstName(),  "VXIHXOTH");
    }

    @Test
    public void SecondName_Getter(){
        assertEquals(name.getSecondName(), "JHOP");
    }
    @Test
    public void name_Getter(){
        assertEquals(name.getName(), "VXIHXOTH JHOP");
    }

    @Test
    public void FirstName_Setter(){
        name.setFirstName("ATHKERMD");
        assertEquals(name.getFirstName(),  "ATHKERMD");
        assertEquals(name.getName(), "ATHKERMD JHOP");
    }

    @Test
    public void SecondName_Setter(){
        name.setSecondName("HKTNEKE");
        assertEquals(name.getSecondName(),  "HKTNEKE");
        assertEquals(name.getName(), "VXIHXOTH HKTNEKE");
    }
}
