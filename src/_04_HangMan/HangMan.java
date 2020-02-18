package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {

	static JFrame J = new JFrame();
	static JPanel P = new JPanel();
	static JLabel L = new JLabel();

	static int numWords;
	static int lives = 10;
	static int numChar;
	static int wordNum = 0;
	static int level = 0;

	static String spaces = "";
	static String word;
	static String checker = "";

	static boolean lifeBool;
	static boolean isNum;

	static Stack<String> strings = new Stack<String>();

	public static void main(String[] args) {
		HangMan h = new HangMan();
		Utilities utilities = new Utilities();

		String wordAmount = JOptionPane
				.showInputDialog("Welcome to Hangman!" + "\n" + "How many words would you like to guess?");

		while (isNum == false) {
			// checks whether wordAmount is between 0 and 266
			if (numWords == 0 || numWords >= 267 || numWords < 0) {
				JOptionPane.showMessageDialog(null, "Please choose a number between 0 and 266");
				wordAmount = JOptionPane
						.showInputDialog("Welcome to Hangman!" + "\n" + "How many words would you like to guess?");
			} else if(numWords < 0 & numWords <= 266) {
				isNum = true;
			}

			// checks whether wordAmount is a int
			if (isNum == false) {
				if (digitChecker(wordAmount) == true) {
					numWords = Integer.parseInt(wordAmount);
					isNum = true;
				} else if (digitChecker(wordAmount) == false) {
					JOptionPane.showMessageDialog(null, "Please choose a number between 0 and 266");
					wordAmount = JOptionPane
							.showInputDialog("Welcome to Hangman!" + "\n" + "How many words would you like to guess?");
				}
			}
		}

		for (int r = 0; r < numWords; r++) {
			strings.push(utilities.readRandomLineFromFile("dictionary.txt"));
		}
		h.setup();
	}

	void setup() {
		J.add(P);
		P.add(L);
		numChar = strings.get(level).length();
		word = strings.get(level);
		System.out.println(word);
		for (int i = 0; i < numChar; i++) {
			spaces = spaces + "_ ";
			checker = checker + ' ';
		}
		L.setText(spaces + "    Lives left: " + lives);
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
		lifeBool = false;
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		for (int i = 0; i < word.length(); i++) {
			if (c == word.charAt(i)) {
				spaces = spaces.substring(0, i * 2) + word.charAt(i) + spaces.substring(i * 2 + 1, spaces.length());
				L.setText(spaces + "    Lives left: " + lives);
				lifeBool = true;

			}

		}
		for (int k = 0; k < spaces.length(); k += 2) {
			checker = checker + spaces.charAt(k);
		}
		if (checker.equalsIgnoreCase(word)) {
			level++;
			lives = 10;
			JOptionPane.showMessageDialog(null, "Nice Job! You Passed!");
			L.setText("");
			spaces = "";
			numChar = strings.get(level).length();
			word = strings.get(level);
			System.out.println(word);
			for (int k = 0; k < numChar; k++) {
				spaces = spaces + "_ ";
			}
			L.setText(spaces + "    Lives left: " + lives);
			J.pack();
		} else {
			checker = "";
		}
		if (lifeBool != true) {
			lives--;
			L.setText(spaces + "    Lives left: " + lives);
		}
		if (lives == 0) {
			JOptionPane.showMessageDialog(null, "You ran out of lives!\nThe word was " + word);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static boolean digitChecker(String m) {
		for (int i = 0; i < m.length(); i++) {
			if (!Character.isDigit(m.charAt(i))) {
				return false;
			}

		}
		return true;

	}
}
