package web.project.dao;

import org.springframework.stereotype.Repository;
import web.project.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDaoImp implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
    @Override
    public void add(User user){
        entityManager.persist(user);
    }
    @Override
    public void delete(Long id){
        entityManager.remove(entityManager.find(User.class,id));
    }
    @Override
    public User getUserById(Long id){
        return entityManager.find(User.class,id);
    }
    @Override
    public void update(User user){
        entityManager.merge(user);
    }

}