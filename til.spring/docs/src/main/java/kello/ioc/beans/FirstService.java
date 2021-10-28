package kello.ioc.beans;

import java.util.List;

public class FirstService {

  private final FirstDao firstDao;
  private SecondDao secondDao;

  public FirstService(FirstDao firstDao) {
    this.firstDao = firstDao;
  }

  public void setSecondDao(SecondDao secondDao) {
    this.secondDao = secondDao;
  }

  public List<Integer> numbers() {
    return firstDao.numbers();
  }
}
