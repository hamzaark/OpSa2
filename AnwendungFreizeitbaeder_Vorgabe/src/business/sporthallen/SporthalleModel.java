package business.sporthallen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import ownUtil.Observable;
import ownUtil.Observer;
import ownUtil.PlausiException;

public class SporthalleModel implements Observable{

	private static SporthalleModel instance;
	private ArrayList<Sporthalle> sporthallen = new ArrayList<Sporthalle>();
	private Vector<Observer> observers = new Vector<Observer>();
	
	public static SporthalleModel getInstance() {
		if(SporthalleModel.instance == null) {
			SporthalleModel.instance = new SporthalleModel();
		}
		return SporthalleModel.instance;	
	}
	
	public ArrayList<Sporthalle> getSporthallen(){
		return this.sporthallen;
	}
	
	public void leseSporthallenAusCsvDatei()
			throws IOException, PlausiException{
			BufferedReader ein = new BufferedReader(
		 		new FileReader("Sporthallen.csv"));
			ArrayList<Sporthalle> ergebnis = new ArrayList<>(); 
			String zeileStr = ein.readLine();
			while(zeileStr != null) {
				String[] zeile = zeileStr.split(";");
		           ergebnis.add( 
					new Sporthalle(zeile[0], zeile[1], zeile[2]));
		           zeileStr = ein.readLine();
			}    
		 	ein.close();
		 	this.sporthallen = ergebnis;
		}

	@Override
	public void addObserver(Observer obs) {
		this.observers.add(obs);
		
	}

	@Override
	public void removeObserver(Observer obs) {
		this.observers.remove(obs);
	}

	@Override
	public void notifyObservers() {
		for (Observer durchlauf : this.observers) {
			durchlauf.update();
		}
		
	}

}
