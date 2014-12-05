/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import ejb.AccountLocal;
import ejb.UserLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import tables.Account;

/**
 *
 * @author Honza
 */
@ManagedBean
@SessionScoped
public class UserManagedBean
{

    @ManagedProperty(value = "#{controllerBean}")
    protected ControllerBean controllerBean;

    @EJB
    protected UserLocal ul;

    @EJB
    protected AccountLocal al;

    private List<Account> accounts = null;
    private Account activeAccount = null;

    public UserManagedBean()
    {
    }

    public void changeActiveAccount(Account acc)
    {

    }

    public List<Account> getAccounts()
    {
        return al.getAccountsFromUser(controllerBean.getLoggedUser().getId());
    }

    public void setAccounts(List<Account> accounts)
    {
        this.accounts = accounts;
    }

    public Account getActiveAccount()
    {
        return activeAccount;
    }

    public void setActiveAccount(Account activeAccount)
    {
        this.activeAccount = activeAccount;
    }

    public ControllerBean getControllerBean()
    {
        return controllerBean;
    }

    public void setControllerBean(ControllerBean controllerBean)
    {
        this.controllerBean = controllerBean;
    }

}
