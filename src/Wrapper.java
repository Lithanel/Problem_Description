
public class Wrapper {
	
	/**
	 * This function takes a string as input and inserts line breaks at word boundaries to ensure that
	 * lines do not  exceed the specified column number. Each line contains at least one word.
	 * @param text						The input text to be wrapped.
	 * @param columnNumber				Maximum number of characters per line.
	 * @return							Wrapped text.
	 * @throws IllegalArgumentException	Throws if columnNumber is a negative number or the input text is either empty or null.
	 */
	public static String wrap(String text, int columnNumber) {
		if(columnNumber < 0) {
			throw new IllegalArgumentException("A negative number was entered.");
		}
		if(text.isBlank()) {
			throw new IllegalArgumentException("The input String is empty.");
		}
		String[] words = text.split(" ");
		
		/* The StringBuilder class is more efficient in regard to execution time and memory usage 
		 than the normal String class. */
		StringBuilder strB = new StringBuilder();
		int lineNumber = 0;
		
		for(int i = 0; i < words.length; i++) {
			if(lineNumber > 0  && lineNumber + words[i].length() + 1 > columnNumber) {		// word.length + 1 space > columnNumber
				strB.append("\n");
				lineNumber = 0;
			}
			if(lineNumber > 0) {															// no space before first and after last word
				strB.append(" ");
				lineNumber++;
			}

			strB.append(words[i]);
			lineNumber += words[i].length();
		}
		return strB.toString();
	}
}
