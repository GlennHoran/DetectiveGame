package gamev2;


public class Greetings extends AbstractResponder {

	private static Greetings instance;
	boolean hello = false;
	private static final String question = "greeting";

	// replies hello to greetings phrases.
	@Override
	public String  handleHere(String input, Actor a) {
		return a.respond(0);

		
	}

	
	@Override
	public String[] matchingWords() {
		return new String[] { "hi", "hello", "hey", "good morning", "good evening", "good efternoon" };
	}

	// singleton method to ensure only one instance of this class is instantiated. 
	public synchronized static ResponderInterface getInstance() {
		if (instance == null) {
			instance = new Greetings();
		}
		return instance;

	}
}
