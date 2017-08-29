package ru.saydumarov.service;

import ru.saydumarov.model.StringQuery;
import ru.saydumarov.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public void updateUser(User user);
    public void removeUser(int id);
    public User getUserById(int id);
    public List<User> listUsers();
    public User getUserByEmail(StringQuery stringQuery);
}
