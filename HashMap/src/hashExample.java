import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class hashExample {

	public static void main(String[] args) {
		HashMap<Integer, String> n = new HashMap<Integer, String>();
		
		Scanner keyboard = new Scanner(System.in);
		String choice = "y";
		String filename = (System.getProperty("user.dir") + File.separatorChar +"mynumbers.txt");
		n = readLines(new File(filename), n);
		while (choice.equalsIgnoreCase("y")) {
	
			
			int input =Validator.getInt(keyboard, "Enter a number: ");
			
			if(!n.containsKey(input))
			{
				String number = Validator.getString(keyboard, "Sorry! it is not there. Please Enter the word value of " +input +" ");
				n.put(input, number);
				writeHashMap(n, filename);				
			}
			
			System.out.println("You entered " + n.get(input));
			choice = Validator.getString(keyboard, "Would you like to try again? (y/n) ");
		}
		keyboard.close();
		try {
			readLines(new File(filename),n);
				for(Integer key: n.keySet())
					{
						System.out.println(" " +key + "	" + n.get(key));
					}		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	 public static HashMap<Integer, String> readLines(File file, HashMap<Integer, String> hashmap) {
	      if (!file.exists()) {
	          return hashmap;
	      }
	      try
	      {
	      BufferedReader reader = new BufferedReader(new FileReader(file));
	      String line = reader.readLine();
	      while (line != null) {
	    	  
	    	  String [] Key_value_pair = line.split("\t");
	    	  hashmap.put(Integer.parseInt(Key_value_pair[0]), Key_value_pair[1]);
	    	  line = reader.readLine();
	      }
	      reader.close();
	      }
	      catch (Exception e) {
				e.printStackTrace();
			}
	      return hashmap;
	  }
	 
	 public static HashMap<Integer, String> writeHashMap(HashMap<Integer, String> n, String filename)
		{
		 PrintWriter writer;
			try {
				writer = new PrintWriter(new File(filename));
				for(Integer key: n.keySet())
				writer.println("" + key +"	"+n.get(key));
			//you must close the PrintWriter
			writer.close();
			
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return n;
		}
/*	public static HashMap<Integer, String> initializedHashMap(HashMap<Integer, String> n)
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
	*/
}
