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
import tables.IncasoTransaction;

/**
 *
 * @author Honza
 */
@Stateless
public class IncasoTransactionMapper implements IncasoTransactionLocal
{

    @PersistenceContext
    protected EntityManager em;

    @Override
    public void insert(IncasoTransaction it)
    {
        em.persist(it);
    }

    @Override
    public void update(IncasoTransaction it)
    {
        em.merge(it);
        em.flush();
    }

    @Override
    public void delete(IncasoTransaction it)
    {
        em.remove(it);
    }

    @Override
    public List<IncasoTransaction> selectAll()
    {
        return em.createQuery("SELECT it FROM IncasoTransaction it", IncasoTransaction.class).getResultList();
    }

    @Override
    public IncasoTransaction findById(long id)
    {
        return em.find(IncasoTransaction.class, id);
    }

}
