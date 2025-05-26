package restAPI;

import entities.RendezVous;
import metiers.RendezVousBusiness;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/rendezvous")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RendezVousResource {

    private RendezVousBusiness rendezVousMetier = new RendezVousBusiness();

    @GET
    public List<RendezVous> getAllRendezVous() {
        return rendezVousMetier.getListeRendezVous();
    }

    @POST
    public Response addRendezVous(RendezVous rendezVous) {
        if(rendezVousMetier.addRendezVous(rendezVous)) {
            return Response.status(Response.Status.CREATED).entity(rendezVous).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/logement/{reference}")
    public Response getRendezVousByLogement(@PathParam("reference") int reference) {
        List<RendezVous> rendezVous = rendezVousMetier.getListeRendezVousByLogementReference(reference);
        return Response.ok(rendezVous).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRendezVous(@PathParam("id") int id) {
        if(rendezVousMetier.deleteRendezVous(id)) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateRendezVous(@PathParam("id") int id, RendezVous rendezVous) {
        if(rendezVousMetier.updateRendezVous(id, rendezVous)) {
            return Response.ok(rendezVous).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}