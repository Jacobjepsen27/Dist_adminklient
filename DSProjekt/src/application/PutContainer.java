package application;

public class PutContainer {
	
	Spot spot;
	String token;
	
	public PutContainer(Spot spot, String token){
		this.spot=spot;
		this.token=token;
	}
	
	public Spot getSpot(){
		return spot;
	}
	
	public String getToken(){
		return token;
	}

}
