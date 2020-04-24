import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Cipher{
	public static void main(String args[]) {
		
		System.out.println("\n");
		if(args[0].equals("--help") || args.length < 2){

			System.out.println("Formate command as: java Cipher <cipher file> <flag> <keylenght>");
			System.out.println("Flags are: -all | -ic | -freq | --help");
			return;
		}
		In c = new In(args[0]);

		if(args[1].equals("-all") || args[1].equals("-ic")){
			System.out.println("Calculating the IC of the input Cipher\n");
			IC ic_x = new IC(c.getText());
			System.out.println("The IC of this cipher is: " + ic_x.calculate());
			System.out.println("-----------------------\n");

		}
		if(args[1].equals("-all") || args[1].equals("-freq")){
			System.out.println("Calculating the letter Frequency of the input Cipher\n");
			characterCount(c.getText());
			
			System.out.println("\n-----------------------\n");
		}
		
		if(args[1].equals("-all") || args[1].equals("-tc")){
			int keyLength = Integer.parseInt(args[2]);
			System.out.println("Showing permuations of key length: " + keyLength);
			DecryptTranspositionCipher(c.getText(), keyLength);
			System.out.println("\n-----------------------\n");
		}

	}
	
	
	
	public static void DecryptTranspositionCipher(String plainText, int key){
		 String[] words = plainText.split("\\s+");
	      String outputstring = "";
	  	int[] pos = new int[key];
		for(int i = 0; i < key; i++){
			pos[i] = i;
		}
		Perm x = new Perm(pos);
		
		for(int l = 0; l < factorial(key); l++){
			pos = x.get(l);
			System.out.println(Arrays.toString(pos));
			for(int k = 0; k < words.length; k++){
			for(int i = 0; i < 5; i++){
				try{System.out.print(words[k].charAt(pos[i])); }catch(Exception e){}
			}}
			System.out.println("\n");  
		}
		
	  }

	static int factorial(int n){    
	  if (n == 0)    
	    return 1;    
	  else    
	    return(n * factorial(n-1));    
	 }    
	
	

	static int countOccurences(String str, String word)  
	{ 
  		Pattern p = Pattern.compile(word);
		Matcher m = p.matcher(str);
		int count = 0;
		while (m.find()){
		    count ++;
		}
  
  		  return count; 
	}

	static void characterCount(String inputString) 
    { 
        // Creating a HashMap containing char 
        // as a key and occurrences as  a value 
        HashMap<Character, Integer> charCountMap 
            = new HashMap<Character, Integer>(); 
  
        // Converting given string to char array 
  
        char[] strArray = inputString.toCharArray(); 
  
        // checking each char of strArray 
        for (char c : strArray) { 
            if (charCountMap.containsKey(c)) { 
  
                // If char is present in charCountMap, 
                // incrementing it's count by 1 
                charCountMap.put(c, charCountMap.get(c) + 1); 
            } 
            else { 
  
                // If char is not present in charCountMap, 
                // putting this char to charCountMap with 1 as it's value 
                charCountMap.put(c, 1); 
            } 
        } 
  
        // Printing the charCountMap 
        for (Map.Entry entry : charCountMap.entrySet()) { 
            System.out.println(entry.getKey() + " " + entry.getValue()); 
        } 
    } 
}

