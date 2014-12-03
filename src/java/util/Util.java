/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Honza
 */
public class Util
{

    private static EntityManagerFactory FACTORY = null;
    private static EntityManager em = null;

    private Util()
    {
    }

    public static final EntityManagerFactory getEntityFactory()
    {
        if (FACTORY == null)
        {
            FACTORY = Persistence.createEntityManagerFactory("JPA");
        }
        return FACTORY;
    }

    public static EntityManager getEntityManager()
    {
        if (em == null)
        {
            em = getEntityFactory().createEntityManager();
        }
        return em;
    }

}
