package application;

import java.util.ArrayList;

public class ParseArray {
	
	public ParseArray(){
		
	}
	
	public static ArrayList<Spot> PSpot2Spot(ArrayList<PSpot> ps){
		ArrayList<Spot> listOut = new ArrayList<Spot>();
		for(int i=0; i<ps.size();i++){
			listOut.add(new Spot(ps.get(i).getId(),ps.get(i).getAddBlue().getValue(),ps.get(i).getFood().getValue(),ps.get(i).getWc().getValue(),
			ps.get(i).getBed().getValue(),ps.get(i).getBath().getValue(),ps.get(i).getFuel().getValue(),ps.get(i).getRoadtrain().getValue(),ps.get(i).getLongitude(),
			ps.get(i).getLatitude(),ps.get(i).getName(),ps.get(i).getLastUpdated(),ps.get(i).getDeleted().getValue()));					
		}
		return listOut;
	}
	
	public static ArrayList<PSpot> Spot2PSpot(ArrayList<Spot> list){
		ArrayList<PSpot> listOut = new ArrayList<PSpot>();
		for(int i=0; i<list.size(); i++){
		listOut.add(new PSpot(list.get(i).getId(), list.get(i).getAddBlue(), list.get(i).getFood(), list.get(i).getWc(), list.get(i).getBed(),
				list.get(i).getBath(), list.get(i).getFuel(),list.get(i).getRoadtrain(), list.get(i).getLongitude(), list.get(i).getLatitude(),
				list.get(i).getName(), list.get(i).getLastUpdated(), list.get(i).getDeleted()));
	}
		return listOut;
	}
	

}
