package ejb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tables.Account;

@Stateless
public class AccountMapper implements AccountLocal
{

    @PersistenceContext
    protected EntityManager em;

    @PostConstruct
    public void init()
    {

    }

    @Override
    public void insert(Account acc)
    {
        em.persist(acc);
    }

    @Override
    public void update(Account acc)
    {
        em.merge(acc);
        em.flush();
    }

    @Override
    public void delete(Account acc)
    {
        em.remove(acc);
    }

    @Override
    public Account findById(long id)
    {
        return (Account) em.find(Account.class, id);
    }

    @Override
    public List<Account> selectAll()
    {
        return em.createQuery("SELECT a FROM Account a", Account.class).getResultList();
    }

}
