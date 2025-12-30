package condorcet.be.demo1.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ChampionInfoServlet extends HttpServlet {
    // Variables pour stocker la config en mémoire
    private String name;
    private String role;
    private String difficulty;

    @Override
    public void init() throws ServletException {
        // Utilisation du ServletConfig avec getInitParameter()
        this.name = getInitParameter("nomChampion");
        this.role = getInitParameter("roleChampion");
        this.difficulty = getInitParameter("difficulteChampion");

        // Bonne pratique ; vérifier si la config existe
        if (this.name == null || this.role == null || this.difficulty == null) {
            throw new ServletException("Champion nom ou role diff is null.");
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body>");
            out.println("<h1>Champion Info</h1>");
            out.println("<body><html>");
        }
    }
}
