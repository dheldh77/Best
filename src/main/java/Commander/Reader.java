package Commander;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reader {
    //private Option.Option option;
    // input 파일을 읽어 line별로 split하고, option들을 따로 분리하여 setOptions를 수행합니다.
    // option들을 제외한 요소들은 arraylist에 담고, 해당 Arraylist들을 Arraylist에 담아 return 합니다.
    public ArrayList<ArrayList<String>> read(String filename) {
        try {
            List<String> cmdList = Files.readAllLines(Paths.get(filename));
            ArrayList<ArrayList<String>> splitCmdList = new ArrayList<>();

            for (String cmd : cmdList) {
                //각 cmd 문자열에 대해 split
                String[] splitCmd = splitCommand(cmd);
                ArrayList<String> cmdArray = new ArrayList<>();
                //Split 된 요소들을 Arraylist에 담는다.
                Collections.addAll(cmdArray, splitCmd);
                //Split되어 ArrayList에 담긴 cmd를 ArrayList에 추가한다.
                splitCmdList.add(cmdArray);
            }
            return splitCmdList;
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    private String[] splitCommand(String cmd) {
        return cmd.split(",");
    }
}
