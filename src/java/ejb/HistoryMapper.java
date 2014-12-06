/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tables.HistoryTransaction;

/**
 *
 * @author Honza
 */
@Stateless
public class HistoryMapper implements HistoryLocal
{

    @PersistenceContext
    protected EntityManager em;

    @PostConstruct
    public void init()
    {

    }

    @Override
    public void insert(HistoryTransaction ht)
    {
        em.persist(ht);
    }

    @Override
    public void update(HistoryTransaction ht)
    {
        em.merge(ht);
        em.flush();
    }

    @Override
    public void delete(HistoryTransaction ht)
    {
        em.remove(ht);
    }

    @Override
    public HistoryTransaction findById(long id)
    {
        return (HistoryTransaction) em.find(HistoryTransaction.class, id);
    }

    @Override
    public List<HistoryTransaction> selectAll()
    {
        return em.createQuery("SELECT t FROM HistoryTransaction t", HistoryTransaction.class).getResultList();
    }

}
