package Commander;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class ReaderTest {
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
    void readTest() {
        Reader reader = new Reader();
        ArrayList<ArrayList<String>> lines = reader.read("src\\test\\resources\\input_20_20.txt");

        assertEquals(lines.size(), 40);

        for (ArrayList<String> line : lines) {
            System.out.println(line);
        }

        String expectedResult = "[ADD,  ,  ,  , 15123099, VXIHXOTH JHOP, CL3, 010-3112-2609, 19771211, ADV]\r\n" +
                                "[ADD,  ,  ,  , 17112609, FB NTAWR, CL4, 010-5645-6122, 19861203, PRO]\r\n" +
                                "[ADD,  ,  ,  , 18115040, TTETHU HBO, CL3, 010-4581-2050, 20080718, ADV]\r\n" +
                                "[ADD,  ,  ,  , 88114052, NQ LVARW, CL4, 010-4528-3059, 19911021, PRO]\r\n" +
                                "[ADD,  ,  ,  , 19129568, SRERLALH HMEF, CL2, 010-3091-9521, 19640910, PRO]\r\n" +
                                "[ADD,  ,  ,  , 17111236, VSID TVO, CL1, 010-3669-1077, 20120718, PRO]\r\n" +
                                "[ADD,  ,  ,  , 18117906, TWU QSOLT, CL4, 010-6672-7186, 20030413, PRO]\r\n" +
                                "[ADD,  ,  ,  , 08123556, WN XV, CL1, 010-7986-5047, 20100614, PRO]\r\n" +
                                "[ADD,  ,  ,  , 02117175, SBILHUT LDEXRI, CL4, 010-2814-1699, 19950704, ADV]\r\n" +
                                "[ADD,  ,  ,  , 03113260, HH LTUPF, CL2, 010-5798-5383, 19791018, PRO]\r\n" +
                                "[ADD,  ,  ,  , 14130827, RPO JK, CL4, 010-3231-1698, 20090201, ADV]\r\n" +
                                "[ADD,  ,  ,  , 01122329, DN WD, CL4, 010-7174-5680, 20071117, PRO]\r\n" +
                                "[ADD,  ,  ,  , 08108827, RTAH VNUP, CL4, 010-9031-2726, 19780417, ADV]\r\n" +
                                "[ADD,  ,  ,  , 85125741, FBAH RTIJ, CL1, 010-8900-1478, 19780228, ADV]\r\n" +
                                "[ADD,  ,  ,  , 08117441, BMU MPOSXU, CL3, 010-2703-3153, 20010215, ADV]\r\n" +
                                "[ADD,  ,  ,  , 10127115, KBU MHU, CL3, 010-3284-4054, 19660814, ADV]\r\n" +
                                "[ADD,  ,  ,  , 12117017, LFIS JJIVL, CL1, 010-7914-4067, 20120812, PRO]\r\n" +
                                "[ADD,  ,  ,  , 11125777, TKOQKIS HC, CL1, 010-6734-2289, 19991001, PRO]\r\n" +
                                "[ADD,  ,  ,  , 11109136, QKAHCEX LTODDO, CL4, 010-2627-8566, 19640130, PRO]\r\n" +
                                "[ADD,  ,  ,  , 05101762, VCUHLE HMU, CL4, 010-3988-9289, 20030819, PRO]\r\n" +
                                "[SCH, -p, -d,  , birthday, 04]\r\n" +
                                "[MOD, -p,  ,  , name, FB NTAWR, birthday, 20050520]\r\n" +
                                "[SCH,  ,  ,  , employeeNum, 79110836]\r\n" +
                                "[DEL,  ,  ,  , employeeNum, 18115040]\r\n" +
                                "[DEL, -p, -l,  , name, MPOSXU]\r\n" +
                                "[SCH, -p,  ,  , certi, PRO]\r\n" +
                                "[SCH,  ,  ,  , certi, ADV]\r\n" +
                                "[SCH, -p,  ,  , cl, CL4]\r\n" +
                                "[SCH,  , -m,  , birthday, 09]\r\n" +
                                "[MOD, -p,  ,  , name, FB NTAWR, cl, CL3]\r\n" +
                                "[MOD, -p,  ,  , employeeNum, 08123556, birthday, 20110706]\r\n" +
                                "[SCH, -p, -y,  , birthday, 2003]\r\n" +
                                "[SCH, -p,  ,  , employeeNum, 05101762]\r\n" +
                                "[SCH, -p, -m,  , phoneNum, 3112]\r\n" +
                                "[SCH, -p, -l,  , phoneNum, 4605]\r\n" +
                                "[SCH, -p,  ,  , employeeNum, 10127115]\r\n" +
                                "[MOD, -p,  ,  , phoneNum, 010-8900-1478, certi, PRO]\r\n" +
                                "[SCH,  , -f,  , name, LDEXRI]\r\n" +
                                "[MOD,  ,  ,  , name, VCUHLE HMU, birthday, 19910808]\r\n" +
                                "[SCH,  ,  ,  , name, FB NTAWR]\r\n";

        assertEquals(expectedResult, outContent.toString());

    }
}
