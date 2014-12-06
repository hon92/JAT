package ejb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

    @Override
    public List<Account> getAccountsFromUser(long id)
    {
        TypedQuery<Account> acc = em.createNamedQuery("Account.getAccountsFromUser", Account.class);
        acc.setParameter("id", id);
        return acc.getResultList();
    }

    @Override
    public Account findByAccountName(Integer val)
    {
        TypedQuery<Account> q = em.createNamedQuery("Account.getAccountByAccountNumber", Account.class);
        q.setParameter("accountNumber", val);
        List<Account> accs = q.getResultList();

        return accs.size() == 0 ? null : accs.get(0);
    }

}
