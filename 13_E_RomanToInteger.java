public class Solution {
    public int romanToInt1(String s) {
        
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
	
	private Map<Character, Integer> map =
		new HashMap<Character, Integer>() {{
		put('I', 1); put('V', 5); put('X', 10);
		put('L', 50); put('C', 100); put('D', 500);
		put('M', 1000);
	}};

	public int romanToInt(String s) {
		int prev = 0, total = 0;
		for (char c : s.toCharArray()) {
			int curr = map.get(c);
			total += (curr > prev) ? (curr - 2 * prev) : curr;
			prev = curr;
		}
		return total;
	}
}
