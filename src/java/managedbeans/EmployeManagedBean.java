/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import ejb.UserLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import tables.Employe;
import tables.User;

/**
 *
 * @author Honza
 */
@ManagedBean
public class EmployeManagedBean
{

    @ManagedProperty(value = "#{controlBean}")
    protected ControllerBean cb;
    @EJB
    protected UserLocal ul;

    private List<User> users = null;
    private Employe currentEmploye;
    private String search;
    private User editedUser = null;

    public UserLocal getUl()
    {
        return ul;
    }

    public Employe getCurrentEmploye()
    {
        return currentEmploye;
    }

    public void setCurrentEmploye(Employe currentEmploye)
    {
        this.currentEmploye = currentEmploye;
    }

    public void setUl(UserLocal ul)
    {
        this.ul = ul;
    }

    public List<User> getUsers()
    {
        if (users == null)
        {
            users = ul.selectAll();
        }
        return users;
    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }

    public ControllerBean getCb()
    {
        return cb;
    }

    public void setCb(ControllerBean cb)
    {
        this.cb = cb;
    }

    public String getSearch()
    {
        return search;
    }

    public void setSearch(String search)
    {
        this.search = search;
    }

    public User getEditedUser()
    {
        return editedUser;
    }

    public void setEditedUser(User editedUser)
    {
        this.editedUser = editedUser;
    }

    public void filter()
    {

        if (getUsers() != null)
        {
            List<User> toAdd = new ArrayList<>();
            if (search == null)
            {
                search = "";
            }
            for (User u : users)
            {
                if (u.getName().startsWith(search))
                {
                    toAdd.add(u);
                }
            }
            users = toAdd;
        }

    }

    public String edit(User u)
    {
        if (u != null)
        {
            editedUser = u;
            return "customerEdit";
        }
        return "";

    }

}
