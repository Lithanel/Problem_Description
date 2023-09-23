
public class Main {

	public static void main(String[] args) {
		try {
			System.out.println(Wrapper.wrap("  ", 9));
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}

}
