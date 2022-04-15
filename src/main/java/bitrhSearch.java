public class bitrhSearch implements searchPolicy{
    @Override
    public boolean search(String option2, String source) {
        Employee emp=null;
        if(option2.equals("-y") &&  Integer.parseInt(source)==emp.BirthDay.year)
            return true;
        else if(option2.equals("-m") &&  Integer.parseInt(source)==emp.BirthDay.month)
            return true;
        else if(option2.equals("-d") &&  Integer.parseInt(source)==emp.BirthDay.day)
            return true;
        return false;
    }
}
