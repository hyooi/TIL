package kello.ioc.beans;

public class ServiceLocator {
  private static final InstanceFactoryMethodDao instanceFactoryMethodDao =
      new InstanceFactoryMethodDao();

  public InstanceFactoryMethodDao instanceFactoryMethodDao() {
    return instanceFactoryMethodDao;
  }
}
