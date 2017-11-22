package ie.gmit.sw.Rest_Lab;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface CalculateResourceInterface {

	@GET
	@Path("/add/{value1}/{value2}")
	@Produces(MediaType.TEXT_HTML)
	public Response calcAddTwoValues(@PathParam("value1")  double value1, @PathParam("value2")  double value2);

	@GET
	@Path("/subtract/{value1}/{value2}")
	@Produces(MediaType.TEXT_HTML)
	public Response calcSubTwoValues(@PathParam("value1")  double value1, @PathParam("value2")  double value2);

	@GET
	@Path("/squareroot/{value}")
	@Produces(MediaType.TEXT_HTML)
	public Response calcSqrtHTML(@PathParam("value") double value);

}