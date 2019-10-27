package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other
	// button reads "View Names".
	// When the add name button is clicked, display an input dialog that asks the
	// user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a
	// message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners

	JFrame J = new JFrame();
	JPanel P = new JPanel();
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	ArrayList<String> names = new ArrayList<String>();
	

	public static void main(String[] args) {
		_02_GuestBook G = new _02_GuestBook();
		G.showButton();

	}

	public void showButton() {
		J.add(P);
		J.setTitle("Guest Book");
		P.add(b1);
		P.add(b2);
		b1.setText("View Names");
		b1.addActionListener(this);
		b2.setText("Add Name");
		b2.addActionListener(this);
		J.pack();
		J.setVisible(true);
		J.setSize(500, 500);
		names.add("Bob Banders");
		names.add("Sandy Summers");
		names.add("Greg Ganders");
		names.add("Donny Donners");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == b1) {
			String s = "";
			for (int i = 0; i < names.size(); i++) {
				s += "Guest #"+ (i+1) + " "+ names.get(i) +"\n";
			}
			JOptionPane.showMessageDialog(null, s);
		J.pack();
		J.setSize(500, 500);

		} else if (e.getSource() == b2) {
			String s = JOptionPane.showInputDialog("Who would you like to add?");
			names.add(s);
			JOptionPane.showMessageDialog(null, "Added " + s + "!");
			J.pack();
			J.setSize(500, 500);
		}
	}

}
