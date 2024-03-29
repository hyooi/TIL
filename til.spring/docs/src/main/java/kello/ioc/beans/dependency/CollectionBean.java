package kello.ioc.beans.dependency;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionBean {
  private List<String> list;
  private Map<String, String> map;
  private Set<String> set;


  public void setList(List<String> list) {
    this.list = list;
  }

  public void setMap(Map<String, String> map) {
    this.map = map;
  }

  public void setSet(Set<String> set) {
    this.set = set;
  }

  public List<String> getList() {
    return list;
  }

  public Map<String, String> getMap() {
    return map;
  }

  public Set<String> getSet() {
    return set;
  }
}
