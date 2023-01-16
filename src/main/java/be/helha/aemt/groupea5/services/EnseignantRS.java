package be.helha.aemt.groupea5.services;

import java.util.List;

import be.helha.aemt.groupea5.dao.EnseignantDAO;
import be.helha.aemt.groupea5.entities.Enseignant;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Stateless
@Path("/enseignants")
public class EnseignantRS {
	
	@EJB
	private EnseignantDAO dao;
	
	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public  Response findAll() {
		List<Enseignant> result = dao.findAll();
		if (result==null) {
			//autre réponse
		}
		return Response.status(Status.OK).entity(result).build();
	}
	
	//Faire l'ajout via postman
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response add(Enseignant e) {
		Enseignant result = dao.add(e);
		return Response.status(Status.CREATED).entity(result).build();
	}
	
	//Faire le delete via postman
	@DELETE
	@Path("/delete/{email}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response delete(@PathParam("email")String email) {
		Enseignant result = dao.delete(new Enseignant(null, null, email, null, null));
		return Response.status(Status.NO_CONTENT).entity(result).build();
	}
	
	//Faire l'update via postman
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response update(Enseignant e) {
		Enseignant result = dao.update(e);
		return Response.status(Status.NO_CONTENT).entity(result).build();
	}
	
	

}
