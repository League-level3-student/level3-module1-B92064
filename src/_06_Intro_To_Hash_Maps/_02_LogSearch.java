package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	HashMap<Integer, String> ID = new HashMap<Integer, String>();
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JButton b4 = new JButton();

	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 *
	 */
	public static void main(String[] args) {
		_02_LogSearch ls = new _02_LogSearch();
		ls.setup();
	}

	public void setup() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b1.setText("Add Entry");
		b2.setText("Search by ID");
		b3.setText("View List");
		b4.setText("Remove Entry");
		frame.setLocation(1150, 600);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b1) {
			String q1string = JOptionPane.showInputDialog("Enter an ID number");
			int q1 = Integer.parseInt(q1string);
			String q2 = JOptionPane.showInputDialog("Enter a name");
			ID.put(q1, q2);
		} else if (e.getSource() == b2) {
			String q3string = JOptionPane.showInputDialog("Enter a message ID");
			if (q3string.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please input a number");
			}
			int q3 = Integer.parseInt(q3string);
			if (ID.get(q3) == null) {
				JOptionPane.showMessageDialog(null, "That Entry does not exist.");
			} else {
				JOptionPane.showMessageDialog(null, "ID: " + q3 + " Name: " + ID.get(q3));
			}
		} else if (e.getSource() == b3) {
			String text = new String();
			for (Integer s : ID.keySet()) {
				text += "ID: " + s + " Name: " + ID.get(s) + " ";
			}
			JOptionPane.showMessageDialog(null, text);

		} else if (e.getSource() == b4) {
			String q4string = JOptionPane.showInputDialog("Which entry would you like to delete?");
			int q4 = Integer.parseInt(q4string);
			if (ID.get(q4) == null) {
				JOptionPane.showMessageDialog(null, "That Entry does not exist.");
			} else {
				ID.remove(q4);
				JOptionPane.showMessageDialog(null, "Entry " + q4 + " has been removed.");
			}
		}
	}
}
