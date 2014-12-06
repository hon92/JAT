/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import tables.SimpleTransaction;

/**
 *
 * @author Honza
 */
@Local
public interface SimpleTransactionLocal
{

    public void insert(SimpleTransaction st);

    public void update(SimpleTransaction st);

    public void delete(SimpleTransaction st);

    public List<SimpleTransaction> selectAll();

    public SimpleTransaction findById(long id);
}
