package util;

import java.sql.Date;
import tables.IncasoTransaction;
import tables.PermanentTransaction;
import tables.SimpleTransaction;

public class TransactionFactory
{

    public SimpleTransaction createSimpleCommand(Integer aMoney, Integer aAcc, String aDescription, String aDescriptionForReceiver)
    {
        throw new UnsupportedOperationException();
    }

    public PermanentTransaction createPermanentCommand(Integer aMoney, Integer aAcc, String aInterval, Date aEndDate, String aDescription, String aDescriptionForReceiver)
    {
        throw new UnsupportedOperationException();
    }

    public IncasoTransaction createIncasoCommand(Integer aMoney, Integer aAcc, String aInterval, String aDescription, String aDescriptionForReceiver)
    {
        throw new UnsupportedOperationException();
    }
}
