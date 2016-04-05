package application;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Spot {
	
	//Felter til hvad Spots indeholder
	private final SimpleBooleanProperty addBlue, food, wc, bed, bath, roadtrain, deleted;
    private final SimpleFloatProperty longitude, latitude;
    private final SimpleStringProperty name;
    private final SimpleLongProperty lastUpdated;
    private final SimpleIntegerProperty id;
	
	public Spot(int id, boolean addBlue, boolean food, boolean wc, boolean bed, boolean bath, boolean roadtrain, float longitude, float latitude, String name, long lastUpdated, boolean deleted){
		this.id = new SimpleIntegerProperty(id);
        this.addBlue = new SimpleBooleanProperty(addBlue);
        this.food = new SimpleBooleanProperty(food);
        this.wc = new SimpleBooleanProperty(wc);
        this.bed = new SimpleBooleanProperty(bed);
        this.bath = new SimpleBooleanProperty(bath);
        this.roadtrain = new SimpleBooleanProperty(roadtrain);
        this.longitude = new SimpleFloatProperty(longitude);
        this.latitude = new SimpleFloatProperty(latitude);
        this.name = new SimpleStringProperty(name);
        this.lastUpdated = new SimpleLongProperty(lastUpdated);
        this.deleted = new SimpleBooleanProperty(deleted);
	}
	
	public int getId(){
		return id.get();
	}
	
	public boolean getAddBlue(){
		return addBlue.get();
	}
	
	public void setAddBlue(boolean b){
		addBlue.set(b);
	}
	
	public boolean getFood(){
		return food.get();
	}
	
	public void setFood(boolean b){
		food.set(b);
	}
	
	public boolean getWc(){
		return wc.get();
	}
	
	public void setWc(boolean b){
		wc.set(b);
	}
	
	public boolean getBed(){
		return bed.get();
	}
	
	public void setBed(boolean b){
		bed.set(b);
	}
	
	public boolean getBath(){
		return bath.get();
	}
	
	public void setBath(boolean b){
		bath.set(b);
	}
	
	public boolean getRoadtrain(){
		return roadtrain.get();
	}
	
	public void setRoadtrain(boolean b){
		roadtrain.set(b);
	}
	
	public float getLongitude(){
		return longitude.get();
	}
	
	public void setLongitude(float f){
		longitude.set(f);
	}
	
	public float getLatitude(){
		return latitude.get();
	}
	
	public void setLatitude(float f){
		latitude.set(f);
	}
	
	public String getName(){
		return name.get();
	}
	
	public void setName(String n){
		name.set(n);
	}
	
	public long getLastUpdated(){
		return lastUpdated.get();
	}
	
	public void setLastUpdated(long n){
		lastUpdated.set(n);
	}
	
	public boolean getDeleted(){
		return deleted.get();
	}
	
	public void setDeleted(boolean b){
		deleted.set(b);
	}

}
