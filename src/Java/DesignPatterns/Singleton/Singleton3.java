package Java.DesignPatterns.Singleton;

public class Singleton3 {

	private final static Singleton3 INSTANCE = new Singleton3();

	private Singleton3() {
		// Exists only to defeat instantiation.
	}

	public static Singleton3 getInstance() {
		return INSTANCE;
	}
}
