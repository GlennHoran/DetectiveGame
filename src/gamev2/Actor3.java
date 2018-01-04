package gamev2;

import java.util.Arrays;

public class Actor3 implements Actor {

	// stores the question id of last question
	private int lastQuestion;
	// determine if last question answered was a lie or not (true = truth, false
	// = lie)
	private boolean lastQuestionTruth = true;
	// string to track mood in order to get different question responses
	private String mood;
	// character name
	private String name = "Verity";
	// index of list is the question ID
	private Boolean[] answers;
	// keeps track of how many lies have been caught
	private static int lieCount = 0;
	private static int falseLieCount = 0;

	private Boolean caseSolved = false;

	// constructor
	public Actor3(String mood, String name) {
		this.mood = mood;
		this.name = name;
		answers = new Boolean[25];
		Arrays.fill(answers, false);
	}

	/**
	 * "Brains" of the program. Uses switch statement to determine which
	 * question is to be answered from the Responder classes using a questionId
	 * Each switch case has an if/else statement to respond based on the "mood"
	 * of the actor lastQuestion answered is stored for conversation trees
	 * (stored in the form of question ID). once question has been asked, the
	 * corresponding ID is marked as ask in the array of booleans (answers) A
	 * second switch statement is used to store the answers of each question if
	 * it has already been asked. finally, answers that are lies change the
	 * "lastQuestionTruth" boolean to false so that a lie accusation can be
	 * dealt with. If The user correctly identifies a lie, this changes the mood
	 * of the "actor" and different responses are unlocked.
	 */
	public String respond(int questionId) {
		String reply = "";
		// checks if question has been asked already
		if (answers[questionId] == false) {
			switch (questionId) {
			// greeting response
			case 0:
				reply = "Hi";
				setLastQuestion(0);
				markAnswered(questionId, answers);
				break;
			// How are you?
			case 1:
				reply = "I'm a bit shook up. I've never seen a dead body before";

				setLastQuestion(1);
				markAnswered(questionId, answers);
				break;

			case 2:
				reply = "He was my boyfriend Johns best friend, we were not that close";
				setLastQuestion(2);
				markAnswered(questionId, answers);
				break;
			// How did you feel when Matt proposed
			case 3:
				if (mood.equals("neutral")) {
					reply = "I was delighted! they seem very right for each other";
					lastQuestionTruth = false;
				} else if (mood.equals("open")) {
					reply = "I was ecstatic. Deep down I guess I know that my John still likes Caitlin, she was now out of the picture";
					lastQuestionTruth = true;
				} else {
					reply = "I was really happy. I know John used to like Caitlin, I don't think he was too happy about the proposal, he got very drunk.";
					lastQuestionTruth = true;
				}
				setLastQuestion(3);
				markAnswered(questionId, answers);
				markAnswered(8, answers);
				break;
			// What was the the fight about?
			case 4:
				if (mood.equals("neutral")) {
					reply = "Oh I don't know, I wasn't really listening...";

					lastQuestionTruth = false;
				} else if (mood.equals("open")) {
					reply = "So he wanted to sell the business, but she was the one who came up with and developed the idea.";
					lastQuestionTruth = true;
				} else {
					reply = "ok, I was listening. It was hard not to, they were really going at it. I think it was something to do with selling the business"
							+ "it sounded like a good idea to me!";
					lastQuestionTruth = true;
				}
				setLastQuestion(4);
				markAnswered(questionId, answers);
				break;
			// Where were you when the victim was Murdered?
			case 5:
				reply = "I must have been asleep. I went to bed after I saw John had passed out in the living room";
				setLastQuestion(5);
				markAnswered(questionId, answers);
				break;
			// Do you know the whereabouts of anyone else when Matt was
			// murdered?
			case 6:
				if (lieCount<1) {
					reply = "I've no idea, everyone was asleep";
					lastQuestionTruth = false;
				}else if (lieCount ==1) {
					reply = "well.. I think i heard some movement in the hall during the night. Samantha or Caitlin was awake";
					lastQuestionTruth = false;
				}else if (lieCount ==2) {
					reply = "I heard someone walking through the hall, then talking downstairs. I think John and Samantha were talking";
					lastQuestionTruth = false;
				} else if (mood.equals("open")) {
					reply = "I heard Samantha and John talking downstairs late in the night, I don't know what time it was";
					lastQuestionTruth = true;
				} 
				setLastQuestion(6);
				markAnswered(questionId, answers);
				break;
			// Do you think anyone could kill Matt?
			case 7:
				if (mood.equals("neutral")) {
					reply = "No absolutely not";
					lastQuestionTruth = false;
				} else if (mood.equals("open")) {
					reply = "Nobody more than John.. he loves Caitlin, I can tell. But I don't think he would ever murder anyone and he was passed out all night";
					lastQuestionTruth = true;
				} else {
					reply = "I don't think anyone is capable of murder, but Sam, John and Caitlin have all benefitted from this.";
					lastQuestionTruth = true;
				}
				setLastQuestion(7);
				markAnswered(questionId, answers);
				break;
			case 9:
				if (lastQuestion == 0) {
					reply = "Are you feeling OK detective? I just said hi";
					break;
				} else {
					if (lastQuestionTruth) {
						falseLieCount++;
						if (falseLieCount <= 1) {
							reply = "I'm not lying";
						} else if (falseLieCount <= 2) {
							reply = "Still not lying detective";
						} else if (falseLieCount >= 3) {
							reply = "nope, you seem to have trust issues...";
						}
						break;
					} else {
						markUnanswered(lastQuestion, answers);

						lieCount++;
						if (lieCount <= 1) {
							mood = "nervous";
							markAllUnaswered();
							reply = "well it's not exactly a lie, but " + respond(lastQuestion);

							break;
						} else if (lieCount >= 2) {
							mood = "open";
							markAllUnaswered();
							reply = "hmm it may not have been the whole truth.. " + respond(lastQuestion);
						}
						break;
					}
				}
			case 10:
				if (mood.equals("neutral")) {
					reply = "Of course I didn't murder him";
				} else if (mood.equals("open")) {
					reply = "No detective... that wouldn't benefit me in anyway";
					caseSolved = true;
				} else {
					reply = "no! detective, how could you even ask that?";
				}
				setLastQuestion(10);
				markAnswered(questionId, answers);
				break;
			case 13:
				reply = "You're welcome";
			// default response
			case 19:
				reply = "what are you talking about?";
				break;
			}

			// if question has already been asked:
		} else {
			switch (questionId) {
			// greeting response
			case 0:
				reply = "Hi";
				setLastQuestion(0);
				markAnswered(questionId, answers);
				break;
			// How are you?
			case 1:
				reply = "Like I said last time, I'm shook up";
				lastQuestionTruth = true;

				setLastQuestion(1);
				markAnswered(questionId, answers);
				break;

			case 2:
				reply = "as I said, he was John's best friend";
				lastQuestionTruth = true;
				setLastQuestion(2);
				markAnswered(questionId, answers);
				break;
			// How did you feel when Matt proposed

			case 3:
				if (mood.equals("neutral")) {
					reply = "Delighted!";
					lastQuestionTruth = false;
				} else if (mood.equals("open")) {
					reply = "I was ecstatic. Deep down I guess I know that my John still likes Caitlin, she was now out of the picture";
					lastQuestionTruth = true;
				} else {
					reply = "as i said, I was really happy, for them and for me.";
					lastQuestionTruth = true;
				}
				setLastQuestion(3);
				markAnswered(questionId, answers);
				markAnswered(8, answers);
				break;
			// What was the the fight about?
			case 4:
				if (mood.equals("neutral")) {
					reply = "like i said i wasn't listneing to the fight. that would be rude";

					lastQuestionTruth = false;
				} else if (mood.equals("open")) {
					reply = "So he wanted to sell the business, but she was the one who came up with and developed the idea.";
					lastQuestionTruth = true;
				} else {
					reply = "I told you already, he wanted to sell their business but she wanted to keep it";
					lastQuestionTruth = true;
				}
				setLastQuestion(4);
				markAnswered(questionId, answers);
				break;
			// Where were you when the victim was Murdered?
			case 5:
				reply = "Like I said, I was in my room all night";
				lastQuestionTruth = true;
				setLastQuestion(5);
				markAnswered(questionId, answers);
				break;
			// Do you know the whereabouts of anyone else when Matt was
			// murdered?
			case 6:
				if (lieCount<1) {
					reply = "like I said, I've no idea, everyone was asleep";
					lastQuestionTruth = false;
				}else if (lieCount ==1) {
					reply = "I told you, samantha or Caitlin must have been awake because I heard movement in the halls during the night";
					lastQuestionTruth = false;
				}else if (lieCount ==2) {
					reply = "I told you, I think John and Samantha were talking";
					lastQuestionTruth = false;
				} else if (mood.equals("open")) {
					reply = "I heard Samantha and John talking downstairs late in the night, I don't know what time it was";
					lastQuestionTruth = true;
				} 
				setLastQuestion(6);
				markAnswered(questionId, answers);
				break;
			// Do you think anyone could kill Matt?
			case 7:
				if (mood.equals("neutral")) {
					reply = "No absolutely not";
					lastQuestionTruth = false;
				} else if (mood.equals("open")) {
					reply = "don't make me say it again..Nobody more than John.. but he was passed out all night";
					lastQuestionTruth = true;
				} else {
					reply = "I don't think anyone is capable of murder, but Sam, John and Caitlin have all benefitted from this.";
					lastQuestionTruth = true;
				}
				setLastQuestion(7);
				markAnswered(questionId, answers);
				break;
			case 9:
				if (lastQuestion == 0) {
					reply = "Are you feeling OK detective? I just said hi";
					break;
				} else {
					if (lastQuestionTruth) {
						falseLieCount++;
						if (falseLieCount <= 1) {
							reply = "I'm not lying";
						} else if (falseLieCount <= 2) {
							reply = "Still not lying detective";
						} else if (falseLieCount >= 3) {
							reply = "nope, you seem to have trust issues...";
						}
						break;
					} else {
						markUnanswered(lastQuestion, answers);

						lieCount++;
						if (lieCount <= 1) {
							mood = "nervous";
							markAllUnaswered();
							reply = "well it's not exactly a lie, but " + respond(lastQuestion);

							break;
						} else if (lieCount >= 2) {
							mood = "open";
							markAllUnaswered();
							reply = "hmm it may not have been the whole truth.. " + respond(lastQuestion);
						}
						break;
					}
				}
			case 10:
				if (mood.equals("neutral")) {
					reply = "Of course I didn't murder him";
				} else if (mood.equals("open")) {
					reply = "No detective... that wouldn't benefit me in anyway";
					caseSolved = true;
				} else {
					reply = "no! detective, how could you even ask that?";
				}
				setLastQuestion(10);
				markAnswered(questionId, answers);
				break;
			// default response
			case 19:
				reply = "I'm afraid I don't understand the question";
				break;
			}
		}
		return reply;

	}

	public void markAnswered(int questionId, Boolean[] questionList) {
		questionList[questionId] = true;
	}
	public void markAllUnaswered(){
		Arrays.fill(answers, false);
	}

	public void markUnanswered(int questionId, Boolean[] questionList) {
		questionList[questionId] = false;
	}

	@Override
	public String getMood() {
		// TODO Auto-generated method stub
		return this.mood;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public int getLastQuestion() {
		return lastQuestion;
	}

	public void setLastQuestion(int lastQuestion) {
		this.lastQuestion = lastQuestion;
	}

	@Override
	public boolean getCaseSolved() {
		// TODO Auto-generated method stub
		return false;
	}

}