package kello.ioc.beans;

import java.util.List;

public class ConstructorService {

  private final FactoryMethodDao factoryMethodDao;
  private InstanceFactoryMethodDao instanceFactoryMethodDao;

  public ConstructorService(FactoryMethodDao factoryMethodDao) {
    this.factoryMethodDao = factoryMethodDao;
  }

  public void setInstanceFactoryMethodDao(InstanceFactoryMethodDao instanceFactoryMethodDao) {
    this.instanceFactoryMethodDao = instanceFactoryMethodDao;
  }

  public List<Integer> numbers() {
    return factoryMethodDao.numbers();
  }
}
