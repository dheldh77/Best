public class EmployeeNumber {
    private String employeeNumber;
    private int year;
    private int secondNum;
    public EmployeeNumber(String employeeNumber){
        setEmployeeNumber(employeeNumber);
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
        this.year = calYear(employeeNumber);
        this.secondNum = Integer.parseInt(employeeNumber.substring(2, 8));
    }

    public int getYear() {
        return year;
    }

    public int getSecondNum() {
        return secondNum;
    }

    private int calYear(String employeeNumber){
        int year = Integer.parseInt(employeeNumber.substring(0, 2));
        if (year >= 69 && year <= 99) return 1900 + year;
        return 2000 + year;
    }
}
