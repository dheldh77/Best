import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    //private Option option;
    // input 파일을 읽어 line별로 split하고, option들을 따로 분리하여 setOptions를 수행합니다.
    // option들을 제외한 요소들은 arraylist에 담고, 해당 Arraylist들을 Arraylist에 담아 return 합니다.
    public ArrayList<ArrayList<String>> read(String filename) {
        try {
            List<String> cmdList = Files.readAllLines(Paths.get(filename));
            ArrayList<ArrayList<String>> cmdListExceptOpts = new ArrayList<>();

            for (String cmd : cmdList) {
                String[] splitCmd = splitCommand(cmd);
                String[] opts = {splitCmd[1], splitCmd[2], splitCmd[3]};

                //option.setOptions(opts);

                ArrayList<String> cmdArray = new ArrayList<>();
                for(int i = 0; i < splitCmd.length; i++){
                    if(i == 1 || i == 2 || i == 3) continue;
                    cmdArray.add(splitCmd[i]);
                }
                cmdListExceptOpts.add(cmdArray);
            }
            return cmdListExceptOpts;
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    private String[] splitCommand(String cmd) {
        return cmd.split(",");
    }
}
