package kello.ioc.beans.dependency;

import java.lang.reflect.Method;
import org.springframework.beans.factory.support.MethodReplacer;

public class MethodReplacementBean2 implements MethodReplacer {

  @Override
  public Object reimplement(Object obj, Method method, Object[] args) {
    return "[MethodReplacementBean2]" + args[0];
  }
}
