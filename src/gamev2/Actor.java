package gamev2;
/**
 * interface for individual actor responses. Notes:
 * consider adding in a system to store the last question asked for follow up questions eg. "how did that make you feel? can someone back that up? etc."
 * @author Glenn
 *
 */
public interface Actor {

	
	
	
	public String getMood();
	public String getName();
	public boolean getCaseSolved();
	public String respond(int questionId);
	public void markAnswered(int questionId, Boolean[] questionList);
}
