package game;

import java.util.ArrayList;

public class Neutral extends AbstractResponseHandler {

	// classic singleton method used to make unique instance of class
	private static Neutral instance;
	final String mood = "Neutral";
	boolean hello = false;

	public Neutral() {
		// TODO Auto-generated constructor stub
	}

	// singleton method
	public synchronized static ResponseHandler getInstance() {
		if (instance == null) {
			instance = new Neutral();
		}
		return instance;

	}

	@Override
	protected void handleHere(String input, Character c) {

		ArrayList<String> greetings = new ArrayList<String>();

		greetings.add("Hello");
		greetings.add("Hi");
		greetings.add("Good morning");
		greetings.add("Good evening");
		greetings.add("hey");
		greetings.add("good afternoon");

		if (hello == false) {
			for (String s : greetings) {
				if (greetings.contains(input.toLowerCase())) {
					System.out.println("...Hello");
					hello = true;
				} else {

					System.out.println("Aren't you going to say hello first?");

				}
			}
		} else {
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
