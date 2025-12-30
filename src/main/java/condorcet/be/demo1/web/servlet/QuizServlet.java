package condorcet.be.demo1.web.servlet;

import condorcet.be.demo1.model.Question;
import condorcet.be.demo1.service.QuizService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//@WebServlet("/quiz")
//public class QuizServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // Charge les questions et affiche la page
//        req.setAttribute("questions", QuizService.INSTANCE.getQuestions());
//        req.getRequestDispatcher("/WEB-INF/jsp/quiz.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Map<Integer, Boolean> results = new HashMap<>(); // Renommé 'results' pour coller au JSP
//        int score = 0;
//
//        for (Question question : QuizService.INSTANCE.getQuestions()) {
//            // CORRECTION ICI : Utiliser "_" comme dans le JSP (name="question_${id}")
//            // Attention: Assurez-vous d'utiliser getId() si vous avez converti Question en classe standard
//            String paramName = "question_" + question.getId();
//            String selectedValue = req.getParameter(paramName);
//
//            if (selectedValue != null) {
//                try {
//                    int selectedAnswer = Integer.parseInt(selectedValue);
//                    // Utilisation de getId()
//                    boolean isCorrect = QuizService.INSTANCE.checkAnswer(question.getId(), selectedAnswer);
//
//                    results.put(question.getId(), isCorrect);
//                    if (isCorrect) {
//                        score++;
//                    }
//                } catch (NumberFormatException e) {
//                    // Sécurité au cas où la valeur n'est pas un nombre
//                    results.put(question.getId(), false);
//                }
//            } else {
//                // Pas de réponse cochée
//                results.put(question.getId(), false);
//            }
//        }
//
//        // On renvoie les données à la vue
//        req.setAttribute("score", score);
//        req.setAttribute("questions", QuizService.INSTANCE.getQuestions());
//        req.setAttribute("results", results); // Le JSP attend "results"
//        req.setAttribute("finished", true);
//
//        req.getRequestDispatcher("/WEB-INF/jsp/quiz.jsp").forward(req, resp);
//    }
//}