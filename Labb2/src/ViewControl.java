import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;


public class ViewControl extends JFrame implements ActionListener{

	private Boardgame game;
	private int size;
	private JButton[][] board;
	private JLabel message = new JLabel();
	private JPanel panel2;
	
	
	public ViewControl(Boardgame gm, int n) {
		//konstruktor
		game = gm;
		size = n;
		setBounds(200,200,500,500);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		
		panel1.add(message, BorderLayout.SOUTH);
		message.setText(game.getMessage());
		message.setBorder(new EmptyBorder(10, 10, 10, 10)); 
		message.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(size,size));
		
		//lägg till knappar i panel2
		board = new JButton[size][size];
		for(int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				board[i][j] = new JButton(game.getStatus(i, j));
				board[i][j].setBackground(Color.pink);
				board[i][j].addActionListener(this);
				panel2.add(board[i][j]);
			}
		} 

		panel1.add(panel2, BorderLayout.CENTER);
		add(panel1);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		//skapar temporär knapp för den vi tryckt på
		JButton temp = (JButton)arg0.getSource();
		
		//hittar index för den knapp vi trycker på
		for(int i = 0; i<size; i++) {
			for (int j=0; j<size; j++) {
				if(board[i][j] == temp) {
					//kör move på den tryckta knappen
					boolean check = game.move(i,j);
					//om move OK, ändra spelplanens utseende
					if (check) {
						changeField();
					}
				}
			}
		}
		//ändrar message
		message.setText(game.getMessage());
		temp.setBackground(Color.yellow);
		
	}
	
	public void changeField() {
		//ändra spelplan
		for(int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				board[i][j].setText(game.getStatus(i,j));
				board[i][j].setBackground(Color.pink);
			}
		}
	}
	
	
}
