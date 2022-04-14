public class Name {
    private String firstName;
    public String SecondName;
    public Name(String name){
        this.firstName = name.split("\\s")[0];
        this.SecondName = name.split("\\s")[1];
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }
}
