pakage edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeVC extends JPanel implements ActionListener {
	private TicTacToe model;
	private JButton[][] button;
	
	public TicTacToeVC() {
		model = new TicTacToe();
		button = new JButton[3][3];
		
		setLayout(new GridLayout(3, 3));
		for(int i = 0; i < button.length; i++) {
			for(int j = 0; j < button[i].length; j++){
				button[i][j] = new JButton();
				button[i][j].setPreferredSize(new Dimension 100, 100);
				button[i][j].addActionListener(this);
				button[i][j].setActionCommand(i + " " + j);
				add(button[i][j]);
			}
		}	
	}
	
	private void checkForWin() {
		TicTacToe.Result result = model.getResult();
		final String s;
		if(result == TicTacToe.Result.XWINS) {
			s = "X";
		}
		else if(result == TicTacToe.Result.OWINS) {
			s = "O";
		}
		else if(result == TicTacToe.Result.TIE) {
			s = "TIE";
		}
		else {
			s = "";
		}
	}
	
	public void actionPerfromed(ActionEvent event) {
		JButton b = (JButton)event.getSource();
		int row = Integer.parseInt(b.getActionCommand().substring(0, 1));
		int column = Integer.parseInt(b.getActionCommand().substring(1, 2));
		model.setMark(row, column);
		TicTacToe.Mark m = model.getMark(row, column);
		if(m == TicTacToe.Mark.X) b.setText("X");
		else if(m == TicTacToe.Mark.O) b.setText("O");
	}
	
	public static void main(String[] args) {
		JFrame win = new JFrame();
		win.add(new TicTacToeVC());
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.pack();
		win.setVisible(true);
	}
	
}