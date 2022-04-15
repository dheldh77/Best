import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BirthdayTest {
    Birthday birthday = new Birthday("19810630");

    @Test
    void getFullBirthday(){
        assertEquals("19810630", birthday.getBirthday());
    }
    @Test
    void getYear(){
        assertEquals("1981", birthday.getYear());
    }
    @Test
    void getMonth(){
        assertEquals("06", birthday.getMonth());
    }
    @Test
    void getDay(){
        assertEquals("30", birthday.getDay());
    }
    @Test
    void setBirthday(){
        birthday.setBirthday("20000906");
        assertEquals("20000906", birthday.getBirthday());
        assertEquals("2000", birthday.getYear());
        assertEquals("09", birthday.getMonth());
        assertEquals("06", birthday.getDay());
    }

    @Test
    void setYear(){
        birthday.setYear("2000");
        assertEquals("20000630", birthday.getBirthday());
        assertEquals("2000", birthday.getYear());
    }

    @Test
    void setMonth(){
        birthday.setMonth("09");
        assertEquals("19810930", birthday.getBirthday());
        assertEquals("09", birthday.getMonth());
    }

    @Test
    void setDay(){
        birthday.setDay("06");
        assertEquals("19810606", birthday.getBirthday());
        assertEquals("06", birthday.getDay());
    }
}
