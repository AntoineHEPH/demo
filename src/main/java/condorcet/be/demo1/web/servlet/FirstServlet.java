package condorcet.be.demo1.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "firstServlet", value = "/first-servlet")
public class FirstServlet extends HttpServlet {

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
