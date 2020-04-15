import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Cipher{
	public static void main(String args[]) {
		In c = new In(args[0]);
		if(args[1].equals("-all") || args[1].equals("-cc")){
		for(int i = 0; i < 26; i++){
			System.out.print("Caesar Offset: " + i + " :: ");
			cipher(c.getText() , i);
			System.out.println();
		}
		System.out.println("\n-----------------------\n");
		}
		if(args[1].equals("-all") || args[1].equals("-tc")){
		int space = 0;
		for(int i = 0; i < c.getText().length(); i++) {  
	            if(c.getText().charAt(i) == ' ')  {
                	space = i;
				break;
			}
	        }  
		DecryptTranspositionCipher(c.getText(), space);
		System.out.println("\n-----------------------\n");
		}
		 if(args[1].equals("-all") || args[1].equals("-cctc")){
			for(int i = 0; i < 26; i++){
                        System.out.print("Caesar Offset: " + i + " :: Inc Trans pos Cipher: ");
                        String cctc = cipherOut(c.getText() , i);
			
                        System.out.println();
			int space2 = 0;
                for(int k = 0; k < cctc.length(); k++) {  
                    if(cctc.charAt(k) == ' ')  {
                        space2 = k;
                                break;
                        }
                }  
                DecryptTranspositionCipher(cctc, space2);
				}
				System.out.println("\n-----------------------\n");
		}
		if(args[1].equals("-all") || args[1].equals("-rec")){
			char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			LinkedList<String> all = AllKLength(alphabet); 
			String noSpace = c.getText().replaceAll("\\s+","");	
			int getter = 0;
			for(String x:all){
				int counted = countOccurences(noSpace, all.get(getter));
				
				getter++;
				if(counted > 1){ System.out.println("S" + x + ": " + counted); }
			}
			System.out.println("\n-----------------------\n");
		}
		if(args[1].equals("-all") || args[1].equals("-poly")){
			final int E = 12;
			String noSpace = c.getText().replaceAll("\\s+","");	
			char[] alphabet = noSpace.toCharArray();
			String[] alphas = new String[E];

			for(int i = 0; i <E; i++)	{ alphas[i] = ""; }

			for(int i = 0; i < alphabet.length; i++){
				alphas[i % E] += alphabet[i];
			}

			for(int i = 0; i < E; i++){
				System.out.println("Part : " + (i+1) + ":\n" + alphas[i] + "\n");
			}
			System.out.println("\n-----------------------\n");

				for(int i = 0; i < 26; i++){
					System.out.print("Poly -> Caesar Offset: " + i + " :: ");
					String[] cases = new String[E];
					for(int j = 0; j < E; j++){
					
						cases[j] = cipherNo(alphas[j] , i);
					}
					String out = "";
					char[][] cs = new char[12][(alphabet.length / E)  ];
					for(int j = 0; j < E; j++){
						cs[j] = cases[j].toCharArray();
					}
					for(int k = 0; k < (alphabet.length / E)  ; k++){
						for(int j = 0; j < E; j++){
							if(cs[j][k] == 0){
								break;
							}else{
								out += cs[j][k];
							}
						}
					}
					System.out.println(out);
					System.out.println();
				}
				System.out.println("\n-----------------------\n");
			}		
		
	}
	
	//End of prgression system


	public static String cipherOut(String message, int offset) {
                StringBuilder result = new StringBuilder();
                for (char character : message.toCharArray()) {
                    if (character != ' ') {
                        int originalAlphabetPosition = character - 'a';
                        int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                        char newCharacter = (char) ('a' + newAlphabetPosition);
                        result.append(newCharacter);
                    } else {
                        result.append(character);
                    }
                }
                return (result.toString());
        }
	
	public static void cipher(String message, int offset) {
		StringBuilder result = new StringBuilder();
		for (char character : message.toCharArray()) {
		    if (character != ' ') {
		        int originalAlphabetPosition = character - 'a';
		        int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
		        char newCharacter = (char) ('a' + newAlphabetPosition);
		        result.append(newCharacter);
		    } else {
		        result.append(character);
		    }
		}
		System.out.println(result);
	}

	public static String cipherNo(String message, int offset) {
		StringBuilder result = new StringBuilder();
		for (char character : message.toCharArray()) {
		    if (character != ' ') {
		        int originalAlphabetPosition = character - 'a';
		        int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
		        char newCharacter = (char) ('a' + newAlphabetPosition);
		        result.append(newCharacter);
		    } else {
		        result.append(character);
		    }
		}
		return result.toString();
	}
	
	public static void DecryptTranspositionCipher(String plainText, int key){
		 String[] words = plainText.split("\\s+");
		 
	      String outputstring = "";
	  	int[] pos = new int[key];
		for(int i = 0; i < key; i++){
			pos[i] = i;
		}
		Perm x = new Perm(pos);
		Freq y = new Freq();
		for(int l = 0; l < factorial(key); l++){
			pos = x.get(l);
			System.out.println(Arrays.toString(pos));
			for(int k = 0; k < words.length; k++){
			for(int i = 0; i < 5; i++){
				try{System.out.print(words[k].charAt(pos[i])); if( l == 0) { y.inc(words[k].charAt(pos[i])); }}catch(Exception e){}
			}}
			System.out.println("\n");  
		}
		y.print();
	  }

	static int factorial(int n){    
	  if (n == 0)    
	    return 1;    
	  else    
	    return(n * factorial(n-1));    
	 }    
	
	public static LinkedList<String> AllKLength(char[] chars){

		LinkedList<String> arr =new LinkedList<String>();
		      String text = "";
	      for (int i = 0; i < chars.length; i++) {
	            for (int x = 0; x < chars.length; x++) {
	                  for (int j = 0; j < chars.length; j++) {
				
	                        text += chars[i];
	                        text += chars[x];
	                        text += chars[j];
        	                arr.add(text);
	                        text = "";
				
	                  }
	            }
	      }
	      return arr ;
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
}

