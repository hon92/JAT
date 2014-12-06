/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tables.SimpleTransaction;

/**
 *
 * @author Honza
 */
@Stateless
public class SimpleTransactionMapper implements SimpleTransactionLocal
{

    @PersistenceContext
    protected EntityManager em;

    @Override
    public void insert(SimpleTransaction st)
    {
        em.persist(st);
    }

    @Override
    public void update(SimpleTransaction st)
    {
        em.merge(st);
        em.flush();
    }

    @Override
    public void delete(SimpleTransaction st)
    {
        em.remove(st);
    }

    @Override
    public List<SimpleTransaction> selectAll()
    {
        return em.createQuery("SELECT st FROM SimpleTransaction st", SimpleTransaction.class).getResultList();
    }

    @Override
    public SimpleTransaction findById(long id)
    {
        return em.find(SimpleTransaction.class, id);
    }

}
