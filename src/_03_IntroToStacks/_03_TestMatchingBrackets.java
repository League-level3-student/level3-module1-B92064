package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.event.KeyEvent;
import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		Stack<String> checker = new Stack<String>();
		for(int r = 0; r < b.length(); r++) {
			if(b.charAt(r) == '{') {
				checker.push("f");
				System.out.println("pushed");
			} else if(b.charAt(r) == '}') {
				if(checker.isEmpty()) {
					return false;
				} else {
					checker.pop();
				}

			}
		}
		if(checker.isEmpty()) {
		return true;
		} else {
			return false;
		}
	}

}