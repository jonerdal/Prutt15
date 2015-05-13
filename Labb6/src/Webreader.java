import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;


public class Webreader extends JEditorPane {

	URL url;
	public Webreader() {
		this.setEditable(false);

	}

	public void showPage(String u) {

		//konvertera string till url
		try {
			url = new URL(u);
		} catch (MalformedURLException e1) {
			System.out.println("Fel vid konvertering till URL");
		}

		//setPage
		try {
			setPage(url);
		} catch (IOException e) {

			System.out.println("Fel vid hämtning av sida");
			JOptionPane.showMessageDialog(this,
					"Ogiltig URL, gör om gör rätt");
		}		

	}

}
