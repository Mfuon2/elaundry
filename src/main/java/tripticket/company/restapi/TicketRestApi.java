package tripticket.company.restapi;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import elaundry.ticket.bean.TicketBeanI;

@Path("/ticket")
public class TicketRestApi {
	
	
	@EJB	
	private TicketBeanI ticketBean;
	
	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response list(){
		
		return Response.ok().entity(ticketBean.list()).build();
		
	}

}
