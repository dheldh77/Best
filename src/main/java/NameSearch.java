public class NameSearch implements SearchPolicy {
    InputOption inputOption;
    String source;
    Employee emp;

    @Override
    public boolean search(Employee emp, String source)  {
        inputOption = InputOption.getInstance();
        this.source=source;
        this.emp = emp;
        //option값이 없는 경우
        if(inputOption.isActivatedOption(Option.NONE)) {
            return matchAll(source);
        }
        //option값이 있는 경우
        return matchPart();
    }

    private boolean matchAll(String source) {
        return source.equals(emp.getName());
    }

    private boolean matchPart() {
        return ((inputOption.isActivatedOption(Option.FIRST) && source.equals(emp.getFirstName()))||(inputOption.isActivatedOption(Option.LAST) && source.equals(emp.getSecondName())));
    }

}
