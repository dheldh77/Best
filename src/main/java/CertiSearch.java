public class CertiSearch implements SearchPolicy{

    @Override
    public boolean search(Employee emp, String source) {
        return source.equals(emp.getCerti());
    }
}
