import jdk.internal.util.xml.impl.Input;

import java.util.Optional;

public class phoneSearch implements searchPolicy {

    InputOption option2;
    String source;
    Employee emp = null;

    @Override
    public boolean search(InputOption option2, String source) {
        this.option2 = option2;
        this.source=source;
        //옵션값이 없는 경우
        if(option2==null){
            return matchAll();
        }
        //옵션값이 있는 경우
        return matchPart();
    }

    private boolean matchAll() {
        if(source.equals(emp.PhoneNumber.getPhoneNum()))
            return true;
        return false;
    }

    private boolean matchPart(){
        if (!option2.isValidOption(Option.MIDDLE_OR_MONTH) && !option2.isValidOption(Option.LAST)) {
            System.out.println("잘못된 옵션값이 입력되었습니다.");
            return false;
        }
        if((option2.equals(Option.MIDDLE_OR_MONTH) && Integer.parseInt(source)==  emp.PhoneNumber.getMiddleNum()) ||  (option2.equals(Option.LAST) && Integer.parseInt(source)==emp.PhoneNumber.setEndNum()))
            return true;
        return false;
    }
}