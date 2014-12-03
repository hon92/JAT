package tables;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;

@Entity

public class PermanentTransaction extends SimpleTransaction implements Serializable
{

    private String timeInterval;
    private Date endDate;

    public PermanentTransaction()
    {
    }

    public String getInterval()
    {
        return this.timeInterval;
    }

    public void setInterval(String aInterval)
    {
        this.timeInterval = aInterval;
    }

    public Date getEndDate()
    {
        return this.endDate;
    }

    public void setEndDate(Date aEndDate)
    {
        this.endDate = aEndDate;
    }
}
