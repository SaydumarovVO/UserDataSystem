package ru.saydumarov.dao;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.saydumarov.model.StringQuery;
import ru.saydumarov.model.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        String password = user.getPassword();
        String md5Hex = DigestUtils.md5Hex(password);
        user.setPassword(md5Hex);
        session.persist(user);
        logger.info("User successfully added. User info: " + user);
    }

    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User successfully updated. User info: " + user);
    }

    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);

        if (user!=null){
            session.delete(getUserById(id));
        }
        logger.info("User successfully removed. User info: " + user);
    }

    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        logger.info("User successfully created. User info: " + user);
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        return (List<User>) session.createQuery("from User").list();
    }

    @SuppressWarnings("unchecked")
    public User getUserByEmail(StringQuery stringQuery) {
        Session session = this.sessionFactory.getCurrentSession();
//        User user = session.load(User.class, query.);
        Query query = session.createQuery("from User where EMAIL = :paramName");
        query.setParameter("paramName", stringQuery.getQuery());
        List<User> userList = query.list();

        return userList.get(0);
    }
}
