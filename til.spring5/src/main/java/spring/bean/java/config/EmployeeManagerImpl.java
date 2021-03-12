package spring.bean.java.config;

class EmployeeManagerImpl implements EmployeeManager {

  @Override
  public Employee create() {
    Employee emp = new Employee();
    emp.setId(1);
    emp.setName("Lokesh");

    return emp;
  }
}
