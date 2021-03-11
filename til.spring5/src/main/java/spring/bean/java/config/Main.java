package spring.bean.java.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
//    method 1
//    ApplicationContext ctx = new AnnotationConfigApplicationContext(spring.bean.java.config.AppConfig.class);

//    method 2
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.register(AppConfig.class);
    ctx.refresh();

    EmployeeManager employeeManager = ctx.getBean(EmployeeManager.class);
    Employee employee = employeeManager.create();

    System.out.println(employee);
  }
}
