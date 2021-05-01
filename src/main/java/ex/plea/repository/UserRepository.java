package ex.plea.repository;

import ex.plea.component.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(User user){
        em.persist(user);
    }
    
    public User findOne(Long id)
    {
        return em.find(User.class, id);
        
    }
    public User findByUsername(String username)
    {
        return em.createQuery("select u from User u where u.username = :username", User.class).setParameter("username", username).getSingleResult();
    }
}
