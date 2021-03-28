package spring.bean.eager.vs.lazy.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {

  @Lazy //주입 시에는 bean정의하는 곳과 해당 위치 모두 lazy로 정의해야 동작
  @Autowired
  EmployeeManager employeeManager;
}
