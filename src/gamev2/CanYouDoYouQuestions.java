package gamev2;

public class CanYouDoYouQuestions extends AbstractResponder {

	private static CanYouDoYouQuestions instance;
	
	@Override
	public String handleHere(String input, Actor a) {
		String reply = "";
		if (input.contains("know") && input.contains("where") && input.contains("when") && input.contains("murdered")){
			reply = a.respond(6);
		} else if (input.contains("know") && input.contains("where") && input.contains("anyone") && input.contains("else")){
			reply = a.respond(6);
			//change this for individuals
		}else if (input.contains("know") && input.contains("whereabouts") ){
			reply = a.respond(6);
			
		}else if (input.contains("think") && input.contains("could") && input.contains("murder")){
			reply = a.respond(7);
		} 
		else if (input.contains("think") && input.contains("could") && input.contains("kill")){
			reply = a.respond(7);
		}
		else {
			
			reply = a.respond(19);
			System.out.println("'Can You'/'Do you' question response not found: " + input);
		}
		return reply;
	}

	@Override
	public String[] matchingWords() {
		// TODO Auto-generated method stub
		return new String[]{"can you", "do you"};
	}
	
	// singleton method
	public synchronized static ResponderInterface getInstance() {
		if (instance == null) {
			instance = new CanYouDoYouQuestions();
		}
		return instance;

	}

}
