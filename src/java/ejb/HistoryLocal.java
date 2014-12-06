/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import tables.HistoryTransaction;

/**
 *
 * @author Honza
 */
@Local
public interface HistoryLocal
{

    public void insert(HistoryTransaction ht);

    public void update(HistoryTransaction ht);

    public void delete(HistoryTransaction ht);

    public HistoryTransaction findById(long id);

    public List<HistoryTransaction> selectAll();

}
