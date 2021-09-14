package main.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "SecurityFilter", urlPatterns = {"*"})
public class SecurityFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void  doFilter(ServletRequest request, ServletResponse response,
                          FilterChain chain){
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;

            if (!req.getRequestURI().contains("/login") && req.getSession().getAttribute("loggedUser") == null) {
                res.sendRedirect("login");
            } else {
                chain.doFilter(request, response);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}