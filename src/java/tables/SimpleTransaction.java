package tables;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class SimpleTransaction implements Serializable
{

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    public HistoryTransaction historyTransaction;

    private Date creationDate;
    private Integer money;
    private Integer receiver;
    private String description;
    private String descriptionForReceiver;

    public SimpleTransaction()
    {
    }

//    public HistoryTransaction getHistoryTransaction()
//    {
//        return historyTransaction;
//    }
//
//    public void setHistoryTransaction(HistoryTransaction historyTransaction)
//    {
//        this.historyTransaction = historyTransaction;
//    }
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Date getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }

    public Integer getMoney()
    {
        return money;
    }

    public void setMoney(Integer money)
    {
        this.money = money;
    }

    public Integer getTo()
    {
        return receiver;
    }

    public void setTo(Integer to)
    {
        this.receiver = to;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescriptionForReceiver()
    {
        return descriptionForReceiver;
    }

    public void setDescriptionForReceiver(String descriptionForReceiver)
    {
        this.descriptionForReceiver = descriptionForReceiver;
    }

}
