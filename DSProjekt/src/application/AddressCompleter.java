package application;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author KimDrewes
 */
public class AddressCompleter {

    /**
     * 
     * @param addressQuery Den fulde utvetydige adresse der søges på
     * @return Double array med breddegrad som første element, og længdegrad som andet element
     * @throws JSONException 
     */
   
    public double[] getGeoLocation(String addressQuery) throws JSONException {
        
        //Instantierer en client
        Client client = ClientBuilder.newClient();
        try {
            // addressQuery.replace("", 0)
            //Sørger for at mellemrum, æøå osv, kan sendes til REST serveren
            addressQuery = URLEncoder.encode(addressQuery, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AddressCompleter.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Kalder GET - get() på target og accepterer JSON
        Response res = client.target("http://dawa.aws.dk/adresser?q=" + addressQuery).request(MediaType.APPLICATION_JSON).get();

        //Sætter svaret til at være en string
        String resultString = res.readEntity(String.class);
        ArrayList<String> addressList = new ArrayList<>();

        double koord[] = new double[2];

        //DAWA rest apiet bliver sendt som et stort JSONarray.
        JSONArray jsonarray = new JSONArray(resultString);
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject object = jsonarray.getJSONObject(i);
          
            JSONObject adresse = object.getJSONObject("adgangsadresse");
            JSONObject adgangspunkt = adresse.getJSONObject("adgangspunkt");
            JSONArray tempKoord = adgangspunkt.getJSONArray("koordinater");
            
            String longtitude = tempKoord.get(1).toString();
            String latitude = tempKoord.get(0).toString();
            koord[0] = Double.parseDouble(longtitude);
            koord[1] = Double.parseDouble(latitude);
                 
    
        }
        return koord;
    }

    /**
     * 
     * @param addressQuery Den ufuldstændige addresse man ønsker at færdigøre
     * @return Returnerer en liste af adresser i form af en String
     * @throws JSONException 
     */
    
    public ArrayList<String> getAddresses(String addressQuery) throws JSONException {
        //Instantierer en client
        Client client = ClientBuilder.newClient();
        try {
            //Sørger for at mellemrum, æøå osv, kan sendes til REST serveren
            addressQuery = URLEncoder.encode(addressQuery, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AddressCompleter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Kalder GET - get() på target og accepterer JSON
        Response res = client.target("http://dawa.aws.dk/adresser?q=" + addressQuery).request(MediaType.APPLICATION_JSON).get();
        
        //Sætter svaret til at være en string
        String resultString = res.readEntity(String.class);
        ArrayList<String> addressList = new ArrayList<>();
        
        try {
            //DAWA rest apiet bliver sendt som et stort JSONarray.
            JSONArray jsonarray = new JSONArray(resultString);
            
            
//        Der køres igennem alle elementerne i array, og der bliver lavet
//         JSON objekter af disse
//         Der bliver sorteret så vi kun henter den ressourse der hedder
//         addressebetegnelse!
for (int i = 0; i < jsonarray.length(); i++) {
    JSONObject jsonobject = jsonarray.getJSONObject(i);
    String address = jsonobject.getString("adressebetegnelse");
    
    addressList.add(address);
}
        }catch (JSONException ex) {
            System.out.println("Der skete en fejl");
            ex.printStackTrace();
        }
        
        return addressList;
    }
}


