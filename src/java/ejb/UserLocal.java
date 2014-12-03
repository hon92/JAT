/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import tables.User;

/**
 *
 * @author Honza
 */
@Local
public interface UserLocal
{

    public void insert(User u);

    public void update(User u);

    public User findById(long id);

    public List<User> selectAll();

    public void delete(User u);

    public User tryLogin(String name, String password);
}
