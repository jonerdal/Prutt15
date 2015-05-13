import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.*;
import javax.swing.text.*;
   
public class GoudaWaterCat extends JFrame implements ActionListener, HyperlinkListener{
	
	JTable table;
	JScrollPane links, website;
	JTextField URLField;
	Webreader siteInfo;
	String url;
	String[] header = new String[2];

	public GoudaWaterCat() {

		super("Welcome to Gouda WaterCat 2000X");
		header[0] = "Link";
		header[1] = "Description";

		//initierar komponenter
		table = new JTable(50,2);
		links = new JScrollPane(table);
		URLField = new JTextField();
		URLField.addActionListener(this);
		siteInfo = new Webreader();
		website = new JScrollPane(siteInfo);
		siteInfo.addHyperlinkListener(this);

		setLayout(new BorderLayout());

		//lägger till alla komponenter till frame
		add(URLField,BorderLayout.NORTH);
		add(website, BorderLayout.CENTER);
		add(links, BorderLayout.EAST);
		
		//visar vår frame
		setBounds(100,100,1200,800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		
		new GoudaWaterCat();
		
	}
	
	public void hyperlinkUpdate(HyperlinkEvent e) {
		if( e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
			//klickat på hyperlink
			String tempURL = e.getURL().toString();
			//siteInfo.showPage(tempURL);
			URLField.setText(tempURL);
			URLField.postActionEvent();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String tempURL = URLField.getText();
		siteInfo.showPage(tempURL);
		DefaultTableModel model = new DefaultTableModel(LinkExtractor2000X.getMatrix(tempURL), header);
		table.setModel(model);
		
	}

}
