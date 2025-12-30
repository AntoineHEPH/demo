package condorcet.be.demo1.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class BrawlStarsSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupérer la session existante, sinon null
        HttpSession session = req.getSession(false);

        boolean isLogIn = false;

        // Vérifier si l'utilisateur est "connecté" (si l'attribut brawler existe)
        if(session != null && session.getAttribute("brawler") != null) {
            isLogIn = true;
        }

        resp.setContentType("text/html;charset=UTF-8"); // Bonnes pratiques pour les accents

        try(PrintWriter out = resp.getWriter()) {
            out.println("<html>");
            out.println("<body>");

            if(isLogIn) {
                String brawler = (String) session.getAttribute("brawler");
                String mode = (String) session.getAttribute("mode");

                // --- RECUPERATION DES STATS ---
                // On récupère la map des stats
                Map<String, Integer> stats = (Map<String, Integer>) session.getAttribute("stats");
                int count = 0;
                // Sécurité : on vérifie que la map et le brawler existent
                if (stats != null && stats.containsKey(brawler)) {
                    count = stats.get(brawler);
                }
                // ------------------------------

                out.println("<h1>Bienvenue dans BrawlStars en mode " + mode + "</h1>");
                out.println("<p>Brawler actuel : <strong>" + brawler + "</strong></p>");

                // Affichage de la statistique demandée
                out.println("<h3>Vous avez joué " + count + " fois avec " + brawler + " !</h3>");

                out.println("<br/><a href='/brawlstars'>Changer de configuration</a>"); // Petit lien pour rejouer

            } else {
                // Formulaire d'entrée
                out.println("  <h1>Configuration de la partie</h1>");
                out.println("  <form method='POST' action='brawlstars'>"); // Chemin relatif plus sûr

                // BRAWLER
                out.println("    <label for='brawler'>Brawler :</label>");
                out.println("    <select name='brawler' id='brawler'>");
                out.println("      <option value='Shelly'>Shelly</option>");
                out.println("      <option value='Colt'>Colt</option>");
                out.println("      <option value='Spike'>Spike</option>");
                out.println("      <option value='Leon'>Leon</option>");
                out.println("      <option value='Mortis'>Mortis</option>");
                out.println("      <option value='Dynamike'>Dynamike</option>");
                out.println("      <option value='Poco'>Poco</option>");
                out.println("    </select>");
                out.println("    <br/>");

                // MODE (Attention: name='mode' pour correspondre au doPost)
                out.println("    <label for='mode'>Mode de jeu :</label>");
                out.println("    <select name='mode' id='mode'>");
                out.println("      <option value='Razzia de Gemmes'>Razzia de Gemmes</option>");
                out.println("      <option value='Brawl Ball'>Brawl Ball</option>");
                out.println("      <option value='Prime'>Prime</option>");
                out.println("      <option value='Braquage'>Braquage</option>");
                out.println("      <option value='Survivant (Solo)'>Survivant (Solo)</option>");
                out.println("      <option value='Zone Réservée'>Zone Réservée</option>");
                out.println("    </select>");
                out.println("    <br/><br/>");

                out.println("    <input type='submit' value='BRAWL !'>");
                out.println("  </form>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupération des paramètres du formulaire
        String brawler = req.getParameter("brawler");
        String mode = req.getParameter("mode");

        // Création ou récupération de la session (true = créer si n'existe pas)
        HttpSession session = req.getSession(true);

        // Sauvegarde des choix actuels
        session.setAttribute("brawler", brawler);
        session.setAttribute("mode", mode);

        // --- LOGIQUE DES STATISTIQUES ---

        // 1. Récupérer la Map existante dans la session
        Map<String, Integer> stats = (Map<String, Integer>) session.getAttribute("stats");

        // 2. Si elle n'existe pas encore (première fois), on la crée
        if (stats == null) {
            stats = new HashMap<>();
        }

        // 3. On met à jour le compteur pour le brawler choisi
        // getOrDefault permet de dire : "Prends la valeur actuelle, ou 0 si c'est vide"
        int currentCount = stats.getOrDefault(brawler, 0);
        stats.put(brawler, currentCount + 1);

        // 4. On remet la Map mise à jour dans la session
        session.setAttribute("stats", stats);

        // --------------------------------

        session.setMaxInactiveInterval(60 * 10); // 10 minutes

        // Redirection vers le doGet pour l'affichage
        resp.sendRedirect("brawlstars");
    }
}