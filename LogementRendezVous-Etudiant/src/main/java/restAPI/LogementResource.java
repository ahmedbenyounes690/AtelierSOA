package restAPI;

import entities.Logement;
import metiers.LogementBusiness;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/logements")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LogementResource {

    private LogementBusiness logementMetier = new LogementBusiness();

    @GET
    public List<Logement> getAllLogements() {
        return logementMetier.getLogements();
    }

    @POST
    public Response addLogement(Logement logement) {
        if(logementMetier.addLogement(logement)) {
            return Response.status(Response.Status.CREATED).entity(logement).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/{reference}")
    public Response getLogementByReference(@PathParam("reference") int reference) {
        Logement logement = logementMetier.getLogementsByReference(reference);
        if(logement != null) {
            return Response.ok(logement).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{reference}")
    public Response deleteLogement(@PathParam("reference") int reference) {
        if(logementMetier.deleteLogement(reference)) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/{reference}")
    public Response updateLogement(@PathParam("reference") int reference, Logement logement) {
        if(logementMetier.updateLogement(reference, logement)) {
            return Response.ok(logement).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}