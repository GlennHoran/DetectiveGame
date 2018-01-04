package game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Character d = new C1("nervous");
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("talk with the chatbot:");
		
		while (true){
			String input =scanner.next();
		AbstractResponseHandler.handle(d, input);
		
		}
		
		
		
	}

}
