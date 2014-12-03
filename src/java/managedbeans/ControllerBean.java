/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import ejb.EmployeLocal;
import ejb.EmployeMapper;
import ejb.UserLocal;
import ejb.UserMapper;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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

    public ControllerBean()
    {
        el = new EmployeMapper();
        ul = new UserMapper();
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

        if (isAdmin)
        {
            Employe e = el.tryLogin(login, passWord);
            if (e != null)
            {
                isLogged = true;
                return "main.xhtml?faces-redirect=true";
            }

        }
        else
        {
            User u = ul.tryLogin(login, passWord);
            if (u != null)
            {
                isLogged = true;
                return "main.xhtml?faces-redirect=true";
            }
        }
        return "index.xhtml?faces-redirect=true";
    }

    public String logout()
    {
        isLogged = false;
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

}
