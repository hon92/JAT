/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import ejb.EmployeLocal;
import ejb.UserLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import tables.Employe;
import tables.User;

/**
 *
 * @author Honza
 */
@ManagedBean
@SessionScoped
public class ControllerBean implements Serializable
{

    @EJB
    private EmployeLocal el;

    @EJB
    private UserLocal ul;

    private boolean isLogged;
    private String login;
    private String passWord;
    private boolean isAdmin;
    private Employe loggedEmploye;
    private User loggedUser;

    public ControllerBean()
    {

    }

    public boolean isIsLogged()
    {
        return isLogged;
    }

    public void setIsLogged(boolean isLogged)
    {
        this.isLogged = isLogged;
    }

    public String login()
    {
        if (el.selectAll().size() == 0)
        {
            Employe rootEmploye = new Employe();
            rootEmploye.setName("root");
            rootEmploye.setPassWord("root");
            el.insert(rootEmploye);
        }
        if (isAdmin)
        {
            Employe e = el.tryLogin(login, passWord);
            if (e != null)
            {
                isLogged = true;
                loggedEmploye = e;
                return "main.xhtml?faces-redirect=true";
            }

        }
        else
        {
            User u = ul.tryLogin(login, passWord);
            if (u != null)
            {
                isLogged = true;
                loggedUser = u;
                return "main.xhtml?faces-redirect=true";
            }
        }
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, new FacesMessage("Wrong login or password"));
        loggedEmploye = null;
        loggedUser = null;
        isAdmin = false;
        isLogged = false;
        //return "index.xhtml?faces-redirect=true";
        return "";
    }

    public String logout()
    {
        isLogged = false;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml?faces-redirect=true";
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassWord()
    {
        return passWord;
    }

    public void setPassWord(String passWord)
    {
        this.passWord = passWord;
    }

    public boolean isIsAdmin()
    {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin)
    {
        this.isAdmin = isAdmin;
    }

    public EmployeLocal getEl()
    {
        return el;
    }

    public void setEl(EmployeLocal el)
    {
        this.el = el;
    }

    public UserLocal getUl()
    {
        return ul;
    }

    public void setUl(UserLocal ul)
    {
        this.ul = ul;
    }

    public Employe getLoggedEmploye()
    {
        return loggedEmploye;
    }

    public void setLoggedEmploye(Employe loggedEmploye)
    {
        this.loggedEmploye = loggedEmploye;
    }

    public User getLoggedUser()
    {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser)
    {
        this.loggedUser = loggedUser;
    }

    public String getLoginName()
    {
        if (isAdmin)
        {
            return loggedEmploye.getName() + "(admin)";
        }
        else
        {
            return loggedUser.getName();
        }
    }

}
