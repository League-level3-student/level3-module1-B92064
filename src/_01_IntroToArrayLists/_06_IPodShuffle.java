package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	JFrame J = new JFrame();
	JPanel P = new JPanel();
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	Random rand = new Random();
	int r1 = rand.nextInt(5);
	static ArrayList<Song> jukebox = new ArrayList<Song>(); 
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
	}

	
	
	public static void main(String[] args) {
		
		  new _06_IPodShuffle(); 
		  
		  Song demo = new Song("demo.mp3"); 
		  Song Ra = new Song("Rick Astley - Never Gonna Give You Up (Video).mp3");
		  Song MI = new Song("Monsters Inc Theme (EAR RAPE).mp3");
		  Song NS = new Song("Why cant you handle the neutron style.mp3");
		  Song SPM = new Song("Sad Piano Music (THIS WILL MAKE YOU CRY Saddest Piano and Violin Ever!).mp3");
		  
		  jukebox.add(demo);
		  jukebox.add(Ra);
		  jukebox.add(MI);
		  jukebox.add(NS);
		  jukebox.add(SPM);
		  
				
//		demo.setDuration(147);
//		demo.play();
		_06_IPodShuffle ipod = new _06_IPodShuffle();
		ipod.addButton();
		
	}
	private void addButton() {
		J.add(P);
		P.add(b1);
		P.add(b2);
		P.add(b3);
		b1.setText("Play");
		b1.addActionListener(this);
		b2.setText("Surprise Me!");
		b2.addActionListener(this);
		b3.setText("Pause");
		b3.addActionListener(this);
		J.setSize(700,700);
		J.setVisible(true);
		J.pack();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0; i<5; i++) {
			jukebox.get(i).stop();
		}
		if(e.getSource()== b1) {
			jukebox.get(1);
		} else if(e.getSource() == b2) {
			r1 = rand.nextInt(4);
			jukebox.get(r1);
			
		} else if(e.getSource() == b3) {
			
		}
	}
}