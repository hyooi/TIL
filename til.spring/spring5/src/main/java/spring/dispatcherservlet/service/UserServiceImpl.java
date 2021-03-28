package spring.dispatcherservlet.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dispatcherservlet.dao.UserDao;
import spring.dispatcherservlet.model.User;

@Service
public class UserServiceImpl implements UserService {

  private final UserDao userDao;

  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  @Transactional
  public void save(User user) {
    userDao.save(user);
  }

  @Override
  @Transactional(readOnly = true)
  public List<User> list() {
    return userDao.list();
  }
}
