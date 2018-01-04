package gamev2;

public class WhyQuestions extends AbstractResponder {
//look into putting in mechanics for general follow up questions here
	private static WhyQuestions instance;
	private final String question = "why";
	
	@Override
	public String handleHere(String input, Actor a) {
		String reply = "";
		reply = a.respond(19);
		System.out.println("Why question not recognised: " + input);
		return reply;

	}

	@Override
	public String[] matchingWords() {
		return new String[] {"why", "why's"};
	}

	// singleton method
	public synchronized static ResponderInterface getInstance() {
		if (instance == null) {
			instance = new WhyQuestions();
		}
		return instance;

	}
	
}
