import java.util.ArrayList;

public class SelectionSort implements SortAlgorithm{
    @Override
    public void executeSort(ArrayList<Employee> employees){
        int n = employees.size();
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                if (employees.get(a).getYear() > employees.get(b).getYear()) {
                    Employee temp = employees.get(a);
                    employees.set(a, employees.get(b));
                    employees.set(b, temp);
                }
            }
        }
    }
}
