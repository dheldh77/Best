public class PhoneSearch implements SearchPolicy {
    InputOption inputOption;
    String source;
    Employee emp = null;

    @Override
    public boolean search(String source) {
        inputOption = InputOption.getInstance();
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
        if((inputOption.equals(Option.MIDDLE_OR_MONTH) && Integer.parseInt(source)==  emp.getPhoneNum().getMiddleNum()) ||  (inputOption.equals(Option.LAST) && Integer.parseInt(source)==emp.getPhoneNum().setEndNum()))
            return true;
        return false;
    }
}