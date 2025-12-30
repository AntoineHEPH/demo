package condorcet.be.demo1.web.api;

import condorcet.be.demo1.model.cinecondorcet.Realisator;
import condorcet.be.demo1.service.BusinessException;
import condorcet.be.demo1.service.RealisatorService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@RequestScoped
@Path("/realisators")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RealisatorRessource {

    @Inject
    private RealisatorService realisatorService;

    @GET
    public List<Realisator> findAll()
    {
        return realisatorService.findAll();
    }

    @POST
    public Response create(Realisator realisator)
    {
        System.out.println("Création d'un réalisateur...");
        
        try {
            realisatorService.create(realisator);
            System.out.println("Réalisateur créé");
            return Response.status(Response.Status.CREATED).entity(realisator).build();
        } catch (BusinessException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erreur serveur").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id)
    {
        try {
            Realisator realisator = realisatorService.findById(id);
            if (realisator == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Réalisateur non trouvé")
                        .build();
            }
            
            realisatorService.delete(realisator);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (BusinessException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erreur serveur").build();
        }
    }
}
