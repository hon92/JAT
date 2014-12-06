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

    public String getTimeInterval()
    {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval)
    {
        this.timeInterval = timeInterval;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

}
