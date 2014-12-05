/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import ejb.AccountLocal;
import ejb.UserLocal;
import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import tables.Account;
import tables.Employe;
import tables.User;

/**
 *
 * @author Honza
 */
@ManagedBean
@SessionScoped
public class EmployeManagedBean implements Serializable
{

    @ManagedProperty(value = "#{controlBean}")
    protected ControllerBean controlBean;
    @EJB
    protected UserLocal ul;
    @EJB
    protected AccountLocal al;

    private List<User> users = null;
    private List<User> filteredUsers = null;
    private Employe currentEmploye;
    private String search;
    private User editedUser = null;
    private Account account;
    private List<Account> selectedAccounts = null;

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
        if (search != null && search.length() > 0)
        {
            users = filteredUsers;
        }
        else
        {
            users = ul.selectAll();
        }

        return users;
    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }

    public ControllerBean getControlBean()
    {
        return controlBean;
    }

    public void setControlBean(ControllerBean controlBean)
    {
        this.controlBean = controlBean;
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

    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account account)
    {
        this.account = account;
    }

    public List<Account> getSelectedAccounts()
    {
        return selectedAccounts;
    }

    public void setSelectedAccounts(List<Account> selectedAccounts)
    {
        this.selectedAccounts = selectedAccounts;
    }

    public void filter()
    {
        filteredUsers = ul.selectAllWithName(search);
    }

    public String edit(User u)
    {
        if (u != null)
        {
            editedUser = u;
            return "customerEdit?faces-redirect=true";
        }
        return "";

    }

    public String save()
    {
        if (editedUser != null)
        {
            ul.update(editedUser);
            editedUser = null;

            return "customers?faces-redirect=true";
        }
        return "";
    }

    public String createUser()
    {
        editedUser = new User();
        return "customerEdit?faces-redirect=true";
    }

    public String createAccount(User u)
    {
        editedUser = u;
        account = new Account();
        return "createNewAccount?faces-redirect=true";
    }

    public String addAccount()
    {
        if (account != null)
        {
            account.setOwner(editedUser);
            account.setActualBalance(0);
            account.setNormalBalance(0);
            account.setStartDate(new Date(Instant.now().toEpochMilli()));
            al.insert(account);
        }
        return "customers?faces-redirect=true";
    }

    public String showAccounts(User u)
    {
        if (u != null)
        {
            selectedAccounts = al.getAccountsFromUser(u.getId());
            return "accountsInfo?faces-redirect=true";
        }
        return "customers?faces-redirect=true";
    }
}
