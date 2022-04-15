public class phoneSearch implements searchPolicy {

    @Override
    public boolean search(String option2, String source) {
        Employee emp = null;
        if(option2.equals("-m") && source.equals(emp.phoneNumber.middle)){
            return true;
        } else if (option2.equals("-l") && source.equals(emp.phoneNumber.last)){
            return true;
        }
        return false;
    }
}