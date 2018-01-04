package gamev2;
//how did you know him to be fixed 
//lies not working right - "that's a lie" & "You're lying" - fixed
//"Do you think x killed matt?" not recognised
//"where was x when matt was killed?"
//do you know the whereabouts of anyone when Matt was killed/do you know the whereabouts of anyone else ..>"
//make an array of ints instead of an array of booleans in case question asked lots of times?
//need a generic response instead of "no question recognised"
import java.util.Scanner;

//look into adding generic follow up questions
//do you know where anyone else was?

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Actor a = new Actor1("neutral", "Samantha");
		// TODO Auto-generated method stub
	    Scanner scanner = new Scanner(System.in);
		System.out.println("=================");
		System.out.println("Talk to " + a.getName());
		System.out.println("=================");
	
		while (true){
			
		
		String input = scanner.nextLine();
		System.out.println(AbstractResponder.handle(input, a));
		}
		
		
		
		
		
		/*
	 
		System.out.println(input + " second time");
		AbstractResponder.handle(input, a);
		System.out.println("------------------");
		input = "how are you";
		System.out.println(input);
		AbstractResponder.handle(input, a);
		System.out.println("------------------");
		input = "how did you know the victim";
		System.out.println(input);
		AbstractResponder.handle(input, a);
		System.out.println("------------------");
		input = "how did you feel when he proposed";
		
		System.out.println(input);
		AbstractResponder.handle(input, a);
		System.out.println("------------------");
		input = "lie";
		System.out.println(input);
		AbstractResponder.handle(input, a);
		System.out.println("------------------");
		input = "where were you when matt was murdered";
		System.out.println(input);
		AbstractResponder.handle(input, a);
		System.out.println("------------------");
		input = "do you know the where anyone else was when the victim was murdered?";
		System.out.println(input);
		AbstractResponder.handle(input, a);
		System.out.println("------------------");
		input = "lying";
		System.out.println(input);
		AbstractResponder.handle(input, a);
		System.out.println("------------------");
		input = "do you think anyone could murder matt?";
		System.out.println(input);
		AbstractResponder.handle(input, a);
		*/
		
	}

}
