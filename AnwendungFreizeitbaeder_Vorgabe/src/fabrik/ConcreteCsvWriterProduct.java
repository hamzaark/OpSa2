package fabrik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteCsvWriterProduct extends WriterProduct{
		BufferedWriter write;
	public ConcreteCsvWriterProduct() throws IOException {
		write =new BufferedWriter(new FileWriter("Freizeitbaeder.csv"));
	}
	@Override
	public void fuegeInDateiHinzu(Object object) throws IOException {
		write.write(((Freizeitbad)object).gibFreizeitbadZurueck(';'));
		
		write.newLine();
	}

	@Override
	public void schliesseDatei() throws IOException {
		write.flush();
		write.close();
		
	}

}
