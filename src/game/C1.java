package game;

import java.util.ArrayList;
import java.util.List;
/**
 * This is the main character class that contains all the responses for one character.
 * All of the conversation occurs in the "Respond" method which takes a String. 
 * This method is called in a loop in the main class. 
 * 
 * @author Glenn
 *
 */
public class C1 implements Character {
 
	private String name = "Steve";
	private String emotion;

	//constructor
	public C1(String emotion) {
		this.emotion = emotion;
	
		//getters setters
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmotion() {
		return emotion;
	}

	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}

	

//chain of command pattern to be used here to organise all responses into a tree.

}