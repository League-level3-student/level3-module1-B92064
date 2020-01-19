package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	
	static JFrame J = new JFrame();
	static JPanel P = new JPanel();
	static JLabel L = new JLabel();
	
	static int words;
	
	static Stack<String> strings = new Stack<String>();
	
	public static void main(String[] args) {
		HangMan h = new HangMan();
		Utilities utilities = new Utilities();
		
		String wordAmount = JOptionPane.showInputDialog("Welcome to Hangman!" + "/n" + "How many words would you like to guess?");
		
		words = Integer.parseInt(wordAmount);
		for(int r =0 ; r < words; r++) {
		strings.push(utilities.readRandomLineFromFile("dictionary.txt"));
		}
		h.setup();
	}
	
	void setup() {
		J.add(P);
		P.add(L);
		J.pack();
		J.setSize(500, 400);
		J.setLocation(750, 300);
		J.setVisible(true);
		J.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
