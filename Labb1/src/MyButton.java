import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyButton extends JButton implements ActionListener {
	
	private Color c1,c2;
	private String s1,s2;
	
	public MyButton(Color c1, Color c2, String s1, String s2) {
		
		super(s1);
		
		//to get variables in toggleButton
		this.c1 = c1;
		this.c2 = c2;
		this.s1 = s1;
		this.s2 = s2;
		
		setBackground(c1);
		addActionListener(this);

	}
	
	public void toggleState() {
		//to toggle between color and text

		//get the current text
		String s = getText();
		
		if(s.equals(s1)){
			setBackground(c2);
			setText(s2);
		}
		else {
			setBackground(c1);
			setText(s1);
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		toggleState();
		
	}
}
