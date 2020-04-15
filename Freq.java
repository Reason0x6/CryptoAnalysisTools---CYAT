
import java.util.Collections; import java.util.Comparator; import java.util.HashMap; import java.util.LinkedHashMap; import java.util.Map; import static java.util.stream.Collectors.*; import static java.util.Map.Entry.*;


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
	public void print(){
		LinkedHashMap<Character, Integer> sortedMap = new LinkedHashMap<>();
 count.entrySet()
    .stream()
    .sorted(Map.Entry.comparingByValue())
    .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		System.out.println("Freq count: " + sortedMap.toString());
	}
}
