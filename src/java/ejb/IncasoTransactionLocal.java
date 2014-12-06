/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import tables.IncasoTransaction;

/**
 *
 * @author Honza
 */
@Local
public interface IncasoTransactionLocal
{

    public void insert(IncasoTransaction it);

    public void update(IncasoTransaction it);

    public void delete(IncasoTransaction it);

    public List<IncasoTransaction> selectAll();

    public IncasoTransaction findById(long id);
}
