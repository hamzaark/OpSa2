package gui.guiSportstaetten;

import java.io.IOException;

import business.freizeitbaeder.FreizeitbaederModel;
import business.sporthallen.SporthalleModel;
import javafx.stage.Stage;
import ownUtil.Observer;
import ownUtil.PlausiException;

public class SportstaettenControl implements Observer {
	
	FreizeitbaederModel fzModel;
	SporthalleModel sporthalleModel = SporthalleModel.getInstance();
	SportstaettenView sportstaettenView;
	public SportstaettenControl(Stage primaryStage){
		this.fzModel = FreizeitbaederModel.getInstance();
		this.sportstaettenView = new SportstaettenView(primaryStage, this, fzModel) ;
		this.fzModel.addObserver(this);
	}
	
	public void leseSporthallen() {
		try {
			sporthalleModel.leseSporthallenAusCsvDatei();
		} catch (IOException | PlausiException e1) {
			sportstaettenView.zeigeInformationsfensterAn("Daten können nicht gelesen werden");
		}
	}
	
	@Override
	public void update() {
		this.sportstaettenView.zeigeFreizeitbaederAn();
		
	}
}
