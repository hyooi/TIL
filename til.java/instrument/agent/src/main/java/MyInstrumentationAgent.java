import java.lang.instrument.Instrumentation;

public class MyInstrumentationAgent {
  public static void premain(String agentArgs, Instrumentation inst) {
    System.out.println("[Agent] In premain method");
    String className = "application.MyAtm";

    transformClass(className, inst);
  }

  public static void agentmain(String agentArgs, Instrumentation inst) {
    System.out.println("[Agent] In agentmain method");
    String className = "MyAtm";

    transformClass(className, inst);
  }

  private static void transformClass(String className, Instrumentation inst) {
    Class<?> targetCls;
    ClassLoader targetClassLoader;

    try {
      targetCls = Class.forName(className);
      targetClassLoader = targetCls.getClassLoader();
      transform(targetCls, targetClassLoader, inst);

      return;
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    for(Class<?> clazz : inst.getAllLoadedClasses()) {
      if(clazz.getName().equals(className)) {
        targetCls = clazz;
        targetClassLoader = targetCls.getClassLoader();
        transform(targetCls, targetClassLoader, inst);

        return;
      }
    }

    throw new RuntimeException("Failed to find lass [" + className + "]");
  }

  private static void transform(Class<?> targetCls, ClassLoader targetClassLoader, Instrumentation inst) {
    AtmTransformer dt = new AtmTransformer(targetCls.getName(), targetClassLoader);
    inst.addTransformer(dt, true);

    try {
      inst.retransformClasses(targetCls);
    } catch (Exception ex) {
      throw new RuntimeException("Transform failed for: [" + targetCls.getName() + "]", ex);
    }
  }
}
