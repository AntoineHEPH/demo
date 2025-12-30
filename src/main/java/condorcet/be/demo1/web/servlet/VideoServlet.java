package condorcet.be.demo1.web.servlet;
import condorcet.be.demo1.model.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/videos")
public class VideoServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Video> someVideos = new ArrayList<>();
        someVideos.add(new Video(
                "Le complot le plus grave de la tech française",
                "L'histoire secrète du fleuron français assassiné de l'intérieur.",
                "https://www.youtube.com/watch?v=2wMxldl3Alk"
        ));

        someVideos.add(new Video(
                "La vidéo de dingue !",
                "Et ça, c'est la description.",
                "https://www.youtube.com/watch?v=ag6-52_1SDA"
        ));

        req.setAttribute("videos", someVideos);
        req.getRequestDispatcher("/WEB-INF/jsp/video.jsp").forward(req, resp);
    }
}
