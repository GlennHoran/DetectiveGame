package gamev2;

public class WhatQuestions extends AbstractResponder {

	private static WhatQuestions instance;
	private final String question = "what";
	
	@Override
	public String handleHere(String input, Actor a) {
		String reply = "";
		if (input.contains("fight") && input.contains("about")){
			reply = a.respond(4);
		} else if (input.contains("did you") && input.contains("about")&& input.contains("talk")){
			reply = a.respond(11);
		}
		else{		
			reply = a.respond(19);
			System.out.println("'What' question not recognised: " + input);
		}
		return reply;

	}

	@Override
	public String[] matchingWords() {
		return new String[] {"what", "what's"};
	}
	
	// singleton method
	public synchronized static ResponderInterface getInstance() {
		if (instance == null) {
			instance = new WhatQuestions();
		}
		return instance;
	}

	public String getQuestion() {
		return question;
	}
}
