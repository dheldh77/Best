package Search;

import Employee.Employee;
import Option.Option;
import Option.InputOption;

public class NameSearch implements SearchPolicy {
    private Option option;
    private String source;
    private Employee emp;


    @Override
    public boolean search(Employee emp, String source)  {
        this.option = InputOption.getInstance().getActivatedOption(InputOption.getInstance().OPTION2);
        this.source=source;
        this.emp = emp;

        return (option==Option.NONE) ?matchAll(source):matchPart();
    }

    private boolean matchAll(String source) {
        return source.equals(emp.getName());
    }

    private boolean matchPart() {
        return matchFisrtName()||matchSecondName();
    }

    private boolean matchFisrtName() {
        return (option==Option.FIRST_NAME) && source.equals(emp.getFirstName());
    }

    private boolean matchSecondName(){
        return (option==Option.LAST_NAME) && source.equals(emp.getSecondName());
    }

}
