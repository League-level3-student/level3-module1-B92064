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

	static HangMan h = new HangMan();

	// NEED TO POP OFF THE STACK

	static Stack<String> strings = new Stack<String>();
	static Utilities utilities;

	public static void main(String[] args) {
		utilities = new Utilities();
		h.whichWord();
		for (int r = 0; r < numWords; r++) {
			strings.push(utilities.readRandomLineFromFile("dictionary.txt"));
		}
		h.setup();
	}

	void setup() {
		lives = 10;
		J.add(P);
		P.add(L);
		word = strings.pop();
		numChar = word.length();
//		System.out.println(word);
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

			if (level == numWords) {
				JOptionPane.showMessageDialog(null, "You guessed all the words! Good job!");
				int keepGoing = JOptionPane.showConfirmDialog(null, "Would you like to continue?");
//				System.out.println(keepGoing);
				if (keepGoing == 1) {
					System.exit(0);
				} else if (keepGoing == 0) {
					lives = 10;
					level = 0;
					spaces = "";
					checker = "";
					lifeBool = true;
					h.whichWord();
					for (int r = 0; r < numWords; r++) {
						strings.push(utilities.readRandomLineFromFile("dictionary.txt"));
					}
					h.setup();
				} else if (keepGoing == 2) {
					System.exit(0);
				}
			} else {

				L.setText("");
				spaces = "";
//				System.out.println("Level: " + level);
//				System.out.println("Number of Words: " + numWords);
				word = strings.pop();
				numChar = word.length();
//				System.out.println(word);
				for (int k = 0; k < numChar; k++) {
					spaces = spaces + "_ ";
				}
				lives = 10;
				L.setText(spaces + "    Lives left: " + lives);
				J.pack();
			}
		} else {
			checker = "";
		}
		if (lifeBool != true) {
			lives--;
			L.setText(spaces + "    Lives left: " + lives);
		}
		if (lives == 0) {
			JOptionPane.showMessageDialog(null, "You ran out of lives!\nThe word was " + word);
			int keepGoing = JOptionPane.showConfirmDialog(null, "Would you like to continue?");
//			System.out.println(keepGoing);
			if (keepGoing == 1) {
				System.exit(0);
			} else if (keepGoing == 0) {
				lives = 10;
				level = 0;
				spaces = "";
				checker = "";
				lifeBool = true;
				h.whichWord();
				for (int r = 0; r < numWords; r++) {
					strings.push(utilities.readRandomLineFromFile("dictionary.txt"));
				}
				h.setup();
			} else if (keepGoing == 2) {
				System.exit(0);
			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static void whichWord() {
		isNum = false;
		while (isNum == false) {
			String wordAmount = JOptionPane
					.showInputDialog("Welcome to Hangman!" + "\n" + "How many words would you like to guess?");
			
			if (!wordAmount.isEmpty()) {

				// checks whether wordAmount is between 0 and 266
				numWords = Integer.parseInt(wordAmount);
				if (numWords < 1 || numWords > 266) {
					JOptionPane.showMessageDialog(null, "Please choose a number between 0 and 266");
					wordAmount = JOptionPane
							.showInputDialog("Welcome to Hangman!" + "\n" + "How many words would you like to guess?");
				} else if (!wordAmount.isEmpty()) {
					isNum = true;
				}

				// checks whether wordAmount is a int
				if (isNum == false) {
					if (digitChecker(wordAmount) == true) {
						numWords = Integer.parseInt(wordAmount);
						if (!wordAmount.isEmpty()) {
							isNum = true;
						}
					} else if (digitChecker(wordAmount) == false) {
						JOptionPane.showMessageDialog(null, "Please choose a number between 0 and 266");
						wordAmount = JOptionPane.showInputDialog(
								"Welcome to Hangman!" + "\n" + "How many words would you like to guess?");
					}
				}

			} else if (wordAmount.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please choose a number between 0 and 266");
			}
		}

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
