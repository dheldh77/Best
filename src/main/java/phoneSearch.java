public class phoneSearch implements searchPolicy {

    @Override
    public boolean search(String option2, String source) {
        Employee emp = null;
        if(option2.equals("-m") && Integer.parseInt(source)==  emp.PhoneNumber.middle){
            return true;
        } else if (option2.equals("-l") && Integer.parseInt(source)==emp.PhoneNumber.last){
            return true;
        }
        return false;
    }
}