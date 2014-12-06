/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import managedbeans.UserManagedBean;
import tables.Account;

/**
 *
 * @author Honza
 */
@FacesValidator(value = "accountValidator")
public class AccountValidator implements Validator
{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException
    {
        UserManagedBean umb = (UserManagedBean) component.getValueExpression("userBean").getValue(context.getELContext());

        if (value != null)
        {
            if (value instanceof Long)
            {
                Long val = (Long) value;
                Account ac = umb.getActiveAccount();

                if (val.toString().length() != 10)
                {
                    throw new ValidatorException(new FacesMessage("Account lenght is not 10"));
                }
                if (ac.getAccountNumber().equals(val))
                {
                    throw new ValidatorException(new FacesMessage("You cant send money on current account"));
                }

                Account ra = umb.getAl().findByAccountName(val.intValue());
                if (ra == null)
                {
                    throw new ValidatorException(new FacesMessage("Receiver account not exist"));
                }

            }
        }
    }

}
