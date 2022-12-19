package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import fabrik.ConcreteCsvWriterCreator;
import fabrik.ConcreteTxtWriterCreator;
import fabrik.WriterCreator;
import fabrik.WriterProduct;
import ownUtil.Observable;
import ownUtil.Observer;

public class FreizeitbaederModel implements Observable {
	
	Vector<Observer> observers = new Vector<>();
	
	private FreizeitbaederModel() {
		
	}
	
	static private FreizeitbaederModel fzModel;
	
	static public FreizeitbaederModel getInstance() {
		if (fzModel == null) {
			fzModel = new FreizeitbaederModel();
		}
		return fzModel;
	}
	
	private Freizeitbad freizeitbad;

	public Freizeitbad getFreizeitbad() {
		return freizeitbad;
	}

	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
		this.notifyObservers();
		
	}
	public void schreibeFreizeitbaederInCsvDatei() throws IOException {
		WriterCreator writerCreator=new ConcreteCsvWriterCreator();
		
		WriterProduct writer=writerCreator.factoryMethod();
		
		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schliesseDatei();
		
	}
	public void schreibeFreizeitbaederInTxtDatei() throws IOException{
		
		WriterCreator writerCreator=new ConcreteTxtWriterCreator();
		
		WriterProduct writer=writerCreator.factoryMethod();
		
		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schliesseDatei();
		
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
		for (Observer durchlauf : observers) {
			durchlauf.update();
		}
	}

}
