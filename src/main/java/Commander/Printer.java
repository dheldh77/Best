package Commander;

import Employee.Employee;
import Option.InputOption;
import Option.Option;
import Sort.*;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Printer {
    private InputOption inputOption;
    private SortAlgorithm sortAlgo;

    public Printer(String sortName) {
        SelectAlgorithm(sortName);
        inputOption = InputOption.getInstance();
    }

    public void print(ArrayList<Employee> searchResult, String outFilePath) {
        BufferedOutputStream outputStream = null;
        try {
            StringBuilder printResult;
            outputStream = new BufferedOutputStream(new FileOutputStream(outFilePath));

            String cmd = inputOption.getOperationMode(inputOption.OPTION1);
            // record 결과가 없을 때
            if (searchResult.size() == 0) {
                printResult = new StringBuilder(cmd + ",NONE");
            }
            // -p 옵션이 없을 때
            else if (inputOption.getActivatedOption(inputOption.OPTION1) != Option.PRINT) {
                printResult = new StringBuilder(cmd + "," + searchResult.size());
            }
            // 그 외 조건에서는 record 출력
            // 최대 5개까지만 출력
            else {
                sortAlgo.executeSort(searchResult);

                int printCnt = 0;
                printResult = new StringBuilder();
                for (Employee empl : searchResult) {
                    printCnt++;
                    printResult.append(cmd)
                               .append(",")
                               .append(empl.toString())
                               .append("\r\n");

                    if (printCnt >= 5)
                        break;
                }
            }
            outputStream.write(printResult.toString().getBytes());
        } catch (Exception e) {
            System.out.println("File Output Error" + e);
        } finally {
            try {
                if (outputStream != null) outputStream.close();
            } catch (Exception e) {
                System.out.println("OutputStream Close Failed!" + e);
            }
        }
    }

    private void SelectAlgorithm(String sortName) {
        if ("Selection".equals(sortName)) {
            sortAlgo = new SelectionSort();
        } else if ("Inner".equals(sortName)) {
            sortAlgo = new InnerSort();
        }
    }
}
