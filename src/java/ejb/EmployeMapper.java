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
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employe findById(long emp)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Employe> selectAll()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Employe emp)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
