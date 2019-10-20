package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
ArrayList<String> alphabet = new ArrayList<String>();
		//2. Add five Strings to your list
		alphabet.add("A");
		alphabet.add("B");
		alphabet.add("C");
		alphabet.add("D");
		alphabet.add("e");
		
		//3. Print all the Strings using a standard for-loop
		System.out.println(alphabet);
		
		//4. Print all the Strings using a for-each loop
		for(int i = 0; i< alphabet.size(); i++) {
			System.out.println(alphabet.get(i));
		}
		System.out.println();
		//5. Print only the even numbered elements in the list.
		for(int i = 0; i< alphabet.size(); i++) {
			if((i+1) %2 == 0) {
			System.out.println(alphabet.get(i));
			}
		}
		System.out.println();
		//6. Print all the Strings in reverse order.
		for(int i = alphabet.size(); i> 0; i--) {
			System.out.println(alphabet.get(i-1));
		}
		//7. Print only the Strings that have the letter 'e' in them.
		System.out.println();
		for(int i = 0; i< alphabet.size(); i++) {
			if(alphabet.get(i).contains("e"))
			System.out.println(alphabet.get(i));
		}
	}
}
