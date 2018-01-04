package game;

import java.util.ArrayList;

public class Angry extends AbstractResponseHandler {

	private static Angry instance;
	final String mood = "Angry";
	boolean hello = false;

	public Angry() {
		// TODO Auto-generated constructor stub
	}

	// singleton method
	public synchronized static ResponseHandler getInstance() {
		if (instance == null) {
			instance = new Angry();
		}
		return instance;

	}

	@Override
	protected void handleHere(String input, Character c) {
		// much more advanced code needed for actual conversation, maybe have a
		// conversation class?

		ArrayList<String> greetings = new ArrayList<String>();

		greetings.add("hello");
		greetings.add("hi");
		greetings.add("good morning");
		greetings.add("good evening");
		greetings.add("hey");
		greetings.add("good afternoon");

		if (hello == false) {
			
				if (greetings.contains(input.toLowerCase())) {
					System.out.println("...Hello");
					hello = true;
				} else {

					System.out.println("Aren't you going to say hello first?");
				}
			
		} else {
			// perhaps different response if hello is asked during same
			// conversation?
			if (greetings.contains(input.toLowerCase())) {
				System.out.println("Yes you've already said hello.");
				hello = true;
			} else {
				//move on to rest of conversation
				System.out.println("response not written yet");
			}
		}

	}

	public String getMood() {
		return this.mood;
	}
}
