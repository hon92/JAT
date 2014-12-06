package tables;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity

public class IncasoTransaction extends SimpleTransaction implements Serializable
{

    private String timeInterval;

    public IncasoTransaction()
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

}
