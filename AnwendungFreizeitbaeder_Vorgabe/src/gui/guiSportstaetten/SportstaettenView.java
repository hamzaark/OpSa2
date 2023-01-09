package gui.guiSportstaetten;

import business.freizeitbaeder.Freizeitbad;
import business.freizeitbaeder.FreizeitbaederModel;
import business.sporthallen.Sporthalle;
import business.sporthallen.SporthalleModel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class SportstaettenView{
	
	// Hier ergaenzen
	Stage stage;
	FreizeitbaederModel freizeitbaederModel = FreizeitbaederModel.getInstance();
	SporthalleModel sporthalleModel = SporthalleModel.getInstance();
    SportstaettenControl sportstaettenControl;	
	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane paneSporthalle     				       
 		= new  Pane();
    	private Label lblAnzeigeSporthalle     
 		= new Label("Anzeige Sporthallen");
    	private TextArea txtAnzeigeSporthalle  = new TextArea();
    	private Button btnAnzeigeSporthalle = new Button("csv-Import und Anzeige");
//    	private MenuBar mnbrMenuSporthalle  	= new MenuBar();
//        private Menu mnDateiSporthalle             	= new Menu("Datei");
//        private MenuItem mnItmCsvImportSporthalle 	= new MenuItem("csv-Import");
    	//-------Ende Attribute der grafischen Oberflaeche-------
    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane paneFreizeitbaeder     				       
 		= new  Pane();
    	private Label lblAnzeigeFreizeitbaeder     
 		= new Label("Anzeige Freizeitbäder");
    	private TextArea txtAnzeigeFreizeitbaeder  = new TextArea();
    	private Button btnAnzeigeFreizeitbaeder = new Button("Anzeige");
    	private HBox hBox = new HBox();
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public SportstaettenView(Stage primaryStage,SportstaettenControl spControl,FreizeitbaederModel fzModel){
    		this.sportstaettenControl = spControl;
    		Scene scene = new Scene(this.hBox, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige von Sportsartten");
    		primaryStage.show();
    		// Hier ergaenzen
    	this.stage = primaryStage;
    	this.initKomponentenSporthalle();
		this.initKomponentenFreizeitbaeder();
		this.initListenerSporthalle();
		this.initListenerFreizeitbaeder();
    	}
    	
    	private void initKomponentenSporthalle(){
    		// Label
 		Font font = new Font("Arial", 20);
    		lblAnzeigeSporthalle.setLayoutY(40);
    		lblAnzeigeSporthalle.setFont(font);
    		lblAnzeigeSporthalle.setStyle("-fx-font-weight: bold;"); 
       	paneSporthalle.getChildren().add(lblAnzeigeSporthalle);    
        	// Textbereich	
        	txtAnzeigeSporthalle.setEditable(false);
    		txtAnzeigeSporthalle.setLayoutY(90);
     		txtAnzeigeSporthalle.setPrefWidth(220);
    		txtAnzeigeSporthalle.setPrefHeight(185);
       	paneSporthalle.getChildren().add(txtAnzeigeSporthalle);        	
        	// Button
        	btnAnzeigeSporthalle.setLayoutY(290);
        	paneSporthalle.getChildren().add(btnAnzeigeSporthalle);
        	// Menu
//       	this.mnbrMenuSporthalle.getMenus().add(mnDateiSporthalle);
//          this.mnDateiSporthalle.getItems().add(mnItmCsvImportSporthalle);
//     	    paneSporthalle.getChildren().add(mnbrMenuSporthalle);
        	//HBox
        	hBox.getChildren().add(paneSporthalle);
        	HBox.setMargin(paneSporthalle, new Insets(0,30,0,30));
   }
    	
    	private void initKomponentenFreizeitbaeder(){
    		// Label
 		Font font = new Font("Arial", 20);
    		lblAnzeigeFreizeitbaeder.setLayoutY(40);
    		lblAnzeigeFreizeitbaeder.setFont(font);
    		lblAnzeigeFreizeitbaeder.setStyle("-fx-font-weight: bold;"); 
       	paneFreizeitbaeder.getChildren().add(lblAnzeigeFreizeitbaeder);    
        	// Textbereich	
        	txtAnzeigeFreizeitbaeder.setEditable(false);
    		txtAnzeigeFreizeitbaeder.setLayoutY(90);
     		txtAnzeigeFreizeitbaeder.setPrefWidth(220);
    		txtAnzeigeFreizeitbaeder.setPrefHeight(185);
       	paneFreizeitbaeder.getChildren().add(txtAnzeigeFreizeitbaeder);        	
        	// Button
        	btnAnzeigeFreizeitbaeder.setLayoutY(290);
        	paneFreizeitbaeder.getChildren().add(btnAnzeigeFreizeitbaeder);
        	//HBox
        	hBox.getChildren().add(paneFreizeitbaeder);
        	HBox.setMargin(paneFreizeitbaeder, new Insets(0,30,0,30));
   }
   
   private void initListenerSporthalle() {
	    btnAnzeigeSporthalle.setOnAction(aE -> {
	    	leseSporthallen();
	    	zeigeSporthallenAn();
	    });
    }
   private void initListenerFreizeitbaeder() {
	   btnAnzeigeFreizeitbaeder.setOnAction(aE -> {
		   zeigeFreizeitbaederAn();
	    });
   }
   
   private void leseSporthallen() {
	   this.sportstaettenControl.leseSporthallen();
   }
   
     void zeigeSporthallenAn(){
    		if(this.sporthalleModel.getSporthallen().size() > 0){
        		StringBuffer text = new StringBuffer();
        		for (Sporthalle durchlauf : this.sporthalleModel.getSporthallen()) {
        			text.append(durchlauf.gibSporthalleZurueck(' ')+"\n");
        		}
        		this.txtAnzeigeSporthalle.setText(
        				text.toString());
        	}
    		else{
    			zeigeInformationsfensterAn(
 				"Bisher wurde kein Freizeitbad aufgenommen!");
    		}
    }	
     
     void zeigeFreizeitbaederAn(){
 		if(this.freizeitbaederModel.getFreizeitbaeder().size() > 0){
     		StringBuffer text = new StringBuffer();
     		for (Freizeitbad durchlauf : this.freizeitbaederModel.getFreizeitbaeder()) {
     			text.append(durchlauf.gibFreizeitbadZurueck(' ')+"\n");
     		}
     		this.txtAnzeigeFreizeitbaeder.setText(
     				text.toString());
     	}
 		else{
 			zeigeInformationsfensterAn(
				"Bisher wurde kein Freizeitbad aufgenommen!");
 		}
 }
   
    public void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
               	"Information", meldung).zeigeMeldungsfensterAn();
    }
	
    
}

