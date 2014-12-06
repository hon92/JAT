/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import ejb.AccountLocal;
import ejb.SimpleTransactionLocal;
import ejb.UserLocal;
import java.sql.Date;
import java.time.Instant;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import tables.Account;
import tables.SimpleTransaction;

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

    @EJB
    protected SimpleTransactionLocal stl;

    private List<Account> accounts = null;
    private Account activeAccount = null;
    private int filterType;
    private List<SimpleTransaction> transactions = null;
    private SimpleTransaction newSimpleTransaction = null;

    public UserManagedBean()
    {
    }

    public void changeActiveAccount(Account acc)
    {

    }

    public List<Account> getAccounts()
    {
        List<Account> acc = al.getAccountsFromUser(controllerBean.getLoggedUser().getId());

        if (activeAccount == null && !acc.isEmpty())
        {
            activeAccount = acc.get(0);
        }

        return acc;
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

    public int getFilterType()
    {
        return filterType;
    }

    public void setFilterType(int filterType)
    {
        this.filterType = filterType;
    }

    public List<SimpleTransaction> getTransactions()
    {
        return transactions;
    }

    public void setTransactions(List<SimpleTransaction> transactions)
    {
        this.transactions = transactions;
    }

    public SimpleTransaction getNewSimpleTransaction()
    {
        return newSimpleTransaction;
    }

    public void setNewSimpleTransaction(SimpleTransaction newSimpleTransaction)
    {
        this.newSimpleTransaction = newSimpleTransaction;
    }

    public void filterTransactions()
    {
        //System.out.println("dadassssssssssssssssssss" + filterType);
    }

    public AccountLocal getAl()
    {
        return al;
    }

    public String createSimpleTransaction()
    {

        if (activeAccount != null)
        {
            newSimpleTransaction.setCreationDate(new Date(Instant.now().getEpochSecond()));
            newSimpleTransaction.setHistoryTransaction(activeAccount.getHistoryTransaction());

            stl.insert(newSimpleTransaction);
            Account receiver = al.findByAccountName(newSimpleTransaction.getTo());
            Integer recold = receiver.getActualBalance();
            receiver.setActualBalance(recold + newSimpleTransaction.getMoney());

            al.update(receiver);

            Integer oldbalance = activeAccount.getActualBalance();
            activeAccount.setActualBalance(oldbalance - newSimpleTransaction.getMoney());
            al.update(activeAccount);
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You have no account"));
        }
        return "accountInfo.xhtml?faces-redirect=true";
    }

    public void initST()
    {
        this.newSimpleTransaction = new SimpleTransaction();
        getAccounts();
    }

}
