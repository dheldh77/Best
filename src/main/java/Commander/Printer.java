package Commander;

import Employee.Employee;
import Option.InputOption;
import Option.Option;
import Sort.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Printer {
    private InputOption inputOption;
    private SortAlgorithm sortAlgo;
    private FileWriter fileWriter = null;

    public Printer(String sortName, String outputTxt) throws IOException {
        SelectAlgorithm(sortName);
        inputOption = InputOption.getInstance();
        fileWriter = new FileWriter(new File(outputTxt));
    }

    public void print(ArrayList<Employee> searchResult) throws IOException {
        String cmd = inputOption.getOperationMode(inputOption.OPTION1);
        // record 결과가 없을 때
        if (searchResult.size() == 0) {
            fileWriter.write(cmd + ",NONE" + "\n");
        }
        // -p 옵션이 없을 때
        else if (inputOption.getActivatedOption(inputOption.OPTION1) != Option.PRINT) {
            fileWriter.write(cmd + "," + searchResult.size() + "\n");
        }
        // 그 외 조건에서는 record 출력
        // 최대 5개까지만 출력
        else {
            printExecResult(searchResult, cmd);
        }
    }

    public void EndPrint() throws IOException {
        fileWriter.flush();
        fileWriter.close();
    }

    private void printExecResult(ArrayList<Employee> searchResult, String cmd) throws IOException {
        sortAlgo.executeSort(searchResult);

        int printCnt = 0;
        for (Employee empl : searchResult) {
            printCnt++;
            String printSet = String.join(
                    ",",
                    cmd,
                    empl.toString());
            fileWriter.write(printSet + "\n");

            if (printCnt >= 5)
                break;
        }
    }

    private void SelectAlgorithm(String sortName) {
        if ("Selection".equals(sortName)) {
            sortAlgo = new SelectionSort();
        }
        else if("Inner".equals(sortName)){
            sortAlgo = new InnerSort();
        }
    }
}
