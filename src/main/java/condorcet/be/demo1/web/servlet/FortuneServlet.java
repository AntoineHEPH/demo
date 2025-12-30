package condorcet.be.demo1.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FortuneServlet extends HttpServlet{

    private List<String> predictions = new ArrayList<String>();

    @Override
    public void init() throws ServletException {
        predictions.add("Je n'ai pas de bug dans mon code");
        predictions.add("Mon code build du premier coup");
        predictions.add("Noublie pas le poitn(virugule");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //Logique -> récup aléatoire une prédiction
        String randomPrediction = predictions.get(new Random().nextInt(predictions.size()));

        //Passer la donnée à la vue
        req.setAttribute("prediction", randomPrediction);

        //Déléguer l'affichage
        // sendRedirect() à peu près pareil que getRequestDispatcher
        req.getRequestDispatcher("/fortune.jsp").forward(req, resp);
    }
}
