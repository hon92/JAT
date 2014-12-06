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
import tables.PermanentTransaction;

/**
 *
 * @author Honza
 */
@Stateless
public class PermanentTransactionMapper implements PermanentTransactionLocal
{

    @PersistenceContext
    protected EntityManager em;

    @Override
    public void insert(PermanentTransaction pt)
    {
        em.persist(pt);
    }

    @Override
    public void update(PermanentTransaction pt)
    {
        em.merge(pt);
        em.flush();
    }

    @Override
    public void delete(PermanentTransaction pt)
    {
        em.remove(pt);
    }

    @Override
    public List<PermanentTransaction> selectAll()
    {
        return em.createQuery("SELECT pt FROM PermanentTransaction pt", PermanentTransaction.class).getResultList();
    }

    @Override
    public PermanentTransaction findById(long id)
    {
        return em.find(PermanentTransaction.class, id);
    }

}
