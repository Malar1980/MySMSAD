package org.elan.ws;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


 
@Path("/myrestservice/")
@WebService
public interface MyService {

	@Path("/sum")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
	public SumResponse sum(SumRequest parameters);

	@Path("/sumpathparam/{add1}/{add2}")
	@POST
	public int sumpathparam(@PathParam("add1") int add1,@PathParam("add2") int add2);
}
