import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.*;
import java.lang.*;
import java.io.*;

public class CYAT{
	public static void main(String args[]) {
		
		System.out.println("\n");
		if(args[0].equals("--help") || args.length < 2){

			System.out.println("Format command as: java CYAT <cipher file> <flag> <keylenght> <key>\nKeylength is needed for -poly, -split, -tc, and -all, key is only needed for -poly and -all\n");
			System.out.println("Flags are: -all | -ic | -freq | -cc | -tc | -mono | -split | -poly | --help - Only one flag can be used at a time.");
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
		if(args[1].equals("-all") || args[1].equals("-cc")){
			System.out.println("Simple Ceaser Cipher Run through for sanity check\n");
			CC cc = new CC(c.getText());
			for(int i =0; i < 26; i++){
				cc.decrypt(i);
			}
			System.out.println("-----------------------\n");
		}
		
		if(args[1].equals("-all") || args[1].equals("-tc")){
			int keyLength = Integer.parseInt(args[2]);
			System.out.println("Showing permuations of key length: " + keyLength);
			DecryptTranspositionCipher(c.getText(), keyLength);
			System.out.println("\n-----------------------\n");
		}
		if(args[1].equals("-all") || args[1].equals("-mono")){
			String key = args[2];
			System.out.println("Decrypting Using: " + key);
			Mono mono = new Mono(c.getText());
			mono.doDecryption(key);
			System.out.println("\n-----------------------\n");
		}
		if(args[1].equals("-all") || args[1].equals("-split")){
			int keyLength = Integer.parseInt(args[2]);
			System.out.println("Spliting cipher into alphabets of length: " + keyLength);
			Poly poly_split = new Poly(c.getText(), "noKey");
			poly_split.getSplit(keyLength);
			System.out.println("\n-----------------------\n");
		}

		if(args[1].equals("-all") || args[1].equals("-poly")){
			int keyLength = Integer.parseInt(args[2]);
			String key = (args[3]);
			System.out.println("Starting polyalphabeti cipher, keylength: " + keyLength + " | key: " + key);
			Poly poly_decrypt = new Poly(c.getText(), key);
			poly_decrypt.decrypt();
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

        HashMap<Character, Integer> charCountMap  = new HashMap<Character, Integer>(); 
        char[] strArray = inputString.toCharArray(); 
        for (char c : strArray) { 
            if (charCountMap.containsKey(c)) { 
                charCountMap.put(c, charCountMap.get(c) + 1); 
            } 
            else { 
                charCountMap.put(c, 1); 
            } 
		} 


        for (Map.Entry entry : charCountMap.entrySet()) { 
			if( !Character.isWhitespace((char)entry.getKey())){ 
				System.out.println(entry.getKey() + " " + entry.getValue()); 
			}
		} 
		System.out.println("\n Freq Graph \n ---------------------------- \n"); 
		for (Map.Entry entry : charCountMap.entrySet()) { 
			if( !Character.isWhitespace((char)entry.getKey())){

				int val = (int)entry.getValue();
				System.out.print(entry.getKey() + " | "); 

				for(int i = 0; i < val; i++){
					System.out.print("+"); 
				}

				System.out.print("\n"); 
			}
        } 
    } 
}

