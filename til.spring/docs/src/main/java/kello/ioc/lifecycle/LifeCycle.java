package kello.ioc.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.LifecycleProcessor;

// InitializingBean, DisposableBean은 spring과 연결되므로
// @postConstruct, @PreDestroy나 pojo init/destroy method를 지정하는것이 좋음
/*
# 라이프사이클 수명주기
1. @PostConstruct
2. InitializingBean의 afterPropertiesSet()
3. 사용자정의 init()메소드
4. @PreDestroy
5. DisposableBean의 destroy()
6. 사용자 정의 destroy()메소드
 */
public class LifeCycle implements InitializingBean, DisposableBean, LifecycleProcessor {

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("[InitializingBean] afterPropertiesSet");
  }

  private void initialize() {
    System.out.println("[default-init-method] initialize");
  }

  private void init() {
    System.out.println("[init-method] init");
  }

  @Override
  public void destroy() throws Exception {
    System.out.println("[DisposableBean] destroy");
  }

  private void cleanup() {
    System.out.println("[destroy-method] cleanup");
  }

  private void exit() {
    System.out.println("[default-destroy-method] exit");
  }

  @Override
  public void onRefresh() {
    System.out.println("[LifeCycleProcessor] onRefresh");
  }

  @Override
  public void onClose() {
    System.out.println("[LifeCycleProcessor] onClose");
  }

  @Override
  public void start() {
    System.out.println("[LifeCycle] start");
  }

  @Override
  public void stop() {
    System.out.println("[LifeCycle] stop");
  }

  @Override
  public boolean isRunning() {
    return false;
  }
}
