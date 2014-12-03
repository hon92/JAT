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

    public String getInterval()
    {
        return this.timeInterval;
    }

    public void setInterval(String aInterval)
    {
        this.timeInterval = aInterval;
    }
}
