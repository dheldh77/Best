public class Executor {
    // EmployeeService를 위임하여 add/del/mod/search 수행
    //EmployeeService emplServ
    public boolean add(String employeeNum, String name, String careerLevel, String phoneNum, String birthday, String certi) {
        //return emplServ.add(employeeNum, name, careerLevel, phoneNum, birthday, certi);
        return false;
    }

    public boolean delete(String type, String value){
        //return emplServ.delete(type, value);
        return false;
    }

    public boolean modify(String fromType, String fromValue, String toType, String toValue){
        //return emplServ.modify(fromType, fromValue, toType, toValue);
        return false;
    }

    // Search 에서 Return type 정의 후 수정 예정
    // Search하여 Return 된 값은 Printer에 전달하여 print 될 수 있도록 한다.
    public boolean search(Option opt2, String type, String value){
        //return emplServ.search(type, value);
        return false;
    }

}
