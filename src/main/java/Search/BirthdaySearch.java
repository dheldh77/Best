package Search;

import Employee.Employee;
import Option.InputOption;
import Option.Option;

public class BirthdaySearch implements SearchPolicy {
    Option option;
    Employee emp;
    String source;

    public BirthdaySearch(){}
    @Override
    public boolean search(Employee emp,String source) {
        this.option=  InputOption.getInstance().getActivatedOption(1);
        this.emp = emp;
        this.source=source;
        //option2값이 없는경우
        if(option== Option.NONE){
            return matchAll(source);
        }
        //option2값이 있는경우
        return matchPart();
    }

    private boolean matchAll(String source) {
        return source.equals(emp.getBirthDate());
    }

    private boolean matchPart(){
        return ((option== Option.BIRTHDAY_YEAR && source.equals(emp.getBirthYear())) ||  (option== Option.BIRTHDAY_MONTH && source.equals(emp.getBirthMonth())) || (option== Option.BIRTHDAY_DAY && source.equals(emp.getBirthDay())));

    }
}
