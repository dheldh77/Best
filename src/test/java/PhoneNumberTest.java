import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberTest {
    PhoneNumber phoneNumber = new PhoneNumber("010-9777-5455");
    @Test
    void getPhoneNum(){
        assertEquals("010-9777-5455",  phoneNumber.getPhoneNum());
    }
    @Test
    void getFirstNum(){
        assertEquals("9777",  phoneNumber.getMiddleNum());
    }
    @Test
    void getEndNum(){
        assertEquals("5455", phoneNumber.getEndNum());
    }

    @Test
    void setPhoneNumber(){
        phoneNumber.setPhoneNum("010-5455-9777");
        assertEquals("010-5455-9777", phoneNumber.getPhoneNum());
        assertEquals("5455", phoneNumber.getMiddleNum());
        assertEquals("9777", phoneNumber.getEndNum());
    }

    @Test
    void SetMiddleNumber(){
        phoneNumber.setMiddleNum("8400");
        assertEquals("8400", phoneNumber.getMiddleNum());
        assertEquals("010-8400-5455", phoneNumber.getPhoneNum());
    }

    @Test
    void SetEndNumber(){
        phoneNumber.setEndNum("8400");
        assertEquals("8400", phoneNumber.getEndNum());
        assertEquals("010-9777-8400", phoneNumber.getPhoneNum());
    }
}