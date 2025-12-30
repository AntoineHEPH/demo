package condorcet.be.demo1.web.servlet;

import condorcet.be.demo1.model.Character;
import condorcet.be.demo1.service.CharacterService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/lol-characters")
public class CharacterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer le résultat de la recherche
        String searchQuery = request.getParameter("q");

        // Récupérer l'instance du Singleton
        List<Character> characters;

        if (searchQuery != null && !searchQuery.isEmpty()) {
            characters = CharacterService.INSTANCE.search(searchQuery);
        } else {
            characters = CharacterService.INSTANCE.getAll();
        }

        // Envoyer à la rue
        request.setAttribute("characters", characters);
        request.getRequestDispatcher("/WEB-INF/jsp/characters.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupérer les informations du formulaire
        String name = req.getParameter("championName");
        String roles = req.getParameter("championRole");
        String skills = req.getParameter("championSkills");

        // Transformer les données skills
        List<String> skillsList = Arrays.asList(skills.split(", "));

        // Appel du service
        Character newChamp = new Character(name, roles, skillsList);
        CharacterService.INSTANCE.add(newChamp);

        resp.sendRedirect(req.getContextPath() + "/lol-characters");

    }
}
