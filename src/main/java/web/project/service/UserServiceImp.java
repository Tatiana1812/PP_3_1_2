package web.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.project.dao.UserDao;
import web.project.model.User;

import java.util.List;
@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getAll(){
        return userDao.getAll();
    }
    @Override
    @Transactional
    public void add(User user){userDao.add(user);}
    @Override
    @Transactional
    public void delete(Long id){userDao.delete(id);}
    @Override
    public User getUserById(Long id){return userDao.getUserById(id);}
    @Override
    @Transactional
    public void update(User user){userDao.update(user);}
}