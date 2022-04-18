import Employee.Employee;
import Option.Option;

public class NameSearch implements SearchPolicy {
    InputOption inputOption;
    String source;
    Employee emp;

    @Override
    public boolean search(Employee emp, String source)  {
        inputOption = InputOption.getInstance();
        this.source=source;
        this.emp = emp;
        //option값이 없는 경우
        if(inputOption==null) {
            return matchAll(source);
        }
        //option값이 있는 경우
        return matchPart();
    }

    private boolean matchAll(String source) {
        if(source.equals(emp.getName()))
            return true;
         return false;
    }

    private boolean matchPart() {
        if((inputOption.isActivatedOption(Option.FIRST) && source.equals(emp.getFirstName()))||(inputOption.isActivatedOption(Option.LAST) && source.equals(emp.getSecondName()))) {
            return true;
        }
        return false;
    }

}
