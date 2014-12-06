/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import tables.PermanentTransaction;

/**
 *
 * @author Honza
 */
@Local
public interface PermanentTransactionLocal
{

    public void insert(PermanentTransaction pt);

    public void update(PermanentTransaction pt);

    public void delete(PermanentTransaction pt);

    public List<PermanentTransaction> selectAll();

    public PermanentTransaction findById(long id);
}
