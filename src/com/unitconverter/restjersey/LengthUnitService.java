package com.unitconverter.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/length-unit-service")
public class LengthUnitService
{
	@GET
	@Produces("application/json")
	public Response convertLengthUnit() throws JSONException 
	{
		JSONObject jsonObject = new JSONObject();
		return Response.status(200).entity(jsonObject.toString()).build();
	}

	@Path("{quantity}-{fromUnit}-{toUnit}")
	@GET
	@Produces("application/json")
	public Response convertLenghtUnit(@PathParam("quantity") float quantity, @PathParam("fromUnit") String fromUnit, @PathParam("toUnit") String toUnit) throws JSONException 
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("originalQuantity", quantity);
		jsonObject.put("fromUnit", fromUnit);
		jsonObject.put("toUnit", toUnit);

		float convertedQuantity = 0;

		if (fromUnit.equalsIgnoreCase("Kilometer"))
		{
			if (toUnit.equalsIgnoreCase("Meter"))
			{
				convertedQuantity = quantity * 1000;
			}
			else if (toUnit.equalsIgnoreCase("Mile"))
			{
				convertedQuantity = quantity / 1.609f;
			}
		}
		else if (fromUnit.equalsIgnoreCase("Meter"))
		{
			if (toUnit.equalsIgnoreCase("Kilometer"))
			{
				convertedQuantity = quantity / 1000f;
			}
			else if (toUnit.equalsIgnoreCase("Mile"))
			{
				convertedQuantity = quantity / 1609f;
			}	
		}
		else if (fromUnit.equalsIgnoreCase("Mile"))
		{
			if (toUnit.equalsIgnoreCase("Kilometer"))
			{
				convertedQuantity = quantity * 1.609f;
			}
			else if (toUnit.equalsIgnoreCase("Meter"))
			{
				convertedQuantity = quantity * 1609;
			}
		}
		
		jsonObject.put("convertedQuantity", convertedQuantity);

		return Response.status(200).entity(jsonObject.toString()).build();
	}
}
