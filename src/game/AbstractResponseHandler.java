package game;

public abstract class AbstractResponseHandler implements ResponseHandler {

	private ResponseHandler nextHandler;
	
	private String mood = "";

	public AbstractResponseHandler() {
		// TODO Auto-generated constructor stub
	}


	public void setNextHandler(ResponseHandler handler) {
		nextHandler = handler;
		//String mood = "";
	}


	public void processHandler(Character c, String input) {
		boolean rightMood = false;
		if (c.getEmotion().equalsIgnoreCase(this.getMood())) {
			rightMood = true;
		} 
		
		if (rightMood) {
			handleHere(input, c);
		} else {
			nextHandler.processHandler(c, input);
		}
	}

	public static void handle(Character c, String input) {
		ResponseHandler neutral = Neutral.getInstance();
		ResponseHandler sad = Sad.getInstance();
		ResponseHandler angry = Angry.getInstance();
		ResponseHandler nervous = Nervous.getInstance();
		ResponseHandler open = Open.getInstance();
		neutral.setNextHandler(sad);
		sad.setNextHandler(angry);
		angry.setNextHandler(nervous);
		nervous.setNextHandler(open);
		
		//start everything off
		neutral.processHandler(c, input);
	}
	
	public String getMood(){
		return this.mood;
	}

	protected abstract void handleHere(String input, Character c);

}
