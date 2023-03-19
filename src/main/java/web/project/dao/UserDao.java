package web.project.dao;


import web.project.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    User getUserById(Long id);
    void add(User user);
    void delete(Long id);
    void update(User user);
}
