package kello.ioc.beans;

import java.util.Arrays;
import java.util.List;

public class FactoryMethodDao {
  private static final FactoryMethodDao FACTORY_METHOD_DAO = new FactoryMethodDao();
  private FactoryMethodDao() {}

  public static FactoryMethodDao instance() {
    return FACTORY_METHOD_DAO;
  }

  public List<Integer> numbers() {
    return Arrays.asList(1,2,3,4,5);
  }
}
