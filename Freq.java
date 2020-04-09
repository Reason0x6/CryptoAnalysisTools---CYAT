import java.util.*;
public class Freq{

        Map<Character, Integer> count = new HashMap<Character, Integer>();

        Freq(){
                char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
                for(char x : alphabet){
                        count.put(x , 0);
                }
        }

        public void inc(char x){
                int curr = count.get(x);
                count.put(x, ++curr);
        }
}
