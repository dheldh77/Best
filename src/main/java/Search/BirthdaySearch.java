package Search;

import Employee.Employee;
import Option.InputOption;
import Option.Option;

public class BirthdaySearch implements SearchPolicy {
    private Option option;
    private Employee emp;
    private String source;

    @Override
    public boolean search(Employee emp,String source) {
        this.option=  InputOption.getInstance().getActivatedOption(InputOption.getInstance().OPTION2);
        this.emp = emp;
        this.source=source;
        //option2값에 따라 다른 함수를 타도록
        return (option== Option.NONE)?matchAll(source):matchPart();
    }

    private boolean matchAll(String source) {
        return source.equals(emp.getBirthDate());
    }

    private boolean matchPart(){
        return matchYear()||matchMonth()||matchDay();
    }
    private boolean matchYear(){
        return (option== Option.BIRTHDAY_YEAR) && source.equals(emp.getBirthYear());
    }
    private boolean matchMonth(){
        return (option== Option.BIRTHDAY_MONTH) && source.equals(emp.getBirthMonth());
    }
    private boolean matchDay(){
        return (option== Option.BIRTHDAY_DAY) && source.equals(emp.getBirthDay());
    }
}
