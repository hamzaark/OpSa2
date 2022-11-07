package gui;

import java.io.IOException;

import business.FreizeitbaederModel;
import javafx.stage.Stage;

public class FreizeitbaederControl {
	
	private FreizeitbaederView fzView;
	private FreizeitbaederModel fzModel;
	
	public FreizeitbaederControl(Stage primaryStage){
		this.fzModel = new FreizeitbaederModel();
		this.fzView = new FreizeitbaederView(primaryStage, this,fzModel);
	}
	public void schreibeInDatei(String typ){
		try{
			if("csv".equals(typ)){
				fzModel.schreibeFreizeitbaederInCsvDatei();
				fzView.zeigeInformationsfensterAn("Das Freizeitbad wurde gespeichert!");
				}
				else{
				fzView.zeigeInformationsfensterAn(
				"Noch nicht implementiert!");
				}
			
			this.fzView.zeigeInformationsfensterAn(
					"Der Text wurde in die Datei geschrieben.");
			}
		catch(IOException exc){
			this.fzView.zeigeFehlermeldungsfensterAn(typ, "IOException");
		}
		catch(Exception exc){
			this.fzView.zeigeFehlermeldungsfensterAn(typ, "Unbekannter fehler beim Speichern");
		}
	}
	
	
}