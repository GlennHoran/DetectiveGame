package gamev2;

import java.util.Arrays;

public class Actor1 implements Actor {

	// stores the question id of last question
	private int lastQuestion;
	// determine if last question answered was a lie or not (true = truth, false
	// = lie)
	private boolean lastQuestionTruth = true;
	// string to track mood in order to get different question responses
	private String mood;
	// character name
	private String name = "John";
	// index of list is the question ID
	private Boolean[] answers;
	// keeps track of how many lies have been caught
	private static int lieCount = 0;
	private static int falseLieCount = 0;

	private Boolean caseSolved = false;

	// constructor
	public Actor1(String mood, String name) {
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
				reply = "Hey chief";
				setLastQuestion(0);
				markAnswered(questionId, answers);
				break;
			// How are you?
			case 1:
				if (mood.equals("neutral")) {
					reply = "Well my head hurts and my best friend is dead. I've felt better detective";
					lastQuestionTruth = true;
				} else if (mood.equals("open")) {
					reply = "I feel rotten";
					lastQuestionTruth = true;
				} else {
					reply = "I feel awful, everything sucks right now";
					lastQuestionTruth = true;
				}
				setLastQuestion(1);
				markAnswered(questionId, answers);
				break;

			case 2:
				reply = "He is. was. my best friend. we have known each other for years";
				setLastQuestion(2);
				markAnswered(questionId, answers);
				lastQuestionTruth = true;
				break;
			// How did you feel when Matt proposed

			case 3:
				if (lieCount < 1) {
					reply = "I was so happy for them. two of my best friends were getting married";
					lastQuestionTruth = false;

				} else if (lieCount == 1) {
					reply = "maybe I was not so happy. I have always had a bit of a thing for Caitlin.";
					lastQuestionTruth = false;

				} else if (lieCount == 2) {

					reply = "I was hurt. Caitlin is too good for him. He doesn't appreciate her. Samantha agrees with me, she told me during the middle of the night when she came downstairs";
					lastQuestionTruth = false;
				} else if (lieCount >= 3) {
					reply = "fine. I was hurt. enraged. I love caitlin and I thought they were going to break up over this business decision then I'd"
							+ "finally have a shot with her.";
					lastQuestionTruth = true;

				}
				setLastQuestion(3);
				markAnswered(questionId, answers);
				markAnswered(8, answers);
				break;
			// What was the the fight about?
			case 4:
				if (lieCount <= 1) {
					reply = "They had a fight? I must have been passed out. I cant remember sorry";

					lastQuestionTruth = false;
				} else if (mood.equals("open")) {
					reply = "they always fight. she was right as usual. he wanted to sell her business and make even more money for himself.";
					lastQuestionTruth = true;
				} else {
					reply = "I do remember them fighting. they were fighting about their business and how she didn't want to sell it";
					lastQuestionTruth = true;
				}
				setLastQuestion(4);
				markAnswered(questionId, answers);
				break;
			// Where were you when the victim was Murdered?
			case 5:
				if (lieCount < 1) {
					reply = "I was passed out all night. I do not even know what time it happened";
					lastQuestionTruth = false;

				} else if (lieCount == 1) {
					reply = "I only have vague memories of being awake, I do not remember specifics";
					lastQuestionTruth = false;
				} else if (lieCount >= 3) {
					lastQuestionTruth = true;
					reply = "after Samantha went back to bed it was just matt and I in the kitchen. I had a knife. I think I killed him.";
				} else if (lieCount == 2) {
					lastQuestionTruth = false;
					reply = "I was awake. I remember talking to Samantha during the night";
					lastQuestionTruth = false;
				}
				setLastQuestion(5);
				markAnswered(questionId, answers);
				break;
			// Do you know the whereabouts of anyone else when Matt was
			// murdered?
			case 6:

				if (lieCount < 1) {
					reply = "I am sorry I cannot help more. like I said i was asleep on the sofa.";
					lastQuestionTruth = false;

				} else if (lieCount == 1) {
					reply = "I think I remember Samantha being downstairs. But it is hazy. that is all I remember";
					lastQuestionTruth = false;
				} else if (mood.equals("open")) {
					reply = "Samantha went back to bed after we talked then it was just matt and I in the kitchen...";
					lastQuestionTruth = true;
				} else if (lieCount == 2) {

					reply = "I do remember a bit more. I saw Samantha and i remember talking to her for a while then I went back to sleep";
					lastQuestionTruth = false;
				}
				setLastQuestion(6);
				markAnswered(questionId, answers);
				break;
			// Do you think anyone could kill Matt?
			case 7:
				if (lieCount < 1) {
					reply = "No chief. ";
					lastQuestionTruth = false;
				} else if (lieCount == 1) {
					reply = "i do not think so.  except Samantha had a lot of money coming her way if she did. but i do not think she is capable of that, matt was her brother";
					lastQuestionTruth = true;
				} else if (lieCount == 2) {
					reply = "samantha had reason to kill him. and caitlin would have owned the whole business if matt was not around. But i do not think they would kill him";
					lastQuestionTruth = false;
				} else if (lieCount >= 3) {
					reply = "I guess I have as much reason as anyone. he took my love from me";
					lastQuestionTruth = true;
				}
				setLastQuestion(7);
				markAnswered(questionId, answers);
				break;
			case 9:
				if (lastQuestion == 0) {
					reply = "I was just saying hello...";
					break;
				} else {
					if (lastQuestionTruth) {
						falseLieCount++;
						if (falseLieCount <= 1) {
							reply = "Sorry chief. Nothing but the truth";
						} else if (falseLieCount <= 2) {
							reply = "wrong again chief. I speak the truth";
						} else if (falseLieCount >= 3) {
							reply = "you are clutching at straws here detective...";
						}
						break;
					} else {
						markUnanswered(lastQuestion, answers);

						lieCount++;
						if (lieCount >= 1 && lieCount < 2) {
							mood = "nervous";
							markAllUnaswered();
							reply = "hmm you're right. " + respond(lastQuestion);

						} else if (lieCount >= 2 && lieCount < 3) {
							reply = "sorry. yes your right again. " + respond(lastQuestion);

						} else if (lieCount >= 3) {
							mood = "open";
							markAllUnaswered();
							reply = "you got me chief. " + respond(lastQuestion);

						}

						break;
					}
				}
			case 10:
				if (mood.equals("neutral")) {
					reply = "What? Of course not.";
				} else if (mood.equals("open")) {
					reply = "I think I did murder him. I did. I was drunk, in love and i had had enough. I stabbed him in the back while he was in the kitchen"
							+ " then cleaned myself up and pretended to be asleep when samantha found him.";
					caseSolved = true;
				} else {
					reply = "No I did not murder him. I would never go that far";
				}
				setLastQuestion(10);
				markAnswered(questionId, answers);
				break;
			case 11:
				if (mood.equals("neutral")) {
					reply = "We talked about the proposal and how it might have been hasty. Samantha told me about her parents inheritance all going to matt";
					lastQuestionTruth = false;
				} else if (mood.equals("open")) {
					reply = "We talked about how much i am in love with caitlin and that I was devastated that she was getting married.";
					lastQuestionTruth = true;
				} else {
					reply = "We mostly talked about how I still had feelings for caitlin. but we were angry at Matt for different reasons. For her it was that she was not getting any of their parents inheritance";
					lastQuestionTruth = true;
				}
				setLastQuestion(11);
				markAnswered(questionId, answers);
				break;
			// thanks
			case 13:
				reply = "No problem chief";
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
				reply = "Hey again chief";
				setLastQuestion(0);
				markAnswered(questionId, answers);
				break;
			// How are you?
			case 1:
				reply = "I told you. I feel rotten in every possible way";
				setLastQuestion(1);
				markAnswered(questionId, answers);
				lastQuestionTruth = true;
				break;
			// How did you know the victim
			case 2:
				reply = "Like i said, he was my best friend";
				setLastQuestion(2);
				markAnswered(questionId, answers);
				break;
			// How did you feel when Matt proposed
			case 3:
				if (lieCount < 1) {
					reply = "like I said, I was really happy that my friends were tying the knot";
					lastQuestionTruth = false;
				} else if (lieCount == 1) {
					reply = "I told you, I was not completely happy with it. but it was not a big deal.";
					lastQuestionTruth = false;
				} else if (lieCount == 2) {
					reply = "Like I said, I was hurt. Caitlin is too good for him.";
					lastQuestionTruth = true;
				} else if (lieCount >= 3) {
					reply = "I told you I love caitlin. I was devastated when she said yes.";
					lastQuestionTruth = true;
				}
				setLastQuestion(3);
				markAnswered(questionId, answers);
				markAnswered(8, answers);
				break;
			// What was the the fight about?
			case 4:
				if (lieCount < 1) {
					reply = "like I said, I must have been passed out. I cant remember any fight sorry";
					lastQuestionTruth = false;

				} else if (mood.equals("open")) {
					reply = "I told you. they always fight. she was right as usual. he wanted to sell her business and make even more money for himself.";
					lastQuestionTruth = true;
				} else {
					reply = "umm I remember them fighting. they were fighting about the business. she did not want to sell and he did.";
					lastQuestionTruth = true;
				}
				setLastQuestion(4);
				markAnswered(questionId, answers);
				break;
			// Where were you when the victim was Murdered?
			case 5:
				if (lieCount < 1) {
					reply = "I keep telling you. I was passed out all night. I do not even know what time it happened";
					lastQuestionTruth = false;
				} else if (lieCount == 1) {
					reply = "As I said I only have vague memories of being awake, I do not remember specifics";
					lastQuestionTruth = true;
				} else if (lieCount == 2) {
					reply = "As I said I remember talking to Sam about something during the night I do not know when matt was murdered";
					lastQuestionTruth = false;
				} else if (mood.equals("open")) {
					reply = "come on detective. do not make me say it again. I was there with a knife in my hand";
					lastQuestionTruth = true;
				}
				setLastQuestion(5);
				markAnswered(questionId, answers);
				break;
			// Do you know the whereabouts of anyone else when Matt was
			// murdered?
			case 6:

				if (lieCount < 1) {
					reply = "how many times do I have to say it? i was passed out drunk on the sofa.";
					lastQuestionTruth = false;
				} else if (lieCount == 1) {
					reply = "Like I said I think I remember Samantha being downstairs. But it is hazy. that is all I remember";
					lastQuestionTruth = false;
				} else if (lieCount == 2) {
					reply = "like I said, I do remember more. I saw Samantha and i remember talking to her about something and then I went back to sleep";

					lastQuestionTruth = true;
				} else if (mood.equals("open")) {
					reply = "everyone else was in bed I think. It was just matt and I in the kitchen";
					lastQuestionTruth = true;
				}
				setLastQuestion(6);
				markAnswered(questionId, answers);
				break;
			// Do you think anyone could kill Matt?
			case 7:
				if (lieCount < 1) {
					reply = "you keep asking the same questions. None of us are capable of murder";
					lastQuestionTruth = false;
				} else if (lieCount == 1) {
					reply = " Like I said samantha had reason to kill him. and caitlin would have owned the whole business if matt was not around. But i do not think they would kill him";
					lastQuestionTruth = false;
				} else if (lieCount == 2) {
					reply = "again. no, except Samantha had a lot of money coming her way if she did. but i do not think she is capable of that, matt was her brother";
					lastQuestionTruth = false;
				} else if (mood.equals("open")) {
					reply = "I was in love with Cailtin. no one had more to gain from killing matt than me ";
					lastQuestionTruth = true;
				}
				setLastQuestion(7);
				markAnswered(questionId, answers);
				break;
			case 9:
				if (lastQuestion == 0) {
					reply = "I was just saying hello...";
					break;
				} else {
					if (lastQuestionTruth) {
						falseLieCount++;
						if (falseLieCount <= 1) {
							reply = "Sorry chief. Nothing but the truth";
						} else if (falseLieCount <= 2) {
							reply = "wrong again chief. I speak the truth";
						} else if (falseLieCount >= 3) {
							reply = "you are clutching at straws here detective...";
						}
						break;
					} else {
						// markUnanswered(lastQuestion, answers);

						lieCount++;
						if (lieCount >= 1 && lieCount < 2) {
							mood = "nervous";
							markAllUnaswered();
							reply = "hmm you're right. " + respond(lastQuestion);

							break;
						} else if (lieCount >= 2 && lieCount < 3) {
							reply = "sorry. yes your right again. " + respond(lastQuestion);

						} else if (lieCount >= 3) {
							mood = "open";
							markAllUnaswered();
							reply = "you got me chief. " + respond(lastQuestion);

						}

						break;
					}
				}
			case 10:
				if (mood.equals("neutral")) {
					reply = "What? Of course not.";
				} else if (mood.equals("open")) {
					reply = "I think I did murder him. I did. I was drunk, in love and i had had enough. I stabbed him in the back while he was in the kitchen, "
							+ " cleaned myself up and pretended to be asleep when samantha found him.";
					caseSolved = true;
				} else {
					reply = "No I did not murder him. I would never go that far";
				}
				setLastQuestion(10);
				markAnswered(questionId, answers);
				break;
			case 11:
				if (mood.equals("neutral")) {
					reply = "like I said, We talked about the proposal and how it might have been hasty. Samantha told me about her parents inheritance all going to matt";
					lastQuestionTruth = false;
				} else if (mood.equals("open")) {
					reply = "I told you, We talked about how much i am in love with caitlin and that I was devastated that she was getting married.";
				} else {
					reply = "I told you, We mostly talked about how I still had feelings for caitlin. but we were angry at Matt for different reasons. For her it was that she was not getting any of their parents inheritance";
					lastQuestionTruth = true;
				}
				setLastQuestion(11);
				markAnswered(questionId, answers);
				break;
			// default response

			case 19:
				reply = "what are you talking about?";
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

	public void markAllUnaswered() {
		Arrays.fill(answers, false);
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

	public boolean getCaseSolved() {
		return caseSolved;
	}

}