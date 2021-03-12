package spring.bean.eager.vs.lazy.init;

import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy // 지연로딩을 위해 빈 정의 시 lazy어노테이션 등록
@Service
class EmployeeManagerImpl implements EmployeeManager {

  @Override
  public Employee create() {
    Employee employee = new Employee();
    employee.setId(1);
    employee.setName("Lokesh");

    return employee;
  }

  @PostConstruct
  public void onInit() {
    System.out.println("EmployeeManagerImpl bean is created.");
  }
}
