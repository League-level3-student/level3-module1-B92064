package _03_IntroToStacks;

import java.util.Random;

import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
		Random rand = new Random();
		
		Stack<Double> doubles = new Stack<Double>();
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		for(int i = 0; i < 100; i++) {
			int random = rand.nextInt(100);
			double d = rand.nextDouble();
			doubles.push(d+random);
		}
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
		String q1 = JOptionPane.showInputDialog("Enter a number between 0 and 100, inclusive.");
		String q2 = JOptionPane.showInputDialog("Enter another number between 0 and 100, inclusive.");
		
		int num1 = Integer.parseInt(q1);
		int num2 = Integer.parseInt(q2);
		int greater = 0;
		int lesser = 0;
		
		if(num1 > num2) {
			greater = num1;
			lesser = num2;
		} else if(num1 < num2) {
			greater = num2;
			lesser = num1;
		}
		
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
		System.out.println("Popping elements off stack...");
		System.out.println("Elements between " + lesser + " and " + greater + ":");
		for(int i = 0; i < doubles.size(); i++){
			double p = doubles.pop();
			if(p < greater && p > lesser) {
			System.out.println(p);
		}
		
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}
}
