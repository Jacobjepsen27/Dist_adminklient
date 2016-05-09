package application;

public class Adresse {

	String name;
	double latitude;
	double longtitude;
	
	public Adresse(String name, double latitude, double longtitude){
		this.name = name;
		this.latitude = latitude;
		this.longtitude = longtitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}
	
	public String toString(){
		return name;
	}
}
