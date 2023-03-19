package web.project.service;

import web.project.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getUserById(Long id);
    void add(User user);
    void delete(Long id);
    void update(User user);
}