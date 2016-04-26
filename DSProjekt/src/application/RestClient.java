package application;

import java.util.ArrayList;
import java.util.Arrays;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientResponse;
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
	
	public ArrayList<PSpot> saveChangedSpots(ArrayList<PSpot> ps){
		ArrayList<Spot> list = new ArrayList<Spot>();
		ArrayList<PSpot> list2 = new ArrayList<PSpot>();
		for(int i=0; i<ps.size(); i++){
			list.add(new Spot(ps.get(i).getId(),ps.get(i).getAddBlue().getValue(),ps.get(i).getFood().getValue(),ps.get(i).getWc().getValue(),
			ps.get(i).getBed().getValue(),ps.get(i).getBath().getValue(),ps.get(i).getRoadtrain().getValue(),ps.get(i).getLongitude(),
			ps.get(i).getLatitude(),ps.get(i).getName(),ps.get(i).getLastUpdated(),ps.get(i).getDeleted().getValue()));			
		}
		
//		//Testkode til at se om Spotsne kan laves til JSON
//		JSONArray ja;
//		try {
//			ja = new JSONArray(Arrays.asList(list));
//			System.out.println(ja);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		saveSpotsToServer(list);
		list = hentJsonFraServer();
		for(int i=0; i<list.size(); i++){
			list2.add(new PSpot(list.get(i).getId(), list.get(i).getAddBlue(), list.get(i).getFood(), list.get(i).getWc(), list.get(i).getBed(),
					list.get(i).getBath(), list.get(i).getRoadtrain(), list.get(i).getLongitude(), list.get(i).getLatitude(),
					list.get(i).getName(), list.get(i).getLastUpdated(), list.get(i).getDeleted()));
		}
		return list2;
	}
	
	private void saveSpotsToServer(ArrayList<Spot> list){
		//rest magic skal ske her
		System.out.println("liste størrelse i rest: "+list.size());
		JSONArray ja = new JSONArray(list);
		
//		for(int i=0; i<list.size();i++){
//			Spot spot = new Spot();
//			spot.setId(list.get(i).getId());
//			spot.setAddBlue(list.get(i).getAddBlue());
//			spot.setFood(list.get(i).getFood());
//			spot.setWc(list.get(i).getWc());
//			spot.setBed(list.get(i).getBed());
//			spot.setBath(list.get(i).getBath());
//			spot.setRoadtrain(list.get(i).getRoadtrain());
//			spot.setLongitude(list.get(i).getLongitude());
//			spot.setLatitude(list.get(i).getLatitude());
//			spot.setName(list.get(i).getName());
//			spot.setLastUpdated(list.get(i).getLastUpdated());
//			spot.setDeleted(list.get(i).getDeleted());
		
			Client client = ClientBuilder.newClient();
			Response res = client.target("http://localhost:8080/ConvoyServer/webresources/convoy/edit/spot").request(MediaType.APPLICATION_JSON).put(Entity.entity(ja, MediaType.APPLICATION_JSON));
			String resultString = res.readEntity(String.class);
			System.out.println(resultString);
		
	}
	
}
