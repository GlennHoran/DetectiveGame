package gamev2;

public class WereYouQuestions extends AbstractResponder {

	private static WereYouQuestions instance;
	
	@Override
	public String handleHere(String input, Actor a) {
		String reply = "";
		if (input.contains("happy") && input.contains("for")){
			reply = a.respond(8);
		} else {
			reply = a.respond(19);
			System.out.println("'Were you' question not recognised: " + input);
		}
		return reply;
	}
	
	

	@Override
	public String[] matchingWords() {
		// TODO Auto-generated method stub
		return new String[] {"Were you"};
	}

	// singleton method
		public synchronized static ResponderInterface getInstance() {
			if (instance == null) {
				instance = new WereYouQuestions();
			}
			return instance;

		}
}
