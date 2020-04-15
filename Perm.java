
import java.util.*;
public class Perm {
	List<List<Integer>> permute;
 	public Perm(){}

	public Perm(int[] arr) {
		
		Perm pa=new Perm();
		
		permute = pa.permute(arr);
				
	}
	
	public List<List<Integer>> permute(int[] arr) {
		List<List<Integer>> list = new ArrayList<>();
		permuteHelper(list, new ArrayList<>(), arr);
		return list;
	}
	public int[] get(int y){
	
		int[] x = permute.get(y).stream()
                    .filter(Objects::nonNull)
                    .mapToInt(Integer::intValue)
                    .toArray();
		return x;
		
	}
 
	private void permuteHelper(List<List<Integer>> list, List<Integer> resultList, int [] arr){
 
		// Base case
		if(resultList.size() == arr.length){
			list.add(new ArrayList<>(resultList));
		} 
		else{
			for(int i = 0; i < arr.length; i++){ 
 
				if(resultList.contains(arr[i])) 
				{
					// If element already exists in the list then skip
					continue; 
				}
				// Choose element
				resultList.add(arr[i]);
				// Explore
				permuteHelper(list, resultList, arr);
				// Unchoose element
				resultList.remove(resultList.size() - 1);
			}
		}
	} 
 
}
