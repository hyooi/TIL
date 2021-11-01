package kello.ioc.beans;

import java.util.List;

public class ConstructorService {

  private final FactoryMethodDao factoryMethodDao;
  private final int count;
  private InstanceFactoryMethodDao instanceFactoryMethodDao;

  // 생성자 기반 종속성 주입
  public ConstructorService(FactoryMethodDao factoryMethodDao, int count) {
    this.factoryMethodDao = factoryMethodDao;
    this.count = count;
  }

  public void setInstanceFactoryMethodDao(InstanceFactoryMethodDao instanceFactoryMethodDao) {
    this.instanceFactoryMethodDao = instanceFactoryMethodDao;
  }

  public List<Integer> numbers() {
    return factoryMethodDao.numbers();
  }

  public int getCount() {
    return count;
  }
}
