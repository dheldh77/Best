import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ExecutorTest {
    @Test
    void addTest() {
        assertTrue(new Executor().add("05101762", "VCUHLE HMU", "CL4", "010-3988-9289", "20030819", "PRO"));
    }

    void delTest() {
        assertTrue(new Executor().delete("employeeNum", "18115040"));
        assertTrue(new Executor().delete("name", "MPOSXU"));
    }

    void modTest() {
        assertTrue(new Executor().modify("name", "FB NTAWR", "cl", "CL3"));
    }

    void searchTest() {
        assertTrue(new Executor().search(Option.FIRST, "name","KYUMOK"));
    }
}
