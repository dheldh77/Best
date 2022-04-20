package Search;

import Employee.Employee;
import Option.Option;
import Option.InputOption;

public class PhoneNumberSearch implements SearchPolicy {
    private Option option;
    private String source;
    private Employee emp ;

    @Override
    public boolean search(Employee emp, String source) {
        this.option = InputOption.getInstance().getActivatedOption(InputOption.getInstance().OPTION2);
        this.emp = emp;
        this.source=source;

        return (option== Option.NONE)? matchAll():matchPart();
    }

    private boolean matchAll() {
        return source.equals(emp.getPhoneNum());
    }

    private boolean matchPart(){
        return matchMiddlePhoneNum()||matchLastPhoneNum();
    }

    private boolean matchMiddlePhoneNum(){
        return (option==Option.MIDDLE_PHONENUMBER) && source.equals(emp.getPhoneMiddleNum());
    }
    private  boolean matchLastPhoneNum(){
        return (option==Option.LAST_PHONENUMBER) && source.equals(emp.getPhoneEndNum());
    }
}