# Class

> Option.InputOption : 입력 옵션 설정 클래스
- public Option.InputOption getInstance(); // Option.InputOption 인스턴스 반환
- public void setOptions(String[] args); // 입력으로부터 옵션 설정, 입력 파라미터 {"", "", ""}
- public boolean isValidOption(); // 입력 옵션이 유효한 옵션인지 확인
- public boolean isActivatedOption(Option.Option opt); // 파라미터로 넘겨진 옵션이 활성화 되어있는지 확인

<br>

> Commander.Commander.Reader : 파일을 읽어, 파싱한 결과를 ArrayList에 담아 리턴
- public ArrayList<ArrayList<String>> read(String filename)

<br>
  
> Commander.Commander.Executor : setOption 후 EmployeeService의 각 함수 호출(Service에서 구현한 파라미터에 맞게 입력)
- public ArrayList<Employee> add(ArrayList<String> cmd)
- public ArrayList<Employee> delete(ArrayList<String> cmd)
- public ArrayList<Employee> modify(ArrayList<String> cmd)
- public ArrayList<Employee> search(ArrayList<String> cmd)

<br>
  
> Commander.Commander.Printer : 결과 출력 함수
- public void print(String cmd, ArrayList<Employee> searchResult)
  
<br>
  
> Commander.Commander 

- public void init(); // 변수초기화
- public void run(); // 동작 시작

<br>

> Commander.EmployeeService 

- public ArrayList<Employee> add(Employee employee)
- public ArrayList<Employee> delete(String type, Employee employee)
- public ArrayList<Employee> modify(String fromType, Employee fromEmployee, String toType, Employee toEmployee)
- public ArrayList<Employee> search(String type, Employee employee)
