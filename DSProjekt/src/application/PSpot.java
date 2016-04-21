package application;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

public class PSpot {
	
	//Felter til hvad Spots indeholder
	private final SimpleBooleanProperty addBlue, food, wc, bed, bath, roadtrain, deleted;
    private final SimpleFloatProperty longitude, latitude;
    private final SimpleStringProperty name;
    private SimpleLongProperty lastUpdated;
    private  SimpleIntegerProperty id;
	
	public PSpot(int id, boolean addBlue, boolean food, boolean wc, boolean bed, boolean bath, boolean roadtrain, float longitude, float latitude, String name, long lastUpdated, boolean deleted){
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
	
//	public Spot(boolean addBlue, boolean food, boolean wc, boolean bed, boolean bath, boolean roadtrain, float longitude, float latitude, String name, long lastUpdated, boolean deleted){
//        this.addBlue = new SimpleBooleanProperty(addBlue);
//        this.food = new SimpleBooleanProperty(food);
//        this.wc = new SimpleBooleanProperty(wc);
//        this.bed = new SimpleBooleanProperty(bed);
//        this.bath = new SimpleBooleanProperty(bath);
//        this.roadtrain = new SimpleBooleanProperty(roadtrain);
//        this.longitude = new SimpleFloatProperty(longitude);
//        this.latitude = new SimpleFloatProperty(latitude);
//        this.name = new SimpleStringProperty(name);
//        this.lastUpdated = new SimpleLongProperty(lastUpdated);
//        this.deleted = new SimpleBooleanProperty(deleted);
//	}

//	}
//	
	public int getId(){
		return id.get();
	}
//	
//	public boolean getAddBlue(){
//		return addBlue.get();
//	}
	
	public ObservableValue<Boolean> getAddBlue(){
		return addBlue;
	}
	
	public void setAddBlue(boolean b){
		addBlue.set(b);
	}
	
	public ObservableValue<Boolean> getFood(){
		return food;
	}
	
	public void setFood(boolean b){
		food.set(b);
	}
	
	public ObservableValue<Boolean> getWc(){
		return wc;
	}
	
	public void setWc(boolean b){
		wc.set(b);
	}
	
	public ObservableValue<Boolean> getBed(){
		return bed;
	}
	
	public void setBed(boolean b){
		bed.set(b);
	}
	
	public ObservableValue<Boolean> getBath(){
		return bath;
	}
	
	public void setBath(boolean b){
		bath.set(b);
	}
	
	public ObservableValue<Boolean> getRoadtrain(){
		return roadtrain;
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
	
	public ObservableValue<Boolean> getDeleted(){
		return deleted;
	}
	
	public void setDeleted(boolean b){
		deleted.set(b);
	}

}
