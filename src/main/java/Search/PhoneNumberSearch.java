package Search;

import Employee.Employee;
import Option.Option;
import Option.InputOption;

public class PhoneNumberSearch implements SearchPolicy {
    Option option;
    String source;
    Employee emp ;

    @Override
    public boolean search(Employee emp, String source) {
        this.option = InputOption.getInstance().getActivatedOption(1);
        this.emp = emp;
        this.source=source;

        if(option== Option.NONE){
            return matchAll();
        }
        return matchPart();
    }

    private boolean matchAll() {
        return source.equals(emp.getPhoneNum());
    }

    private boolean matchPart(){
        return((option==Option.MIDDLE_PHONENUMBER) && source.equals(emp.getPhoneMiddleNum())) ||  (option==Option.LAST_PHONENUMBER&& source.equals(emp.getPhoneEndNum()));
    }
}