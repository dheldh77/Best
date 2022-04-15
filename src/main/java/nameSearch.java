public class nameSearch implements searchPolicy{
    InputOption option2;
    String source;
    Employee emp = null;
    @Override
    public boolean search(InputOption option2, String source)  {
        this.option2 = option2;
        this.source=source;
        //option값이 없는 경우
        if(option2==null) {
            return matchAll(source);
        }
        //option값이 있는 경우
        return matchPart();
    }

    private boolean matchAll(String source) {
        if(source.equals(emp.Name.getName()))
            return true;
         return false;
    }

    private boolean matchPart() {
        if(!option2.isValidOption(Option.FIRST) && !option2.isValidOption(Option.LAST)) {
            System.out.println("잘못된 옵션값이 입력되었습니다.");
            return false;
        }
        if((option2.equals(Option.FIRST) && source.equals(emp.Name.getFirstName()))||(option2.equals(Option.LAST) && source.equals(emp.Name.getSecondName()))) {
            return true;
        }
        return false;
    }

}
