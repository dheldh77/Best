public class nameSearch implements searchPolicy{
    //employee name이 어떻게 들어가야하는지??
    //실제로 search가 일어나는 곳은 search 메서드인지
    @Override
    public boolean search(String option2, String source) {
        Employee emp = null;
        if(option2.equals("-f") && source.equals(emp.name.firstName)){
                    return true;

        }else if(option2.equals("-l") && source.equals(emp.name.firstName)) {
                return false;
        }
        return false;
    }
}
