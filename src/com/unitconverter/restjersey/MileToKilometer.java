package com.unitconverter.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/miletokilometerservice")
public class MileToKilometer {

	@GET
	@Produces("application/json")
	public Response convertMiletoKilometer() throws JSONException {

		JSONObject jsonObject = new JSONObject();
		Double mile = 1.0;
		Double kilometer;
		kilometer = mile * 1.609f;
		jsonObject.put("mile", mile);
		jsonObject.put("kilometer", kilometer);
		
		return Response.status(200).entity(jsonObject.toString()).build();
	}

	@Path("{f}")
	@GET
	@Produces("application/json")
	public Response convertMiletoKilometer(@PathParam("f") float mile) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		float kilometers;
		kilometers = mile * 1.6f;
		jsonObject.put("mile", mile);
		jsonObject.put("kilometer", kilometers);

		return Response.status(200).entity(jsonObject.toString()).build();
	}
}
