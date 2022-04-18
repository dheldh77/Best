import Employee.Employee;
import Option.Option;

import java.util.ArrayList;

public class Printer {
    private InputOption inputOption;
    private SortAlgorithm sortAlgo;

    public Printer(String sortName) {
        SelectAlgorithm(sortName);
        inputOption = InputOption.getInstance();
    }

    public void print(String cmd, ArrayList<Employee> searchResult) {
        // record 결과가 없을 때
        if (searchResult.size() == 0) {
            System.out.println(cmd + ",NONE");
        }
        // -p 옵션이 없을 때
        else if (!inputOption.isActivatedOption(Option.PRINT)) {
            System.out.println(cmd + "," + searchResult.size());
        }
        // 그 외 조건에서는 record 출력
        // 최대 5개까지만 출력
        else {
            sortAlgo.executeSort(searchResult);

            int printCnt = 0;
            for (Employee empl : searchResult) {
                printCnt++;
                String printSet = String.join(
                        ",",
                        cmd,
                        empl.getEmpNum(),
                        empl.getName(),
                        empl.getCareer(),
                        empl.getPhoneNum(),
                        empl.getBirthDate(),
                        empl.getCerti());
                System.out.println(printSet);

                if (printCnt >= 5)
                    break;
            }
        }
    }
    private void SelectAlgorithm(String sortName) {
        if ("Selection".equals(sortName)) {
            sortAlgo = new SelectionSort();
        }
    }
}
