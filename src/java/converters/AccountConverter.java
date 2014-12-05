/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import ejb.AccountLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import tables.Account;

/**
 *
 * @author Honza
 */
@FacesConverter(forClass = Account.class, value = "accountConverter")
public class AccountConverter implements Converter
{

    AccountLocal accountMapper = lookupAccountMapperLocal();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value)
    {
        if (value != null)
        {
            Account ac = accountMapper.findById(Long.parseLong(value));

            return ac;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value)
    {
        if (value != null)
        {
            return ((Account) (value)).getId().toString();
        }
        return "";
    }

    private AccountLocal lookupAccountMapperLocal()
    {
        try
        {
            Context c = new InitialContext();
            return (AccountLocal) c.lookup("java:global/JAT-Project/AccountMapper!ejb.AccountLocal");
        }
        catch (NamingException ne)
        {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
