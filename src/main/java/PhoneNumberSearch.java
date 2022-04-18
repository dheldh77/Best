import jdk.nashorn.internal.runtime.regexp.joni.Option;

public class PhoneNumberSearch implements SearchPolicy {
    InputOption inputOption;
    String source;
    Employee emp ;

    @Override
    public boolean search(Employee emp, String source) {
        inputOption = InputOption.getInstance();
        this.emp = emp;
        this.source=source;
        //옵션값이 없는 경우
        if(inputOption.isActivatedOption(Option.NONE)){
            return matchAll();
        }
        //옵션값이 있는 경우
        return matchPart();
    }

    private boolean matchAll() {
        return source.equals(emp.getPhoneNum());
    }

    private boolean matchPart(){
        return((inputOption.isActivatedOption(Option.MIDDLE_OR_MONTH) && source.equals(emp.getPhoneMiddleNum())) ||  (inputOption.isActivatedOption(Option.LAST) && source.equals(emp.getPhoneEndNum())));

    }
}