import com.sun.tools.attach.VirtualMachine;
import java.io.File;
import java.util.Optional;

public class AgentLoader {
  public void run(String[] args) {
    String agentFilePath = args[1];
    String applicationName = "MyAtmApplication";

    Optional<String> jvmProcessOpt = Optional.ofNullable(VirtualMachine.list()
    .stream()
    .filter(jvm -> {
      System.out.println("jvm : " + jvm.displayName());
      return jvm.displayName().contains(applicationName);
    })
    .findFirst().get().id());

    if(jvmProcessOpt.isEmpty()) {
      System.out.println("Target Application not found");
      return;
    }

    File agentFile = new File(agentFilePath);
    try {
      String jvmPid = jvmProcessOpt.get();
      System.out.println("Attaching to target JVM with PID: " + jvmPid);

      VirtualMachine jvm = VirtualMachine.attach(jvmPid);
      jvm.loadAgent(agentFile.getCanonicalFile().getAbsolutePath());
      jvm.detach();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
