package com.unitconverter.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/kilometertomileservice")
public class KilometerToMile {

	@GET
	@Produces("application/json")
	public Response convertKilometertoMilefromInput() throws JSONException {

		JSONObject jsonObject = new JSONObject();
		Double kilometer = 1.0;
		Double mile;
		mile = kilometer / 1.609f;
		jsonObject.put("kilometer", kilometer);
		jsonObject.put("mile", mile);

		return Response.status(200).entity(jsonObject.toString()).build();
	}

	@Path("{f}")
	@GET
	@Produces("application/json")
	public Response convertKilometertoMilefromInput(@PathParam("f") float kilometer) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		float mile;
		mile = (kilometer / 1.609f);
		jsonObject.put("kilometer", kilometer);
		jsonObject.put("mile", mile);

		return Response.status(200).entity(jsonObject.toString()).build();
	}
}
