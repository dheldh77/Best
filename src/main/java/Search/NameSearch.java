package Search;

import Employee.Employee;
import Option.Option;
import Option.InputOption;

public class NameSearch implements SearchPolicy {
    Option option;
    String source;
    Employee emp;


    @Override
    public boolean search(Employee emp, String source)  {
        this.option = InputOption.getInstance().getActivatedOption(1);
        this.source=source;
        this.emp = emp;
        if(option==Option.NONE) {
            return matchAll(source);
        }
        return matchPart();
    }

    private boolean matchAll(String source) {
        return source.equals(emp.getName());
    }

    private boolean matchPart() {
        return ((option==Option.FIRST_NAME) && source.equals(emp.getFirstName()))||(option==Option.LAST_NAME && source.equals(emp.getSecondName()));
    }

}
