package spring.bean.java.config;

public class EmployeeManagerImpl implements EmployeeManager {

  @Override
  public Employee create() {
    Employee emp = new Employee();
    emp.setId(1);
    emp.setName("Lokesh");

    return emp;
  }
}
