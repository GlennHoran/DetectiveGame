package gamev2;

import java.util.Arrays;

public class Actor4 implements Actor {

	// stores the question id of last question
	private int lastQuestion;
	// determine if last question answered was a lie or not (true = truth, false
	// = lie)
	private boolean lastQuestionTruth = true;
	// string to track mood in order to get different question responses
	private String mood;
	// character name
	private String name = "Samantha";
	// index of list is the question ID
	private Boolean[] answers;
	// keeps track of how many lies have been caught
	private static int lieCount = 0;
	private static int falseLieCount = 0;

	private Boolean caseSolved = false;

	// constructor
	public Actor4(String mood, String name) {
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
				reply = "Hello there";
				lastQuestionTruth = true;
				setLastQuestion(0);
				markAnswered(questionId, answers);
				break;
			// How are you?
			case 1:
				reply = "I feel sick. my brother is dead";
				lastQuestionTruth = true;
				setLastQuestion(1);
				markAnswered(questionId, answers);
				break;

			case 2:
				reply = "He's my brother";
				lastQuestionTruth = true;
				setLastQuestion(2);
				markAnswered(questionId, answers);
				break;
			// How did you feel when Matt proposed

			case 3:
				if (lieCount <1) {
					reply = "I was so happy, my baby brother getting married, but John seemed really cut up about it";
					lastQuestionTruth = false;
				} else if (lieCount ==1){
					reply = "i think he was making a mistake, she probably just wanted his money for her business idea";
					lastQuestionTruth = false;
				} else if (lieCount ==2) {
					reply = "they were definitely making a mistake. do not crap where you eat if you will excuse the phrase. They should be business partners and nothing else";
					lastQuestionTruth = false;
				}else if (lieCount == 3) {
					reply = "I think they were making a mistake, they werent right for each other. John is a much better match for caitlin";
					lastQuestionTruth = true;
				}
				setLastQuestion(3);
				markAnswered(questionId, answers);
				markAnswered(8, answers);
				break;
			// What was the the fight about?
			case 4:
				if (mood.equals("neutral")) {
					reply = "The usual, he wanted to make even more money from her business idea by selling it";
					lastQuestionTruth = true;

				} else {
					reply = "he wanted to sell the business she made from scratch using out parents money.";
					lastQuestionTruth = true;
				}
				setLastQuestion(4);
				markAnswered(questionId, answers);
				break;
			// Where were you when the victim was Murdered?
			case 5:
				if (lieCount <1) {
					reply = "Caitlin and I were asleep in my room, she was upset after the fight and we talked";
					lastQuestionTruth = false;
				}else if (lieCount ==1) {
					reply = "so I guess I was awake around that time, I went to get water during the night. "
							+ "but I went straight back to bed";;
					lastQuestionTruth = false;
				}else if (lieCount ==2) {
					reply = "I was talking with John, he was awake downstairs"
							+ " and was pretty cut up about the proposal but everything seemed fine when I left them to go back to bed";
					lastQuestionTruth = true;
				} else if (lieCount >=3) {
					reply = "I was talking with John, he was awake downstairs"
							+ " and was pretty cut up about the proposal but everything seemed fine when I left them to go back to bed";
					lastQuestionTruth = true;
				} 
				setLastQuestion(5);
				markAnswered(questionId, answers);
				break;
			// Do you know the whereabouts of anyone else when Matt was
			// murdered?
			case 6:

				if (mood.equals("neutral")) {
					reply = "Yes, Caitlin was in the bedroom with me asleep, I think Verity was in her room and John was passed out downstairs";
					lastQuestionTruth = false;
				} else if (mood.equals("open")) {
					reply = "I saw that john was awake when I went to get water, we talked a little about the proposal, he was really cut up about it, and angry.";
					lastQuestionTruth = true;
				} else {
					reply = "um I went downstairs to get water and john was awake. I didn't see verity";
					lastQuestionTruth = true;
				}
				setLastQuestion(6);
				markAnswered(questionId, answers);
				break;
			// Do you think anyone could kill Matt?
			case 7:
				if (lieCount <1) {
					reply = "absolutely not. ";
					lastQuestionTruth = false;
				} else if (lieCount ==1) {
					reply = "well maybe, I know people were angry at him, but I don't know why...";
					lastQuestionTruth = false;
				}  else if (lieCount ==2) {
					reply = "well john has been in love with caitlin since forever and caitlin said she didn't even want to marry matt";
					lastQuestionTruth = false;
				} else if( lieCount >=3) {
					reply = "John and Caitlin had motives, and I guess so did I. our parents are giving him so much more of the inheritance! but I didn't murder him. I didn't think anyone could until today.";
					lastQuestionTruth = true;
				}
				setLastQuestion(7);
				markAnswered(questionId, answers);
				break;
			case 9:
				if (lastQuestion == 0) {
					reply = "all I said was hello...";
					break;
				} else {
					if (lastQuestionTruth) {
						falseLieCount++;
						if (falseLieCount <= 1) {
							reply = "no, it's the truth";
						} else if (falseLieCount <= 2) {
							reply = "again? no detective I'm telling the truth";
						} else if (falseLieCount >= 3) {
							reply = "you need to trust me more detective, I'm not lying";
						}
						break;
					} else {
						markUnanswered(lastQuestion, answers);

						lieCount++;
						if (lieCount<=1){
							mood = "nervous";
							markAllUnaswered();
							reply = "ok, your right " + respond(lastQuestion);
							
						break;
						}else if (lieCount >= 2) {
							reply = "so sorry, yes its a lie " + respond(lastQuestion);
						} else if (lieCount >= 3) {
							mood = "open";
							markAllUnaswered();
							reply = "sorry detective, i shouldn't lie. " + respond(lastQuestion); 
							
						} 
						break;
					}
				}
			case 10:
				if (mood.equals("neutral")) {
					reply = "No I would never murder my own brother";
				} else if (mood.equals("open")) {
					reply = "of course not. I may benefit from his murder but he was my brother.";
				} else {
					reply = "No. I could never murder anyone let alone my own brother.";
				}
				setLastQuestion(10);
				markAnswered(questionId, answers);
				break;
			case 11:
				if (mood.equals("neutral")) {
					reply = "well, Caitlin was pretty angry about Matt selling the business that she put all of the work into. She needed to rant";
					lastQuestionTruth=false;
				} else if (mood.equals("open")) {
					reply = "John was devastated. He told me he still loves Cailtin. We were both ranting about matt. He is getting all the inheritance "
							+ "after our parents die.";
					lastQuestionTruth = true;
				} else {
					reply = "John seemed really cut up about the proposal so we talked about that. I think he still really likes Caitlin";
					lastQuestionTruth = true;
				}
				setLastQuestion(11);
				markAnswered(questionId, answers);
				break;
			case 13:
				reply = "don't mention it";
			// default response
			case 19:
				reply = "I don't know how to answer that detective";
				break;
			}
			// if question has already been asked:
		} else {
			switch (questionId) {
			// greeting response
			case 0:
				reply = "Hello again";
				setLastQuestion(0);
				markAnswered(questionId, answers);
				break;
			// How are you?
			case 1:
				reply = "I told you already, I feel sick.";
				setLastQuestion(1);
				markAnswered(questionId, answers);
				break;

			case 2:
				reply = "You know this, he's my brother";
				setLastQuestion(2);
				markAnswered(questionId, answers);
				break;
			// How did you feel when Matt proposed

			case 3:
				if (lieCount <1) {
					reply = "like I said I was so happy, my baby brother getting married, but John seemed really cut up about it";
					lastQuestionTruth = false;
				} else if (lieCount ==1){
					reply = "I told you, i think he was making a mistake";
					lastQuestionTruth = false;
				} else if (lieCount ==2) {
					reply = "I told you, they were definitely making a mistake. do not crap where you eat";
					lastQuestionTruth = false;
				}else if (lieCount == 3) {
					reply = "I told you. I think John is a much better match for caitlin";
					lastQuestionTruth = true;
				}
				setLastQuestion(3);
				markAnswered(questionId, answers);
				markAnswered(8, answers);
				break;
			// What was the the fight about?
			case 4:
				if (mood.equals("neutral")) {
					reply = "I already told you, he wanted to make even more money from her business idea by selling it";
					lastQuestionTruth = true;

				} else {
					reply = "like I said, he wanted to sell the business she made from scratch using out parents money.";
					lastQuestionTruth = true;
				}
				setLastQuestion(4);
				markAnswered(questionId, answers);
				break;
			// Where were you when the victim was Murdered?
			case 5:
				if (lieCount <1) {
					reply = "I told you, Caitlin and I were asleep in my room, she was upset after the fight and we talked";
					lastQuestionTruth = false;
				}else if (lieCount ==1) {
					reply = "like I said before I guess I was awake around that time, I went to get water during the night. ";
							
					lastQuestionTruth = false;
				}else if (lieCount ==2) {
					reply = "like I said I went down to get water. John was awake so I talked to him for a while then went back to bed";
					lastQuestionTruth = true;
				} else if (lieCount >=3) {
					reply = "Like I said I went downstairs and talked with john. He was upset about the proposal, but then I went back to bed";
					lastQuestionTruth = true;
				} 
				setLastQuestion(5);
				markAnswered(questionId, answers);
				break;
			// Do you know the whereabouts of anyone else when Matt was
			// murdered?
			case 6:

				if (mood.equals("neutral")) {
					reply = "like I said, Caitlin was in the bedroom with me asleep, I think Verity was in her room and John was passed out downstairs";
					lastQuestionTruth = false;
				} else if (mood.equals("open")) {
					reply = "I told you, I saw that john was awake when I went to get water, we talked a little about the proposal, he was really cut up about it, and angry.";
					lastQuestionTruth = true;
				} else {
					reply = " I went downstairs to get water and john was awake. I didn't see verity";
					lastQuestionTruth = true;
				}
				setLastQuestion(6);
				markAnswered(questionId, answers);
				break;
			// Do you think anyone could kill Matt?
			case 7:
				if (lieCount <1) {
					reply = "I told you, no. ";
					lastQuestionTruth = false;
				} else if (lieCount ==1) {
					reply = " like I said, maybe. I know people were angry at him, but I don't know why...";
					lastQuestionTruth = false;
				}  else if (lieCount ==2) {
					reply = "I told you. john has been in love with caitlin since forever and caitlin said she didn't even want to marry matt. But murder...?";
					lastQuestionTruth = false;
				} else if( lieCount >=3) {
					reply = "like I said John and Caitlin had motives, and I guess so did I. our parents are giving him so much more of the inheritance! but I didn't murder him. I didn't think anyone could until today.";
					lastQuestionTruth = true;
				}
				setLastQuestion(7);
				markAnswered(questionId, answers);
				break;
			case 9:
				if (lastQuestion == 0) {
					reply = "all I said was hello...";
					break;
				} else {
					if (lastQuestionTruth) {
						falseLieCount++;
						if (falseLieCount <= 1) {
							reply = "no, it's the truth";
						} else if (falseLieCount <= 2) {
							reply = "again? no detective I'm telling the truth";
						} else if (falseLieCount >= 3) {
							reply = "you need to trust me more detective, I'm not lying";
						}
						break;
					} else {
						markUnanswered(lastQuestion, answers);

						lieCount++;
						if (lieCount<=1){
							mood = "nervous";
							markAllUnaswered();
							reply = "ok, your right " + respond(lastQuestion);
							
						break;
						}else if (lieCount >= 2) {
							reply = "so sorry, yes its a lie " + respond(lastQuestion);
						} else if (lieCount >= 3) {
							mood = "open";
							markAllUnaswered();
							reply = "sorry detective, i shouldn't lie. " + respond(lastQuestion); 
							
						} 
						break;
					}
				}
			case 10:
				if (mood.equals("neutral")) {
					reply = "I told you, I would never murder my own brother";
				} else if (mood.equals("open")) {
					reply = "This again? No. I didn't murder matt";
				} else {
					reply = "This again? No.";
				}
				setLastQuestion(10);
				markAnswered(questionId, answers);
				break;
			case 11:
				if (mood.equals("neutral")) {
					reply = "I told you, Caitlin was pretty angry about Matt selling the business that she put all of the work into";
					lastQuestionTruth=false;
				} else if (mood.equals("open")) {
					reply = "Like I said, John was devastated. He told me he still loves Cailtin. We were both ranting about matt. He is getting all the inheritance "
							+ "after our parents die.";
					lastQuestionTruth = true;
				} else {
					reply = "I told you, John seemed really cut up about the proposal so we talked about that. I think he still really likes Caitlin";
					lastQuestionTruth = true;
				}
				setLastQuestion(11);
				markAnswered(questionId, answers);
				break;
		
			// default response
			case 19:
				reply = "I don't know how to answer that detective";
				break;
			}
		}
		return reply;
	}

	public void markAnswered(int questionId, Boolean[] questionList) {
		questionList[questionId] = true;
	}

	public void markUnanswered(int questionId, Boolean[] questionList) {
		questionList[questionId] = false;
	}
	public void markAllUnaswered(){
		Arrays.fill(answers, false);
	}

	@Override
	public String getMood() {
	
		return this.mood;
	}

	@Override
	public String getName() {
		
		return this.name;
	}

	public int getLastQuestion() {
		return lastQuestion;
	}
	//stores the last Question asked 
	public void setLastQuestion(int lastQuestion) {
		this.lastQuestion = lastQuestion;
	}

	@Override
	public boolean getCaseSolved() {
		
		return false;
	}

}