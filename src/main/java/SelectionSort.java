import Employee.Employee;

import java.util.ArrayList;

public class SelectionSort implements SortAlgorithm {
    @Override
    public void executeSort(ArrayList<Employee> employees) {
        int n = employees.size();
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                if (employees.get(a).getEmpNumYear() > employees.get(b).getEmpNumYear()) {
                    swapOrder(employees, a, b);
                } else if (employees.get(a).getEmpNumYear() == employees.get(b).getEmpNumYear()
                        && employees.get(a).getEmpNumSecondNum() > employees.get(b).getEmpNumSecondNum()) {
                    swapOrder(employees, a, b);
                }
            }
        }
    }

    private void swapOrder(ArrayList<Employee> employees, int a, int b) {
        Employee temp = employees.get(a);
        employees.set(a, employees.get(b));
        employees.set(b, temp);
    }
}
