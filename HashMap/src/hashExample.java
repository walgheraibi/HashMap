import java.util.HashMap;
import java.util.Scanner;

public class hashExample {

	public static void main(String[] args) {
		HashMap<Integer, String> n = new HashMap<Integer, String>();
		n = initializedHashMap(n);
		Scanner keyboard = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
	
			
			int input =Validator.getInt(keyboard, "Enter a number: ");
			if(!n.containsKey(input))
			{
				String number = Validator.getString(keyboard, "Sorry! it is not there. Please Enter the word value of " +input +" ");
				n.put(input, number);
			}
			
			System.out.println("You entered " + n.get(input));
			choice = Validator.getString(keyboard, "Would you like to try again? (y/n) ");
		}
		keyboard.close();
	}
	
	public static HashMap<Integer, String> initializedHashMap(HashMap<Integer, String> n)
	{
		n.put(0, "Zero");
		n.put(1, "One");
		n.put(2, "Two");
		n.put(3, "Three");
		n.put(4, "Four");
		n.put(5, "Five");
		n.put(6, "Six");
		n.put(7, "Seven");
		n.put(8, "Eight");
		n.put(9, "Nine");
		n.put(10, "Ten");
		
		return n;
	}
}
