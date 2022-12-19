package gui.guiSportstaetten;

import business.FreizeitbaederModel;
import gui.guiFreizeitbaeder.FreizeitbaederView;
import javafx.stage.Stage;
import ownUtil.Observer;

public class SportstaettenControl implements Observer {

	FreizeitbaederModel fzModel;
	SportstaettenView sportstaettenView;
	public SportstaettenControl(Stage primaryStage){
		this.fzModel = FreizeitbaederModel.getInstance();
		this.sportstaettenView = new SportstaettenView(primaryStage, this, fzModel) ;
		this.fzModel.addObserver(this);
	}
	@Override
	public void update() {
		this.sportstaettenView.zeigeFreizeitbaederAn();
		
	}
}
