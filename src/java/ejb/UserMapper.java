package ejb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tables.User;

@Stateless
public class UserMapper implements UserLocal
{

    @PersistenceContext
    protected EntityManager em;

    @PostConstruct
    public void init()
    {

    }

    @Override
    public void insert(User u)
    {
        em.persist(u);
    }

    @Override
    public void update(User u)
    {
        em.merge(u);
        em.flush();
    }

    @Override
    public User findById(long id)
    {
        return (User) em.find(User.class, id);
    }

    @Override
    public List<User> selectAll()
    {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void delete(User u)
    {
        em.remove(u);
    }

    @Override
    public User tryLogin(String name, String password)
    {
        User u = null;

        try
        {
            TypedQuery<User> q = em.createNamedQuery("Employe.loginAndPassword", User.class);
            q.setParameter("login", name);
            q.setParameter("password", password);
            u = q.getSingleResult();
        }
        catch (Exception ex)
        {
            u = null;
        }

        return u;
    }

}
