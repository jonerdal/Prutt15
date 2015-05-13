import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.text.BadLocationException;
import javax.swing.text.html.*;


public class LinkExtractor2000X {
	
	static InputStream in;
	static InputStreamReader reader;
	static HTMLDocument doc;
	static String[][] matrix;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//getMatrix("http://www.nada.kth.se/~henrik");
		//System.out.println(matrix[4][0]);
	
	}
	
	public static String[][] getMatrix(String url) {

		matrix = new String [50][2];
		doc = new HTMLDocument();
		
		String webpage=url;

		openConnection(webpage);

		reader = new InputStreamReader(in);

		readPage();

		extractLinks();

		return matrix;
	}
	


	private static void openConnection(String webpage) {
		// TODO Auto-generated method stub
		try {
			in = new URL(webpage).openConnection().getInputStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   

	}

	private static void readPage() {
		// TODO Auto-generated method stub

		try {
			//while(reader.ready()) {
			//System.out.print((char)reader.read());
			doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
			try {
				new HTMLEditorKit().read(reader,doc,0);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void extractLinks() {
		int count = 0;
		String[] tempAttr = new String[2];
		String descr = "";
		HTMLDocument.Iterator iterator = doc.getIterator(HTML.Tag.A);
		while (iterator.isValid()) {
			
			tempAttr = iterator.getAttributes().toString().split("=",2);
			
			int startOffset = iterator.getStartOffset();
			int endOffset = iterator.getEndOffset();
			try {
				descr = doc.getText(startOffset, endOffset-startOffset);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//tempAttr[1] innehåller vår länk, motsvarande beskrivning återfås i descr
			if (count < 50) {
				matrix[count][0] = tempAttr[1];
				matrix[count][1] = descr;
			}
			count++;
			iterator.next();
		}
		
	}



}
