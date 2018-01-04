package gamev2;

public class WhereQuestions extends AbstractResponder {

	private static WhereQuestions instance;
	//use to pass into actor to determine what kind of question 
	private final String question = "where";
	@Override
	public String handleHere(String input, Actor a) {
		String reply;
		if (input.contains("were") && input.contains("murdered") && input.contains("you")){
			reply = a.respond(5);
		} else if (input.contains("were") && input.contains("killed") && input.contains("you")) {
			reply = a.respond(5);
		}else if (input.contains("were") && input.contains("murder") && input.contains("you")) {
			reply = a.respond(5);
		}else if (input.contains("are") && input.contains("killed") && input.contains("you")) {
			reply = a.respond(5);
		}else if (input.contains("are") && input.contains("murdered") && input.contains("you")) {
			reply = a.respond(5);
		}
		else {
			System.out.println("'where' question not recognised: " + input);
			 reply = a.respond(19);
		}
		return reply;
	}

	@Override
	public String[] matchingWords() {
		return new String[] {"where", "where's"};
	}
	
	// singleton method
	public synchronized static ResponderInterface getInstance() {
		if (instance == null) {
			instance = new WhereQuestions();
		}
		return instance;

	}

	public String getQuestion() {
		return question;
	}

}
