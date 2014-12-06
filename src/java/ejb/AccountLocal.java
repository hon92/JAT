/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import tables.Account;

/**
 *
 * @author Honza
 */
@Local
public interface AccountLocal
{

    public void insert(Account acc);

    public void update(Account acc);

    public void delete(Account acc);

    public Account findById(long id);

    public List<Account> selectAll();

    public List<Account> getAccountsFromUser(long id);

    public Account findByAccountName(Integer val);

}
