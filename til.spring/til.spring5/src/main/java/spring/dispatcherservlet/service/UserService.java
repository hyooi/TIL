package spring.dispatcherservlet.service;

import java.util.List;
import spring.dispatcherservlet.model.User;

public interface UserService {
  void save(User user);
  List<User> list();
}
