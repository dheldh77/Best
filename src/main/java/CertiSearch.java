public class CertiSearch implements SearchPolicy{

    @Override
    public boolean search(Employee emp, String source) {
        if(source.equals(emp.getCerti()))
            return true;
        return false;
    }
}
