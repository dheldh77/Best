public class Name {
    private String firstName;
    private String SecondName;
    private String name;
    public Name(String name){
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.firstName = name.split("\\s")[0];
        this.SecondName = name.split("\\s")[1];
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        this.name = firstName + " " + this.SecondName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        this.SecondName = secondName;
        this.name = this.firstName + " " + secondName;
    }
}
