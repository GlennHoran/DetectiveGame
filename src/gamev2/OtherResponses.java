package gamev2;

public class OtherResponses extends AbstractResponder {

	private static OtherResponses instance;
	private final String question = "other";
	
	@Override
	public String handleHere(String input, Actor a) {
		String reply = "";
		if (input.contains("did") && input.contains("you")&& input.contains("kill")){
			reply = a.respond(10);
		} else if (input.contains("did") && input.contains("you")&& input.contains("murder")) {
			reply = a.respond(10);			
		}else if (input.contains("you") && input.contains("murdered")&& input.contains("matt")) {
			reply = a.respond(10);			
		}else if (input.contains("you") && input.contains("are")&& input.contains("murderer")) {
			reply = a.respond(10);			
		}else if (input.contains("you're") && input.contains("the")&& input.contains("murderer")) {
			reply = a.respond(10);			
		}
		else if (input.contains("thank") || input.contains("thanks")) {
			reply = a.respond(13);			
		}
		else {
			reply = a.respond(19);
			System.out.println("Other Question not found: "  + input);
		}
		return reply;
	}
	

	@Override
	public String[] matchingWords() {
		// TODO Auto-generated method stub
		return new String[] {};
	}
	
	// singleton method
		public synchronized static ResponderInterface getInstance() {
			if (instance == null) {
				instance = new OtherResponses();
			}
			return instance;

		}

		public String getQuestion() {
			return question;
		}

}
