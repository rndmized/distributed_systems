package ie.gmit.sw.Rest_Lab;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/calculateimpl")
public class CalculateResource implements CalculateResourceInterface {

	@Override
	public Response calcAddTwoValues(double value1, double value2) {
		double answer = value1 + value2;
		String msg = String.format("calcAddTwoValues==> value1: %10.4f, value2: %10.4f, answer: %10.4f", value1, value2, answer);    
		return Response.status(200).entity(msg).build();
	}

	@Override
	public Response calcSubTwoValues(double value1,  double value2) {
		double answer = value1 - value2;
		String msg = String.format("calcSubTwoValues==> value1: %10.4f, value2: %10.4f, answer: %10.4f", value1, value2, answer);    
		return Response.status(200).entity(msg).build();
	}

	@Override
	public Response calcSqrtHTML(double value) {
		double answer = Math.sqrt(value);
		String msg = String.format("calcSqrt==> value: %f, answer: %10.4f", value, answer);    
		return Response.status(200).entity(msg).build();
	}
}