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
	
	public Spot(){
		
	}
	
	public int getId(){
		return id;
	}
	public void setId(int i){
		id=i;
	}
	public boolean getAddBlue(){
		return addBlue;
	}
	public void setAddBlue(boolean b){
		addBlue=b;
	}
	public boolean getFood(){
		return food;
	}
	public void setFood(boolean b){
		food=b;
	}
	public boolean getWc(){
		return wc;
	}
	public void setWc(boolean b){
		wc=b;
	}
	public boolean getBed(){
		return bed;
	}
	public void setBed(boolean b){
		bed=b;
	}
	public boolean getBath(){
		return bath;
	}
	public void setBath(boolean b){
		bath=b;
	}
	public boolean getRoadtrain(){
		return roadtrain;
	}
	public void setRoadtrain(boolean b){
		roadtrain=b;
	}
	public float getLongitude(){
		return longitude;
	}
	public void setLongitude(float f){
		longitude=f;
	}
	public float getLatitude(){
		return latitude;
	}
	public void setLatitude(float f){
		latitude=f;
	}
	public String getName(){
		return name;
	}
	public void setName(String n){
		name=n;
	}
	public long getLastUpdated(){
		return lastUpdated;
	}
	public void setLastUpdated(long l){
		lastUpdated=l;
	}
	public boolean getDeleted(){
		return deleted;
	}
	public void setDeleted(boolean b){
		deleted=b;
	}

}
