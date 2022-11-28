package gui.guiFreizeitbaeder;

import java.io.IOException;

import business.FreizeitbaederModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class FreizeitbaederControl implements Observer{
	
	private FreizeitbaederView fzView;
	private FreizeitbaederModel fzModel;
	
	public FreizeitbaederControl(Stage primaryStage){
		this.fzModel = FreizeitbaederModel.getInstance();
		this.fzView = new FreizeitbaederView(primaryStage, this,fzModel);
	}
	public void schreibeInDatei(String typ){
		try{
			if("csv".equals(typ)){
				fzModel.schreibeFreizeitbaederInCsvDatei();
				fzView.zeigeInformationsfensterAn("Das Freizeitbad wurde gespeichert!");
				}
			else if("txt".equals(typ)){
				fzModel.schreibeFreizeitbaederInTxtDatei();;
				fzView.zeigeInformationsfensterAn("Die Datei wurde gespeichert");
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
	@Override
	public void update() {
		this.fzView.zeigeFreizeitbaederAn();
		
	}
	
	
}