import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	
	
	public MainFrame() {
		super("Labb1");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.pink);
		panel.setLayout(new FlowLayout());
		
		//label with author name
		JLabel label = new JLabel("Jonatan Erdal, Michael Nilsson");
		label.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label);

		//button that changes appearance when pressed
		MyButton button1 = new MyButton(Color.green, Color.red, "Hej", "Tjockis");
		panel.add(button1);
		
		MyButton button2 = new MyButton(Color.cyan, Color.darkGray, "Nalle", "Puh");
		panel.add(button2);
		
		
		add(panel);
		setBounds(300,200,400,300);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
