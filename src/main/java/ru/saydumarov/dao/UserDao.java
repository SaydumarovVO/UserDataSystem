package ru.saydumarov.dao;

import ru.saydumarov.model.StringQuery;
import ru.saydumarov.model.User;

import java.util.List;

public interface UserDao {
    public void addUser(User book);
    public void updateUser(User book);
    public void removeUser(int id);
    public User getUserById(int id);
    public User getUserByEmail(StringQuery stringQuery);
    public List<User> listUsers();
}
