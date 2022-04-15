public class BirthSearch implements SearchPolicy {
    InputOption inputOption;
    String source;
    Employee emp = null;

    @Override
    public boolean search(String source) {
        inputOption = InputOption.getInstance();
        this.source=source;
        //option2값이 없는경우
        if(inputOption==null){
            return matchAll(source);
        }
        //option2값이 있는경우
        return matchPart();
    }

    private boolean matchAll(String source) {
        if(source.equals(emp.getBirthday()))
            return true;
        return false;
    }

    private boolean matchPart(){
        if((inputOption.equals(Option.YEAR) && Integer.parseInt(source)==  emp.getBirthday().getYear()) ||  (inputOption.equals(Option.MONTH) && Integer.parseInt(source)==emp.getBirthday().getMonth()) || (inputOption.equals(Option.DAY) && Integer.parseInt(source)==emp.getBirthday().getDay()))
            return true;
        return false;
    }
}
