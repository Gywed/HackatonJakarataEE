package be.helha.aemt.groupea5.services;

import java.util.List;

import be.helha.aemt.groupea5.dao.AADAO;
import be.helha.aemt.groupea5.entities.AA;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Stateless
@Path("/AA")
public class AARS {

	@EJB
	private AADAO dao;
	
	@GET
	@Path("/fetchAll")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response findAll()
	{
		// faire les test pour voir si OK
		List<AA> result = dao.findAll();
		if (result.isEmpty()) {
			return Response.status(Status.NOT_FOUND).entity("").build();
		}
		return Response.ok().entity(result).build();
	}
}
