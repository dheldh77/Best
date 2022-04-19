package Sort;

import Employee.Employee;

import java.util.ArrayList;
import java.util.Collections;

public class InnerSort implements SortAlgorithm{
    @Override
    public void executeSort(ArrayList<Employee> employees) {
        Collections.sort(employees);
    }
}
