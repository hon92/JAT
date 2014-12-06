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
@FacesValidator(value = "moneyValidator")
public class MoneyValidator implements Validator
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
                Integer balance = ac.getActualBalance();

                if (val > balance)
                {
                    throw new ValidatorException(new FacesMessage("You dont have " + val + " on your account, you have only " + balance));
                }

            }
        }
    }

}
