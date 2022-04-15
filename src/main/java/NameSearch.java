public class NameSearch implements SearchPolicy {
    InputOption inputOption;
    String source;
    Employee emp = null;

    @Override
    public boolean search(String source)  {
        inputOption = InputOption.getInstance();
        this.source=source;
        //option값이 없는 경우
        if(inputOption==null) {
            return matchAll(source);
        }
        //option값이 있는 경우
        return matchPart();
    }

    private boolean matchAll(String source) {
        if(source.equals(emp.getName()))
            return true;
         return false;
    }

    private boolean matchPart() {
        if((inputOption.equals(Option.FIRST) && source.equals(emp.getName().getFirstName()))||(inputOption.equals(Option.LAST) && source.equals(emp.getName().getSecondName()))) {
            return true;
        }
        return false;
    }

}
