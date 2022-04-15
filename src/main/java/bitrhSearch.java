public class bitrhSearch implements searchPolicy{
    @Override
    public boolean search(String option2, String source) {
        Employee emp=null;
        if(option2.equals("-y") && source.equals(emp.birthDay.year))
            return true;
        else if(option2.equals("-m") && source.equals(emp.birthDay.month))
            return true;
        else if(option2.equals("-d") && source.equals(emp.birthDay.day))
            return true;
        return false;
    }
}
