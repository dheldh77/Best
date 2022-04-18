import java.util.ArrayList;

public class Printer {
    private InputOption inputOption;
    private SortAlgorithm sortAlgo;
    public Printer() {
        inputOption = InputOption.getInstance();
    }

    public void SelectAlgorithm(String sortName){
        if("Selection".equals(sortName)){
            sortAlgo = new SelectionSort();
        }
    }

    public void print(String cmd, ArrayList<Employee> searchResult) {
        // record 결과가 없을 때
        if (searchResult.size() == 0) {
            System.out.println(cmd + ",NONE");
        }
        // -p 옵션이 없을 때
        else if (!inputOption.isValidOption(Option.PRINT)) {
            System.out.println(cmd + "," + searchResult.size());
        }
        // 그 외 조건에서는 record 출력
        // 최대 5개까지만 출력
        else{
            sortAlgo.executeSort(searchResult);

           int printCnt = 0;
            for(Employee empl : searchResult){
                printCnt++;
                String printSet = String.join(
                        ",",
                        cmd,
                        empl.getEmployeeNum(),
                        empl.getName(),
                        empl.getPhoneNum(),
                        empl.getBirthDay(),
                        empl.getCareer())
                System.out.println(printSet);

                if(printCnt >= 5)
                    break;
            }
        }
    }
}
