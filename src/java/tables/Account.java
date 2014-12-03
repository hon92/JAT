package tables;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AccountTable")

public class Account implements Serializable
{

    @Id
    @GeneratedValue
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

    public boolean payNow(Integer aMoney, Integer aAcc, String aDesc, String aDescToReceiver)
    {
        throw new UnsupportedOperationException();
    }

    public boolean payIncaso(Integer aMoney, Integer aAcc, String aInterval, String aDesc)
    {
        throw new UnsupportedOperationException();
    }

    public boolean payPermanent(Integer aMoney, Integer aAcc, String aInterval, String aDesc, String aDescToReceiver)
    {
        throw new UnsupportedOperationException();
    }

    public long getId()
    {
        return this.id;
    }

    public void setId(long aId)
    {
        this.id = aId;
    }
}
