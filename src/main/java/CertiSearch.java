public class CertiSearch implements SearchPolicy{
    Employee emp = null;
    @Override
    public boolean search(String source) {
        if(source.equals(emp.getCerti()))
            return true;
        return false;
    }
}
