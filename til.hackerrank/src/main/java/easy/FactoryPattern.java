package easy;

import java.io.Serial;
import java.util.Collection;
import java.util.Scanner;

public class FactoryPattern {
  public static void main(String[] args){
    Do_Not_Terminate.forbidExit();

    try{

      Scanner sc=new Scanner(System.in);
      //creating the factory
      FoodFactory foodFactory = new FoodFactory();

      //factory instantiates an object
      Food food = foodFactory.getFood(sc.nextLine());


      System.out.println("The factory returned "+food.getClass());
      System.out.println(food.getType());
    }
    catch (Do_Not_Terminate.ExitTrappedException e) {
      System.out.println("Unsuccessful Termination!!");
    }
  }
}
interface Food {
  String getType();
}
class Pizza implements Food {
  public String getType() {
    return "Someone ordered a Fast Food!";
  }
}

class Cake implements Food {

  public String getType() {
    return "Someone ordered a Dessert!";
  }
}
class FoodFactory {
  public Food getFood(String order) {
    return switch (order) {
      case "cake" -> new Cake();
      case "pizza" -> new Pizza();
      default -> null;
    };

  }
}
class Do_Not_Terminate {

  public static class ExitTrappedException extends SecurityException {

    @Serial
    private static final long serialVersionUID = 1L;
  }

  public static void forbidExit() {
    final SecurityManager securityManager = new SecurityManager() {
      public void checkPermission(Permission permission) {
        if (permission.getName().contains("exitVM")) {
          throw new ExitTrappedException();
        }
      }
    };
    System.setSecurityManager(securityManager);
  }
}

class Permission {

  public Collection<Object> getName() {
    return null;
  }
}