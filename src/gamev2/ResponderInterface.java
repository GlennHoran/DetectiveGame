package gamev2;

public interface ResponderInterface {

	
	public void setNextHandler(ResponderInterface responder);
    public String processHandler(String input, Actor a);
}
