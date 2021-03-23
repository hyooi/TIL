package spring.dispatcherservlet.dao;

import java.util.List;
import spring.dispatcherservlet.model.User;

public interface UserDao {

  void save(User user);

  List<User> list();
}
