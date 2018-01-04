package gamev2;

/**
 * class for managing chain of responsibility for input from user. this class
 * takes the input and attempts to "handle" the message by sending the user
 * input through a sequence of classes, each looking for specific keywords to
 * signal that they can handle the message.
 * 
 * @author Glenn
 *
 */
public abstract class AbstractResponder implements ResponderInterface {

	ResponderInterface nextHandler;

	@Override
	public void setNextHandler(ResponderInterface responder) {
		nextHandler = responder;

	}

	// processes the input to determine if it contains a key word listed in each
	// question class
	@Override
	public String processHandler(String input, Actor a) {
		String response = "";
		input = input.toLowerCase();
		// remove and from start of string to help question recogniser
		if (input.indexOf("and") == 0) {
			input = input.substring(4);
		} else if (input.indexOf("so") == 0) {
			input = input.substring(3);
		}
		boolean wordFound = false;
		// if there are no keywords listed in a class, then the class will
		// handle all other phrases(OtherResponses class)
		if (matchingWords().length == 0) {
			wordFound = true;
		} else {
			// searches through each key word listed in "matching words" for
			// each class and
			// changes wordFound boolean to true if keyword is in input phrase.
			for (String word : matchingWords()) {
				// needed to search only for the first 3 words of the input in
				// case more than one key word appears in sentence
				if (input.indexOf(word) >= 0 && input.indexOf(word) <= 3) {
					wordFound = true;
					break;
				} 
			}
		}
		// handles in whichever class the word is found
		if (wordFound) {
			response = handleHere(input, a);

		} else {
			// passes phrase onto next class
			response = nextHandler.processHandler(input, a);
		}
		return response;
	}

	/*
	 * Chain of responsibility pattern initialisation. instantiates each class
	 * and sets up order of passing of input through classes until class is
	 * found that can deal with the input
	 */

	public static String handle(String input, Actor a) {
		// Create the handler objects...
		ResponderInterface greetings = Greetings.getInstance();
		ResponderInterface how = HowQuestions.getInstance();
		ResponderInterface what = WhatQuestions.getInstance();
		ResponderInterface when = WhenQuestions.getInstance();
		ResponderInterface where = WhereQuestions.getInstance();
		ResponderInterface who = WhoQuestions.getInstance();
		ResponderInterface why = WhyQuestions.getInstance();
		ResponderInterface were = WereYouQuestions.getInstance();
		ResponderInterface CanDo = CanYouDoYouQuestions.getInstance();
		ResponderInterface accusation = Accusation.getInstance();
		ResponderInterface other = OtherResponses.getInstance();
		// Chain them together...
		greetings.setNextHandler(how);
		how.setNextHandler(what);
		what.setNextHandler(when);
		when.setNextHandler(where);
		where.setNextHandler(who);
		who.setNextHandler(why);
		why.setNextHandler(were);
		were.setNextHandler(CanDo);
		CanDo.setNextHandler(accusation);
		accusation.setNextHandler(other);
		// Start the ball rolling...
		return greetings.processHandler(input, a);
	}

	public abstract String handleHere(String input, Actor a);

	public abstract String[] matchingWords();
}
