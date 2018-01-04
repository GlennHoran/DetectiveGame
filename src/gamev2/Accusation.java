package gamev2;

public class Accusation extends AbstractResponder {
	
	private static Accusation instance;
	//may not need question string, consider removing
	private final String question = "accusation";
	
	
	@Override
	public String handleHere(String input, Actor a) {
		return a.respond(9);
		}


	@Override
	public String[] matchingWords() {
		
		return new String[] {"you're lying", "your lying", "that's a lie", "liar", "lying", "lie"};
	}

	
	// singleton method
	public synchronized static ResponderInterface getInstance() {
		if (instance == null) {
			instance = new Accusation();
		}
		return instance;

	}

	public String getQuestion() {
		return question;
	}
}
