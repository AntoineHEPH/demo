package condorcet.be.demo1.web.servlet;

import condorcet.be.demo1.model.Creator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class CreatorsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //Créer liste ytbers
        List<Creator> creatorsList = List.of(
                new Creator("Squeezie", 18_000_000),
                new Creator("Amixem", 8_000_000),
                new Creator("Maxime", 5_000_000)

        );

        request.setAttribute("creators", creatorsList);
        request.setAttribute("title", "Top youtubers fancophones");

        request.getRequestDispatcher("creator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
