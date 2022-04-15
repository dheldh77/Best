public class PhoneNumber {
    private String middleNum;
    private String endNum;
    private String phoneNum;

    public PhoneNumber(String phoneNum){
        this.phoneNum = phoneNum;
        this.middleNum = phoneNum.split("-")[1];
        this.endNum = phoneNum.split("-")[2];
    }

    public String getMiddleNum() {
        return middleNum;
    }

    public void setMiddleNum(String middleNum) {
        this.middleNum = middleNum;
        this.phoneNum = "010" + "-" + middleNum + "-" + this.endNum;
    }

    public String getEndNum() {
        return endNum;
    }

    public void setEndNum(String endNum) {
        this.endNum = endNum;
        this.phoneNum = "010" + "-" + this.middleNum + "-" + endNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        this.middleNum = phoneNum.split("-")[1];
        this.endNum = phoneNum.split("-")[2];
    }
}
