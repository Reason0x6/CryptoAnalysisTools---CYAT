import java.util.*;
import java.io.*;
public class In{
	String input = "";

	In(String url){
		try {
		      File myObj = new File(url);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
	       		 String data = myReader.nextLine();
	                 input += data;
	      	}
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    	}
	}

	public String getText(){
		return input;
	}
}
