package ru.saydumarov.service;

import ru.saydumarov.dao.UserDao;
import ru.saydumarov.model.StringQuery;
import ru.saydumarov.model.User;

import javax.transaction.Transactional;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Transactional
    public void removeUser(int id) {
        this.userDao.removeUser(id);
    }

    @Transactional
    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    @Transactional
    public List<User> listUsers() {
        return this.userDao.listUsers();
    }

    @Transactional
    public User getUserByEmail(StringQuery stringQuery){
        return this.userDao.getUserByEmail(stringQuery);
    }
}
