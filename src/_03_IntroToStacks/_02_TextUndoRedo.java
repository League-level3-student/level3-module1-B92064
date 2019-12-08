package _03_IntroToStacks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */

	static JFrame J = new JFrame();
	static JPanel P = new JPanel();
	static JLabel L = new JLabel();
	Stack<String> s = new Stack<String>();
	
	public static void main(String[] args) {
		_02_TextUndoRedo t = new _02_TextUndoRedo();
		t.setup();
		
		
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
		int ll = L.getText().length()-1;
		char c = e.getKeyChar();
		L.setText(L.getText() + c);
		
		if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
			String s = L.getText().substring(0, ll);
			L.setText(L.getText().substring(0, ll));
		}
		if(e.getKeyChar() == KeyEvent.VK_CAPS_LOCK) {
			L.setText(L.getText() + s);
		}
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
