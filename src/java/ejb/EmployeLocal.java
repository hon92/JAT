/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import tables.Employe;

/**
 *
 * @author Honza
 */
@Local
public interface EmployeLocal
{

    public void insert(Employe emp);

    public Employe tryLogin(String name, String password);

    public void update(Employe emp);

    public Employe findById(long emp);

    public List<Employe> selectAll();

    public void delete(Employe emp);
}
