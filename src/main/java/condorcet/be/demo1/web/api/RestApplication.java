package condorcet.be.demo1.web.api;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application; // <--- ATTENTION : C'est le seul changement important

@ApplicationPath("/api")
public class RestApplication extends Application {
    // C'est tout ! On laisse la classe vide.
}