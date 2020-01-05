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
	Stack<String> s = new Stack<String>();
	
	public static void main(String[] args) {
		String wordAmount = JOptionPane.showInputDialog("Welcome to Hangman! /n" + "How many words would you like to guess?");
		HangMan h = new HangMan();
		
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
