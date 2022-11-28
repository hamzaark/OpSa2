package fabrik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteCsvWriterProduct extends WriterProduct{
		BufferedWriter write;
	@Override
	public void fuegeInDateiHinzu(Object object) throws IOException {
		write =new BufferedWriter(new FileWriter("Freizeitbaeder.csv"));
		
		write.write(((Freizeitbad)object).gibFreizeitbadZurueck(';'));
		
	}

	@Override
	public void schliesseDatei() throws IOException {
		write.flush();
		write.close();
		
	}

}
