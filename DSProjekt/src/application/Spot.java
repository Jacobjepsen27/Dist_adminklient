package application;

public class Spot {
	
	private boolean addBlue, food, wc, bed, bath, roadtrain, deleted;
    private float longitude, latitude;
    private String name;
    private long lastUpdated;
    private int id;
	
	public Spot(int id, boolean addBlue, boolean food, boolean wc, boolean bed, boolean bath, boolean roadtrain, float longitude, float latitude, String name, long lastUpdated, boolean deleted){
		this.id = id;
        this.addBlue = addBlue;
        this.food = food;
        this.wc = wc;
        this.bed = bed;
        this.bath = bath;
        this.roadtrain = roadtrain;
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.lastUpdated = lastUpdated;
        this.deleted = deleted;
	}
	
	public int getId(){
		return id;
	}
	public boolean getAddBlue(){
		return addBlue;
	}
	public boolean getFood(){
		return food;
	}
	public boolean getWc(){
		return wc;
	}
	public boolean getBed(){
		return bed;
	}
	public boolean getBath(){
		return bath;
	}
	public boolean getRoadtrain(){
		return roadtrain;
	}
	public float getLongitude(){
		return longitude;
	}
	public float getLatitude(){
		return latitude;
	}
	public String getName(){
		return name;
	}
	public long getLastUpdated(){
		return lastUpdated;
	}
	public boolean getDeleted(){
		return deleted;
	}

}
