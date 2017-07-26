package org.elan.ws.service.api;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.elan.ws.exception.SMSADNotFoundException;
import org.elan.ws.service.to.SMSADDetailRequest;
import org.elan.ws.service.to.SMSADDetailResponse;
import org.elan.ws.service.to.SMSADList;

@Path("/mysmsadrestservice/")
@WebService
public interface MySMSADService {

	@Path("/createadservice")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public SMSADDetailResponse createADService(SMSADDetailRequest smsAdDetailRequest);

	@Path("/deleteadservice/{adcode}")
	@DELETE
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public SMSADDetailResponse deleteADService(@PathParam("adcode") String adCode) throws SMSADNotFoundException;

	@Path("/updateadservice")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public SMSADDetailResponse updateADService(SMSADDetailRequest smsAdDetailRequest) throws SMSADNotFoundException;

	@Path("/viewadservice/{adcode}")
	@GET
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public SMSADDetailResponse viewByAdCodeADService(@PathParam("adcode") String adCode) throws SMSADNotFoundException;

	@Path("/viewalladservice")
	@GET
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public SMSADList viewAllADService();
}
