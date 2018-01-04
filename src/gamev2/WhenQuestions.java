package gamev2;

public class WhenQuestions extends AbstractResponder {

	private static WhenQuestions instance;
	private final String question = "when";
	
	@Override
	public String handleHere(String input, Actor a) {
		String reply = "";
		System.out.println("'When' question not recognised: " + input);
		reply = a.respond(19);
		return reply;

	}

	@Override
	public String[] matchingWords() {
		return new String[] {"when", "when's"};
	}

	
	// singleton method
	public synchronized static ResponderInterface getInstance() {
		if (instance == null) {
			instance = new WhenQuestions();
		}
		return instance;

	}

	public String getQuestion() {
		return question;
	}
}
