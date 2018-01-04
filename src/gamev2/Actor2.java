package gamev2;

import java.util.Arrays;

public class Actor2 implements Actor {

	// stores the question id of last question
	private int lastQuestion;
	// determine if last question answered was a lie or not (true = truth, false
	// = lie)
	private boolean lastQuestionTruth = true;
	// string to track mood in order to get different question responses
	private String mood;
	// character name
	private String name = "Caitlin";
	// index of list is the question ID
	private Boolean[] answers;
	// keeps track of how many lies have been caught
	private static int lieCount = 0;
	private static int falseLieCount =0;

	// constructor
	public Actor2(String mood, String name) {
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
		// if question has been asked already
		if (answers[questionId] == false) {
			switch (questionId) {
			// greeting response
			case 0:
				reply = "hello detective";
				setLastQuestion(0);
				markAnswered(questionId, answers);
				break;
			// How are you?
			case 1:
				if (mood.equals("neutral")) {
					reply = "How do you think I am? "
							+ "I am devastated. My Matty is dead.";
					lastQuestionTruth = true;
				} else if (mood.equals("open")) {
					reply = "I know how this is going to sound. I am devastated, but a small part of me is relieved. I have my business back.";
					lastQuestionTruth = true;
				} else {
					reply = "i am so sad and I do not know what i am going to do next";
					lastQuestionTruth = true;
				}
				setLastQuestion(1);
				markAnswered(questionId, answers);
				break;
			// How did you know the victim
			case 2:
				if (mood.equals("neutral")) {
					reply = "He is my Fiance and business partner. We were about to sell our company to google for a lot of money.";
					lastQuestionTruth = true;
				} else if (mood.equals("open")) {
					reply = "He was the money behind my business idea and as of last night my fiance ";
					lastQuestionTruth = true;
				} else {
					reply = "I guess my Fiance.. he was boyfriend for 3 years until last night ";
					lastQuestionTruth = true;
				}
				setLastQuestion(2);
				markAnswered(questionId, answers);
				break;
			// How did you feel when Matt proposed
			case 3:
				if (lieCount<1) {
					reply = "I was delighted that I was going to be his wife";
					lastQuestionTruth = false;
				}else if (lieCount==1) {
					reply = "I was happy, but a little shocked too. We fight a lot";
					lastQuestionTruth = false;
				} else if (lieCount ==2) {
					reply = "I guess I was surprised. I mean We've been going out a long time and I love him. But.. I was surprised";
					lastQuestionTruth = true;
				} else {
					reply = "Ok I was shocked and very nervous, I shouldn't have said yes, but it was in front of everyone and he looked so happy ";
					lastQuestionTruth = true;
				}
				setLastQuestion(3);
				markAnswered(questionId, answers);
				markAnswered(8, answers);
				break;
			// What was the the fight about?
			case 4:
				if (mood.equals("neutral")) {
					reply = "Nothing important really, you know how couples fight...";
					lastQuestionTruth = false;
				} else if (mood.equals("open")) {
					reply = "Even though the intellectual property was mine, he announced to everyone that we were selling our business without my consent. It was just like him, I was livid. ";
					lastQuestionTruth = true;
				} else {
					reply = "Um.. well we were discussing the business, I wanted to sell and he didn't but it wasn't a major fight";
					lastQuestionTruth = true;
				}
				setLastQuestion(4);
				markAnswered(questionId, answers);
				break;
			// Where were you when the victim was Murdered?
			case 5:
				if (mood.equals("neutral")) {
					reply = "I was in one of the upstairs bedrooms all night. I was with Samantha talking about"
							+ " the fight and then we started talking about the engagement. It must have been around 2am before we went to sleep";
					lastQuestionTruth = true;
				} else if (mood.equals("open")) {
					reply = "I went to bed around 12 and could not sleep so I went to speak with Samantha who was in her room when I knocked. We chatted about the fight and the engagement and I went to sleep around 2am. ";
					lastQuestionTruth = true;
				} else {
					reply = "let me see.. um I went to bed but could not sleep so I went to talk with Samantha and we chatted about well… the fight and then wedding things and then we pretty much went to sleep around 2am I think ";
					lastQuestionTruth = true;
				}
				setLastQuestion(5);
				markAnswered(questionId, answers);
				break;
			// Do you know the whereabouts of anyone else when Matt was
			// murdered?
			case 6:

				if (lieCount <1) {
					reply = "I know Samantha was with me prettymuch all night and I think Verity was asleep in her room next to ours. "
							+ "John was probably still passed out on the sofa downstairs, but I really do not know";
					lastQuestionTruth = false;
					
				} else if (lieCount ==1) {
					reply = " I woke during the night to use the bathroom but I didn't see anyone";
					lastQuestionTruth = false;
				}else if (lieCount ==2) {
					reply = " I woke during the night, but Samantha  was not there, I just assumed she was using the toilet or something and I went back to sleep";
					lastQuestionTruth = false;
				} else if (lieCount >=3) {
					reply = " when I woke up to go to the bathroom I noticed Samantha wasn't there. I think I heard her talking to John downstairs but didn't think anything of it at the time";
					lastQuestionTruth = true;
				}
				setLastQuestion(6);
				markAnswered(questionId, answers);
				break;
			// Do you think anyone could kill Matt?
			case 7:
				if (mood.equals("neutral")) {
					reply = "No of course not. Were all close. I cannot think of anyone who would benefit from that ";
					lastQuestionTruth = false;
				} else if (mood.equals("open")) {
					reply = "I know John has a thing for me, we all know.  I guess he got upset when Matt proposed, but he was passed out all night";
					lastQuestionTruth = true;
				} else {
					reply = "I don't know... I mean Samantha told me earlier in the night that she found out that he was getting "
							+ "more of their parents inheritance… ";
					lastQuestionTruth = true;
				}
				setLastQuestion(7);
				markAnswered(questionId, answers);
				break;
	
			case 9:
				if (lastQuestionTruth) {
					falseLieCount++;
					if (falseLieCount <= 1) {
						reply = "No, it's the truth, I swear";
					} else if (falseLieCount <= 2) {
						reply = "Still telling the truth";
					} else if (falseLieCount >= 3) {
						reply = "I don't know why you think I would lie this much detective";
					}
					break;
				} else {
					lieCount++;
					if (lieCount<2){
					
					mood = "nervous";
					markAllUnaswered();
					reply = "you are right. I am lying, i am sorry" + respond(lastQuestion);
					}else if (lieCount >= 3) {
						
						mood = "open";
						markAllUnaswered();
						reply = "I will not lie anymore detective. " + respond(lastQuestion);
					} 
					break;
				}
			case 10:
				if (mood.equals("neutral")) {
					reply = "What? Of course not.";
				} else if (mood.equals("open")) {
					reply = "I know how it looks, I had motives. But I did not murder him.";
				} else {
					reply = "No I did not murder him. I would never go that far";
				}
				setLastQuestion(3);
				markAnswered(questionId, answers);
				markAnswered(3, answers);
				break;
			case 11:
				if (lieCount<1) {
					reply = "nothing really. Just girl stuff.";
					lastQuestionTruth=false;
				} else if (lieCount==1) {
					reply = "We talked about the wedding and how great of a day it was going to be";
					lastQuestionTruth = false;
				} else if (lieCount ==2) {
					reply = "well we talked about how matt was taking all of samanthas inheritance in their parents will. but that was it";
					lastQuestionTruth = false;
				} else {
					reply = "We mostly talked about how angry I was with matt that he was going to sell the business I built for him and how I didn't want to marry him ";
					lastQuestionTruth = true;
				}
				setLastQuestion(11);
				markAnswered(questionId, answers);
				break;
				// default response
			case 19:
				reply = "i am sorry I do not know how to answer that";
				break;
			}
			// if question has already been asked:
		} else {
			switch (questionId) {
			// greeting response
			case 0:
				reply = "hello again detective";

				setLastQuestion(0);
				markAnswered(questionId, answers);
				break;
			// How are you?
			case 1:
				if (mood.equals("neutral")) {
					reply = "Like I said, i am devastated, broken...";
					lastQuestionTruth = true;
				} else if (mood.equals("open")) {
					reply = "OK. I know how this is going to sound. i am devastated, but a small part of me is relieved. I have my business back.";
					lastQuestionTruth = true;
				} else {
					reply = "i am umm so sad and I do not know what i am going to do next";
					lastQuestionTruth = true;
				}
				setLastQuestion(1);
				break;
			// How did you know the victim
			case 2:
				reply = "You know this, he was my fiance and business partner";
				lastQuestionTruth = true;
				setLastQuestion(2);
				break;
			// How did you feel when Matt proposed
			case 3:
				if (lieCount<1) {
					reply = "like I said, I was delighted";
					lastQuestionTruth = false;
				}else if (lieCount==1) {
					reply = "Like I said, I was happy, but a little shocked too. We fight a lot";
					lastQuestionTruth = false;
				} else if (lieCount ==2) {
					reply = "I guess I was surprised. I mean We've been going out a long time and I love him. But.. I was surprised";
					lastQuestionTruth = true;
				} else {
					reply = "I told you, I was shocked and very nervous, I shouldn't have said yes.";
					lastQuestionTruth = true;
				}
				setLastQuestion(3);
				break;
			// What was the the fight about?
			case 4:
				if (mood.equals("neutral")) {
					reply = "I told you, it was not a big deal, just a small fight about nothing really";
					lastQuestionTruth = false;
				} else if (mood.equals("open")) {
					reply = "Even though the intellectual property was mine, he announced to everyone that we were selling our business without my consent. It was just like him, I was livid.";
					lastQuestionTruth = true;
				} else {
					reply = "I told you, He wanted to sell the company and I did not but he went ahead and announced to "
							+ "everyone that we were selling before we had finished talking about it.";
					lastQuestionTruth = true;
				}
				setLastQuestion(4);
				markAnswered(questionId, answers);
				break;
			// Where were you when the victim was Murdered?
			case 5:
				if (mood.equals("neutral")) {
					reply = "I was in one of the upstairs bedrooms all night with Samantha.";
					lastQuestionTruth = true;
				} else if (mood.equals("open")) {
					reply = "I went to bed around 12 and could not sleep so I went to speak with Samantha who was in her room when I knocked. We chatted about the fight and the engagement and I went to sleep around 2am. ";
					lastQuestionTruth = true;
				} else {
					reply = "let me see.. um I went to bed but could not sleep so I went to talk with Samantha and we chatted about well… the fight and then wedding things and then we pretty much went to sleep around 2am I think ";
					lastQuestionTruth = true;
				}
				setLastQuestion(5);
				break;
			// Do you know the whereabouts of anyone else when Matt was
			// murdered?
			case 6:
				if (lieCount <1) {
					reply = " I told you, Samantha was with me prettymuch all night and I think Verity was asleep in her room next to ours. "
							+ "John was probably still passed out on the sofa downstairs, but I really do not know";
					lastQuestionTruth = false;
					
				} else if (lieCount ==1) {
					reply = "like I said, I woke during the night to use the bathroom but I didn't see anyone";
					lastQuestionTruth = false;
				}else if (lieCount ==2) {
					reply = " I woke during the night, but Samantha  was not there, I just assumed she was using the toilet or something and I went back to sleep";
					lastQuestionTruth = false;
				} else if (lieCount >=3) {
					reply = " when I woke up to go to the bathroom I noticed Samantha wasn't there. I think I heard her talking to John downstairs but didn't think anything of it at the time";
					lastQuestionTruth = true;
				}
				setLastQuestion(6);
				break;
			// Do you think anyone could kill Matt?
			case 7:
				if (mood.equals("neutral")) {
					reply = "Like I said, we were close. I do not think any one of us would actually murder someone";
					lastQuestionTruth = true;
				} else if (mood.equals("open")) {
					reply = "John has a thing for me, and a temper, we all know that.  I guess he got upset when Matt proposed, but he was passed out all night";
					lastQuestionTruth = true;
				} else {
					reply = "I don't know... I mean Samantha told me earlier in the night that she found out that he was getting "
							+ "more of their parents inheritance… ";
					lastQuestionTruth = true;
				}
				setLastQuestion(7);
				break;
			// How do you feel about the proposal?
			case 8:
				if (lieCount <1) {
					reply = "Like I said I was excited and happy";
					lastQuestionTruth = false;
				} else if (lieCount ==2) {
					reply = "Honestly? I was shocked… I mean we fight a lot but I guess work can just be stressful you know?";
					lastQuestionTruth = true;
				} else if (lieCount==1) {
					reply = "Umm I was very happy and nervous, but happy";
					lastQuestionTruth = false;
				}else if (lieCount>=3) {
					reply = " i was really nervous. I mean I love him, but we fight so much and I was not sure i made the right decision";
					lastQuestionTruth = false;
				}
				setLastQuestion(3);
				break;
			case 9:
				if (lastQuestionTruth) {
					falseLieCount++;
					if (falseLieCount <= 1) {
						reply = "No, it's the truth, I swear";
					} else if (falseLieCount <= 2) {
						reply = "Still telling the truth";
					} else if (falseLieCount >= 3) {
						reply = "I don't know why you think I would lie this much detective";
					}
					break;}
					else {
					lieCount++;
					if (lieCount<2){
					
					mood = "nervous";
					markAllUnaswered();
					reply = "you are right. I am lying, i am sorry " + respond(lastQuestion);
					}else if (lieCount >= 2) {
						
						mood = "open";
						markAllUnaswered();
						reply = "I will not lie anymore detective. " + respond(lastQuestion);
					} 
					break;
				}
			case 11:
				if (lieCount<1) {
					reply = "I told you, just girl stuff.";
					lastQuestionTruth=false;
				} else if (lieCount==1) {
					reply = "Like I said We talked about the wedding and how much i was looking forward to it";
					lastQuestionTruth = false;
				} else if (lieCount ==2) {
					reply = "like I said, we talked about how matt was taking all of samanthas inheritance in their parents will. but that was it";
					lastQuestionTruth = false;
				} else {
					reply = "I told you, We mostly talked about how angry I was with matt that he was going to sell the business I built for him and how I didn't want to marry him ";
					lastQuestionTruth = true;
				}
				setLastQuestion(11);
				markAnswered(questionId, answers);
				break;
			case 13:
				reply = "No problem";
				// default response
			case 19:
				reply = "i am sorry I do not know how to answer that";
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
		// TODO Auto-generated method stub
		return this.mood;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
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