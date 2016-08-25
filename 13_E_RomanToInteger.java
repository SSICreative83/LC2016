public class Solution {
    public int romanToInt(String s) {
        
        //define a hashtable for Roman chars
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
		    hash.put('I', 1);
		    hash.put('V', 5);
		    hash.put('X', 10);
		    hash.put('L', 50);
		    hash.put('C', 100);
		    hash.put('D', 500);
		    hash.put('M', 1000);
		
	    	char[] arr = s.toCharArray();
		    int sum = 0;
		    for(int i = 0; i < arr.length; i++) {
		        int val = hash.get(arr[i]);
		        if(i < arr.length - 1 && val < hash.get(arr[i + 1])) {
		            sum -= val;
		        } else {
		            sum += val;
		        }
		    }
        return sum;
    }
}
