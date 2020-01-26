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
	
	static int numWords;
	static int lives = 10;
	static int numChar;
	
	static String spaces = "";
	static String word;
	
	
	static Stack<String> strings = new Stack<String>();
	
	public static void main(String[] args) {
		HangMan h = new HangMan();
		Utilities utilities = new Utilities();
		
		String wordAmount = JOptionPane.showInputDialog("Welcome to Hangman!" + "\n" + "How many words would you like to guess?");
		
		numWords = Integer.parseInt(wordAmount);
		for(int r =0 ; r < numWords; r++) {
		strings.push(utilities.readRandomLineFromFile("dictionary.txt"));
		}
		h.setup();
	}
	
	void setup() {
		J.add(P);
		P.add(L);
		numChar = strings.get(0).length();
		word = strings.get(0);
		System.out.println(word);
		for(int i = 0; i < numChar; i++) {
			spaces =  spaces + "_ ";
		}
		L.setText(spaces + "Lives left: " + lives);
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
		char c = e.getKeyChar();
		for(int i = 0; i < word.length(); i++) {
			if(c == word.charAt(i)) {
				spaces = spaces.substring(0, i*2) + word.charAt(i) + spaces.substring(i*2+1 , spaces.length());
				L.setText(spaces + "Lives left: " + lives);
			} else if(c != word.charAt(i)) {
				lives--;
			}
			
		}
		
		//make sure to set numChar to the new word once someone has filled in all the blanks
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
