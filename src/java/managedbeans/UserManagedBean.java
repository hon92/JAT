/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import ejb.AccountLocal;
import ejb.IncasoTransactionLocal;
import ejb.PermanentTransactionLocal;
import ejb.SimpleTransactionLocal;
import ejb.UserLocal;
import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import tables.Account;
import tables.IncasoTransaction;
import tables.PermanentTransaction;
import tables.SimpleTransaction;

/**
 *
 * @author Honza
 */
@ManagedBean
@SessionScoped
public class UserManagedBean implements Serializable
{

    @ManagedProperty(value = "#{controllerBean}")
    protected ControllerBean controllerBean;

    @EJB
    protected UserLocal ul;

    @EJB
    protected AccountLocal al;

    @EJB
    protected SimpleTransactionLocal stl;

    @EJB
    protected PermanentTransactionLocal ptl;

    @EJB
    protected IncasoTransactionLocal itl;

    private List<Account> accounts = null;
    private Account activeAccount = null;
    private int filterType = 1;
    private List<SimpleTransaction> transactions = null;
    private SimpleTransaction newSimpleTransaction = null;
    private java.util.Date date;
    private SimpleTransaction selectedTransaction = null;
    private int trafficType = 1;

    public UserManagedBean()
    {
    }

    public void changeActiveAccount(Account acc)
    {

    }

    public List<Account> getAccounts()
    {
        List<Account> acc = al.getAccountsFromUser(controllerBean.getLoggedUser().getId());
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

    public java.util.Date getDate()
    {
        return date;
    }

    public void setDate(java.util.Date date)
    {
        this.date = date;
        if (newSimpleTransaction instanceof PermanentTransaction)
        {
            ((PermanentTransaction) newSimpleTransaction).setEndDate(new Date(date.toInstant().toEpochMilli()));
        }

        this.date = null;
    }

    public SimpleTransaction getSelectedTransaction()
    {
        return selectedTransaction;
    }

    public void setSelectedTransaction(SimpleTransaction selectedTransaction)
    {
        this.selectedTransaction = selectedTransaction;
    }

    public int getTrafficType()
    {
        return trafficType;
    }

    public void setTrafficType(int trafficType)
    {
        this.trafficType = trafficType;
    }

    public void filterTransactions()
    {
        if (transactions != null)
        {
            transactions.clear();
        }
        else
        {
            transactions = new ArrayList<>();
        }

        if (getActiveAccount() == null)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No active account"));
            return;
        }

        switch (filterType)
        {
            case 1:
                if (trafficType == 1)//odchozi
                {
                    transactions = stl.selectAllOutGoingTransaction(getActiveAccount().getHistoryTransaction());
                }
                else
                {
                    transactions = stl.selectAllIncomingTransaction(getActiveAccount().getAccountNumber());
                }
                break;
            case 2:
                transactions = new ArrayList<>(ptl.selectAll());
                break;
            case 3:
                transactions = new ArrayList<>(itl.selectAll());
                break;

        }

    }

    public AccountLocal getAl()
    {
        return al;
    }

    public String createTransaction()
    {

        if (activeAccount != null)
        {
            newSimpleTransaction.setCreationDate(new Date(Instant.now().toEpochMilli()));
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
    }

    public void initPT()
    {
        this.newSimpleTransaction = new PermanentTransaction();
    }

    public void initIT()
    {
        this.newSimpleTransaction = new IncasoTransaction();
    }

    public String showTransactionDetail(SimpleTransaction st)
    {
        selectedTransaction = st;
        return "transactionDetail.xhtml?faces-redirect=true";
    }

}
