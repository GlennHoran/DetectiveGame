package game;

public interface ResponseHandler {

	public void setNextHandler(ResponseHandler handler);
	public void processHandler(Character d, String input);
	
}
