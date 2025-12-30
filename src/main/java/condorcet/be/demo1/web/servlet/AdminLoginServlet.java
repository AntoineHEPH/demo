package condorcet.be.demo1.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Créer la session
        HttpSession session = req.getSession();

        // Attribuer le rôle
        if (username.equals("admin") && password.equals("pass1234")) {
            session.setAttribute("userRole", "admin");
        } else {
            session.setAttribute("userRole", "user");
        }

        resp.sendRedirect(req.getContextPath() + "/admin.jsp");

    }
}
