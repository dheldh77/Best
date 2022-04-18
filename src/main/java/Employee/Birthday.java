package Employee;

public class Birthday {
    private String birthday;
    private String year;
    private String month;
    private String day;

    public Birthday (String birthday){
        setBirthday(birthday);
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
        this.year = birthday.substring(0,4);
        this.month = birthday.substring(4,6);
        this.day = birthday.substring(6,8);
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
        this.birthday = year + this.month + this.day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
        this.birthday = this.year + month + this.day;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
        this.birthday = this.year + this.month + day;
    }
}
