package gamev2;

public class WhoQuestions extends AbstractResponder {

	private static WhoQuestions instance;
	private final String question = "who";
	
	@Override
	public String handleHere(String input, Actor a) {
		String reply = "";
		reply = a.respond(19);
		System.out.println("Who question not recognised: " + input);
		return reply;
	

	}

	@Override
	public String[] matchingWords() {
		return new String[]{"who", "who's"};
	}

	// singleton method
	public synchronized static ResponderInterface getInstance() {
		if (instance == null) {
			instance = new WhoQuestions();
		}
		return instance;

	}

	public String getQuestion() {
		return question;
	}
}
