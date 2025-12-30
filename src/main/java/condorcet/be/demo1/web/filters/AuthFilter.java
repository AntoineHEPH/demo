package condorcet.be.demo1.web.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/profil.jsp")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession userSession = httpRequest.getSession(false);

        boolean isLoggedIn = (userSession != null && userSession.getAttribute("username") != null);

        if(isLoggedIn){
            chain.doFilter(request, response);
        } else
        {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/WEB-INF/jsp/login.jsp?error=access_denied");
        }
    }
}