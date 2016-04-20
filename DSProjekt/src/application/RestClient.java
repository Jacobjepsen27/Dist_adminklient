package application;

import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.research.ws.wadl.Request;

public class RestClient {

	public  ArrayList<Spot> hentJsonFraServer(){ 
		Client client = ClientBuilder.newClient();

		//Kalder GET - get() på target og accepterer JSON
		Response res = client.target("http://localhost:8080/ConvoyServer/webresources/convoy/get_all").request(MediaType.APPLICATION_JSON).get();

		//Sætter svaret til at være en string
		String resultString = res.readEntity(String.class);
		ArrayList<Spot> spots;

		try {
			JSONArray jsonarray = new JSONArray(resultString);
			spots = parseJSONArray(jsonarray);
			return spots;
		}catch(JSONException e){
			e.printStackTrace();
		}
		return null;
	}

	private ArrayList<Spot> parseJSONArray(JSONArray jArray) throws JSONException{
		ArrayList<Spot> spots = new ArrayList<>();

		JSONObject jo;
		JSONArray ja = jArray;
		for (int i = 0; i < ja.length(); i++) {
			jo = ja.getJSONObject(i);
			Spot spot = new Spot(jo.getInt("id"),jo.getBoolean("addBlue"),jo.getBoolean("food"),jo.getBoolean("wc"),
					jo.getBoolean("bed"),jo.getBoolean("bath"),jo.getBoolean("roadtrain"), Float.parseFloat(Double.toString(jo.getDouble("longitude"))), Float.parseFloat(Double.toString(jo.getDouble("latitude"))),
					jo.getString("name"), jo.getLong("lastUpdated"), jo.getBoolean("deleted"));
			spots.add(spot);
		}
		return spots;
	}
	
	public ArrayList<Spot> saveChangedSpots(ArrayList<Spot> savedSpots){
		ArrayList<Spot> list = new ArrayList<Spot>();
		saveSpotsToServer(savedSpots);
		list = hentJsonFraServer();
		return list;
	}
	
	private void saveSpotsToServer(ArrayList<Spot> list){
		//rest magic skal ske her
		
		
		
		
		Client client = ClientBuilder.newClient();
		
//		Request req = client.target("http://posttestserver.com/data/").request(MediaType.APPLICATION_JSON).post(list);
		
		
	}
	
}
