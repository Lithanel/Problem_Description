import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class WrapperTestClass {

	/**
	 * Checks if the correct exception is thrown when the columnNumber is negative.
	 */
	@Test
	void negativeNumber() {
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Wrapper.wrap("Teststring", -100);
		});
		
		Assertions.assertEquals("A negative number was entered.", exception.getMessage());
	}

	/**
	 * Checks if the input string is empty. Multiple spaces are also considered as empty.
	 */
	@Test
	void stringIsNull() {
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Wrapper.wrap("   ", 0);
		});

		Assertions.assertEquals("The input String is empty.", exception.getMessage());
	}
	
	/**
	 * Even if the columnNumber is too small, it will still return at least one word per line.
	 */
	@Test
	void wrapTextWithMinimumColumnNumber() {
		String result = Wrapper.wrap("Who let the dogs out?!", 0);
		
		Assertions.assertEquals("Who\nlet\nthe\ndogs\nout?!", result);
	}
	
	@Test
	void wrapTextWithValidColumnNumber() {
		String result = Wrapper.wrap("Who let the dogs out?!", 5);
		
		Assertions.assertEquals("Who\nlet\nthe\ndogs\nout?!", result);
	}
	
	@Test 
	void wrapTextWithHighColumnNumber() {
		String result = Wrapper.wrap("This is supposed to be a very very long text!", 10);
		Assertions.assertEquals("This is\nsupposed\nto be a\nvery very\nlong text!", result);
	}
}
