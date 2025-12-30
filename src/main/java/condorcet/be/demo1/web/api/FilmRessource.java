package condorcet.be.demo1.web.api;

import java.util.List;
import condorcet.be.demo1.model.cinecondorcet.Film;
import condorcet.be.demo1.model.cinecondorcet.Realisator;
import condorcet.be.demo1.service.BusinessException;
import condorcet.be.demo1.service.FilmService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path("/films")
public class FilmRessource {

    @Inject
    private FilmService filmService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Film> findAll() {
        return filmService.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Film film) {
        System.out.println("Création d'un film...");

        if (film.getRealisator() == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Le film doit contenir un realisateur (id ou objet)")
                    .build();
        }

        Realisator r = film.getRealisator();
        if (r.getId() == null && (r.getName() == null || r.getName().isEmpty())) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Realisateur must have an id or a nom")
                    .build();
        }

        try {
            filmService.create(film);

            return Response.status(Response.Status.CREATED).entity(film).build();
        } catch (BusinessException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erreur serveur").build();
        }
    }
}