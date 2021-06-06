import java.io.IOException;

public class Launcher {

  public static void main(String[] args) throws InterruptedException {
    if("StartMyAtmApplication".equals(args[0])) {
      new MyAtmApplication().run(args);
    } else if("LoadAgent".equals(args[0])) {
      new AgentLoader().run(args);
    }
  }
}
