package kello.ioc.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// InitializingBean, DisposableBean은 spring과 연결되므로
// @postConstruct, @PreDestroy나 pojo init/destroy method를 지정하는것이 좋음
/*
# 라이프사이클 수명주기
1. 생성자
2. @PostConstruct
3. InitializingBean의 afterPropertiesSet()
4. 사용자정의 init()메소드
5. @PreDestroy
6. DisposableBean의 destroy()
7. 사용자 정의 destroy()메소드
 */
public class LifeCycle implements InitializingBean, DisposableBean, BeanNameAware {

  private String name;

  @Override
  public void setBeanName(String name) {
    this.name = name;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("["+name+"] InitializingBean: afterPropertiesSet");
  }

  @PostConstruct
  public void postConstruct() {
    System.out.println("["+name+"] PostConstruct");
  }

  private void initialize() {
    System.out.println("["+name+"] default-init-method: initialize");
  }

  private void init() {
    System.out.println("["+name+"] init-method: init");
  }

  public LifeCycle() {
    System.out.println("["+name+"] constructor");
  }

  @Override
  public void destroy() throws Exception {
    System.out.println("["+name+"] DisposableBean: destroy");
  }

  @PreDestroy
  public void preDestroy() {
    System.out.println("["+name+"] PreDestroy");
  }

  private void cleanup() {
    System.out.println("["+name+"] destroy-method: cleanup");
  }

  private void exit() {
    System.out.println("["+name+"] default-destroy-method: exit");
  }

}
