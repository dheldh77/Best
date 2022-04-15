public class ClSearch implements SearchPolicy{
    Employee emp = null;
    @Override
    public boolean search(String source) {
        if(source.equals(emp.getCl()))
            return true;
        return false;
    }
}
