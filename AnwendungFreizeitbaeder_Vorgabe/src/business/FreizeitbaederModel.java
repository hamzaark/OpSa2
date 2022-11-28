package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import fabrik.ConcreteCsvWriterCreator;
import fabrik.ConcreteTxtWriterCreator;
import fabrik.WriterCreator;
import fabrik.WriterProduct;

public class FreizeitbaederModel {
	
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

}
