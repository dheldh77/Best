public class bitrhSearch implements searchPolicy{

    InputOption option2;
    String source;
    Employee emp = null;
    @Override
    public boolean search(InputOption option2, String source) {
        this.option2 = option2;
        this.source=source;
        //option2값이 없는경우
        if(option2==null){
            return matchAll(source);
        }
        //option2값이 있는경우
        return matchPart();
    }

    private boolean matchAll(String source) {
        if(source.equals(emp.Birthday.getBirthday()))
            return true;
        return false;
    }

    private boolean matchPart(){
        if(!option2.isValidOption(Option.YEAR) && !option2.isValidOption(Option.MONTH) && !option2.isValidOption(Option.DAY)) {
            System.out.println("잘못된 옵션값이 입력되었습니다.");
            return false;
        }
        if((option2.equals(Option.YEAR) && Integer.parseInt(source)==  emp.Birthday.getYear()) ||  (option2.equals(Option.MONTH) && Integer.parseInt(source)==emp.Birthday.getMonth()) || (option2.equals(Option.DAY) && Integer.parseInt(source)==emp.Birthday.getDay()))
            return true;
        return false;
    }
}
