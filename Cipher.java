
import java.util.*;
import java.lang.*;
import java.io.*;
public class Cipher{
        public static void main(String args[]) {
                In c = new In(args[0]);
                for(int i = 0; i < 26; i++){
                        System.out.print("Caesar Offset: " + i + " :: ");
                        cipher(c.getText() , i);
                        System.out.println();
                }
                int space = 0;
                for(int i = 0; i < c.getText().length(); i++) {  
                    if(c.getText().charAt(i) == ' ')  {
                        space = i;
                                break;
                        }
                }  
                DecryptTranspositionCipher(c.getText(), space);
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
                                try{System.out.print(words[k].charAt(pos[i]));}catch(Exception e){}
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
}
