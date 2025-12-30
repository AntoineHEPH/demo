package condorcet.be.demo1.web.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

// Ce filtre protège l'accès à la page admin
@WebFilter("/admin.jsp")
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Permet d'utiliser les méthodes HTTP
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        // Récupérer la session existante
        HttpSession session = httpServletRequest.getSession(false);

        // Récupérer son rôle (admin)
        String userRole = (session != null) ? (String)session.getAttribute("useRole") : null;

        // Vérif du rôle
        if ("admin".equals(userRole)) {
            // On laisse passer
            chain.doFilter(request, response);
        } else {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/access-denied.jsp");
        }


    }
}
