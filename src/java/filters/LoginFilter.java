package filters;

import managedbeans.ControllerBean;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Honza
 */
public class LoginFilter implements Filter
{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest hsr = (HttpServletRequest) request;
        ControllerBean cb = (ControllerBean) hsr.getSession().getAttribute("controllerBean");
        HttpServletResponse hsres = (HttpServletResponse) response;

        String url = hsr.getRequestURI();
        String index = "/index.xhtml";
        String css = "css/default.css.xhtml";
        String layout = "css/cssLayout.css.xhtml";

        boolean page = !url.endsWith(index) && !url.endsWith(css) && !url.endsWith(layout);

        if (page && (cb == null || !cb.isIsLogged()))
        {
            hsres.sendRedirect(hsr.getContextPath() + "/index.xhtml");
        }
        else
        {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy()
    {
    }

}
