import Employee.Employee;
import Option.Option;

public class PhoneSearch implements SearchPolicy {
    InputOption inputOption;
    String source;
    Employee emp ;

    @Override
    public boolean search(Employee emp, String source) {
        inputOption = InputOption.getInstance();
        this.emp = emp;
        this.source=source;
        //옵션값이 없는 경우
        if(inputOption==null){
            return matchAll();
        }
        //옵션값이 있는 경우
        return matchPart();
    }

    private boolean matchAll() {
        if(source.equals(emp.getPhoneNum()))
            return true;
        return false;
    }

    private boolean matchPart(){
        if((inputOption.isActivatedOption(Option.MIDDLE_OR_MONTH) && source.equals(emp.getPhoneMiddleNum())) ||  (inputOption.isActivatedOption(Option.LAST) && source.equals(emp.getPhoneEndNum())))
            return true;
        return false;
    }
}