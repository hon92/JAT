package ejb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tables.Employe;

@Stateless
public class EmployeMapper implements EmployeLocal
{

    @PersistenceContext
    protected EntityManager em;

    @PostConstruct
    public void init()
    {

    }

    @Override
    public void insert(Employe emp)
    {
        em.persist(emp);
    }

    @Override
    public Employe tryLogin(String name, String password)
    {
        Employe e = null;

        try
        {
            TypedQuery<Employe> q = em.createNamedQuery("Employe.loginAndPassword", Employe.class);
            q.setParameter("login", name);
            q.setParameter("password", password);
            e = q.getSingleResult();
        }
        catch (Exception ex)
        {
            e = null;
        }

        return e;
    }

    @Override
    public void update(Employe emp)
    {
        em.merge(emp);
        em.flush();
    }

    @Override
    public Employe findById(long id)
    {
        return (Employe) em.find(Employe.class, id);
    }

    @Override
    public List<Employe> selectAll()
    {
        return em.createQuery("SELECT e FROM Employe e", Employe.class).getResultList();
    }

    @Override
    public void delete(Employe emp)
    {
        em.remove(emp);
    }
}
