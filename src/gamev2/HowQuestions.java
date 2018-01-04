package gamev2;


public class HowQuestions extends AbstractResponder {

	private static HowQuestions instance;
	//may not need question string, consider removing
	private final String question = "how";
	
	
	@Override
	public String handleHere(String input, Actor a) {
		String reply = "";
		if (input.contains("are") && input.contains("you")){
			reply = a.respond(1);
		} else if (input.contains("know") && input.contains("victim")){
			reply = a.respond(2);
		} else if (input.contains("know") && input.contains("matt")){
			reply = a.respond(2);
		}else if (input.contains("you") && input.contains("feel") && input.contains("proposed")){
			reply = a.respond(3);
		} else if (input.contains("you") && input.contains("feel") && input.contains("proposal")){
			reply = a.respond(3);
		} else {
			reply = a.respond(19);
			System.out.println("'How' Question not recognised: " + input);
		} return reply;
		}


	@Override
	public String[] matchingWords() {
		
		return new String[] {"how", "how's"};
	}

	
	// singleton method
	public synchronized static ResponderInterface getInstance() {
		if (instance == null) {
			instance = new HowQuestions();
		}
		return instance;

	}

	public String getQuestion() {
		return question;
	}
}
