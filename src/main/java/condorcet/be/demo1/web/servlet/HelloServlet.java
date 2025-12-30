package condorcet.be.demo1.web.servlet;

import java.io.*;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    public void destroy() {
    }
}