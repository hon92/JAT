package tables;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HistoryTransactionTable")

public class HistoryTransaction implements Serializable
{

    @Id
    @GeneratedValue
    private Long id;
    private Integer numberOfResults;

    @OneToOne(mappedBy = "historyTransaction")
    public Account account;

    @OneToMany(mappedBy = "historyTransaction")
    public List<SimpleTransaction> transactions;

    public HistoryTransaction()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account account)
    {
        this.account = account;
    }

    public List<SimpleTransaction> getTransactions()
    {
        return transactions;
    }

    public void setTransactions(List<SimpleTransaction> transactions)
    {
        this.transactions = transactions;
    }

    public List<SimpleTransaction> getCommandFrom(Date date)
    {
        throw new UnsupportedOperationException();
    }

    public Integer getNumberOfResults()
    {
        return this.numberOfResults;
    }

    public void setNumberOfResults(Integer aNumberOfResults)
    {
        this.numberOfResults = aNumberOfResults;
    }

    public void addCommand(SimpleTransaction aNewCommand)
    {
        throw new UnsupportedOperationException();
    }

    public void clearHistory()
    {
        throw new UnsupportedOperationException();
    }

    public void removeCommand(SimpleTransaction aCommandToRemove)
    {
        throw new UnsupportedOperationException();
    }
}
