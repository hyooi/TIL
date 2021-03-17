package spring.dispatcherservlet.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import spring.dispatcherservlet.model.User;

@Repository
public class UserDaoImpl implements UserDao {

  private final SessionFactory sessionFactory;

  public UserDaoImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void save(User user) {
    sessionFactory.getCurrentSession().save(user);
  }

  @Override
  public List<User> list() {
    Query query = sessionFactory.getCurrentSession().createQuery("from User");
    return query.getResultList();
  }
}
