package spring.bean.eager.vs.lazy.init;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    System.out.println("Bean factory initialized.");

    EmployeeManager employeeManager = ctx.getBean(EmployeeManager.class);
    Employee employee = employeeManager.create();

    System.out.println(employee);
  }
}
