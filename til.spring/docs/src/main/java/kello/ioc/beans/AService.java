package kello.ioc.beans;

import java.util.List;

public class AService {

  private final ADao aDao;
  private BDao bDao;

  public AService(ADao aDao) {
    this.aDao = aDao;
  }

  public void setbDao(BDao bDao) {
    this.bDao = bDao;
  }

  public List<Integer> numbers() {
    return aDao.numbers();
  }
}
