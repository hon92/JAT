package tables;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AccountTable")
@NamedQueries(
        {
            @NamedQuery(name = "Account.getAccountsFromUser", query = "SELECT a FROM Account a where a.owner.id = :id"),
            @NamedQuery(name = "Account.getAccountByAccountNumber", query = "SELECT a FROM Account a WHERE a.accountNumber= :accountNumber")

        })

public class Account implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    public User owner;

    @OneToOne
    public HistoryTransaction historyTransaction;

    private Integer actualBalance;
    private Integer accountNumber;
    private Integer normalBalance;
    private Date startDate;
    private Integer dayLimit;

    public Account()
    {
    }

    public User getOwner()
    {
        return owner;
    }

    public void setOwner(User owner)
    {
        this.owner = owner;
    }

    public HistoryTransaction getHistoryTransaction()
    {
        return historyTransaction;
    }

    public void setHistoryTransaction(HistoryTransaction historyTransaction)
    {
        this.historyTransaction = historyTransaction;
    }

    public Integer getActualBalance()
    {
        return this.actualBalance;
    }

    public void setActualBalance(Integer aActualBalance)
    {
        this.actualBalance = aActualBalance;
    }

    public Integer getAccountNumber()
    {
        return this.accountNumber;
    }

    public void setAccountNumber(Integer accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Integer getNormalBalance()
    {
        return this.normalBalance;
    }

    public void setNormalBalance(Integer aNormalBalance)
    {
        this.normalBalance = aNormalBalance;
    }

    public Date getStartDate()
    {
        return this.startDate;
    }

    public Integer getDayLimit()
    {
        return this.dayLimit;
    }

    public void setDayLimit(Integer aDayLimit)
    {
        this.dayLimit = aDayLimit;
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long aId)
    {
        this.id = aId;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj != null && obj instanceof Account)
        {
            return ((Account) obj).getId().equals(id);
        }
        return false;
    }

}
