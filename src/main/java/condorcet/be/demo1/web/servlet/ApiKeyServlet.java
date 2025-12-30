package condorcet.be.demo1.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "apiKeyServlet", value = "/api-key-servlet")
public class ApiKeyServlet extends HttpServlet {

    private String apiKey;

    @Override
    public void init() throws ServletException {
        apiKey = getInitParameter("apiKey");

        if (apiKey == null || apiKey.isEmpty()) {
            throw new ServletException(
                    "Le paramètre d'init 'apiKey' est manquant ou vide. " +
                            "Le servlet " + getServletName() + " ne peut pas démarrer."
            );
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.write("<html><head><title>Bienvenue</title></head>"
                + "<body><h1>Bienvenue</h1>"
                + "<p>Bonjour ");
        if (name != null && name.length() > 0)
            out.write(name);
        else
            out.write("cher inconnu");
        out.write("</p></body></html>");
    }
}
