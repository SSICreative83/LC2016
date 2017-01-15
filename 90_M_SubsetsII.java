public class Solution {
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)   return res;
        
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums, tmp, res);
        List<Integer> empty = new ArrayList<>();
        res.add(empty);
        return res;        
    }
    
    public void dfs(int start, int[] nums, List<Integer> tmp, List<List<Integer>> res) {
        if(tmp.size() > 0) {
            res.add(tmp);
        }
        
        for(int i = start; i < nums.length; ) {
            List<Integer> ntmp = new ArrayList<>(tmp);
            ntmp.add(nums[i]);
            dfs(i + 1, nums, ntmp, res);
            i++;
            while(i < nums.length && nums[i] == nums[i - 1]) i++;
        }
        
    }
    
    //Iterative
    public List<List<Integer>> subsetsWithDup(int[] nums) {
	    if (nums == null)
		    return null;
 
	    Arrays.sort(nums);
 
	    List<List<Integer>> result = new ArrayList<>();
	    List<List<Integer>> prev = new ArrayList<>();
 
	    for (int i = nums.length-1; i >= 0; i--) {
 
		    //get existing sets
		    if (i == nums.length - 1 || nums[i] != nums[i + 1] || prev.size() == 0) {
			    prev = new ArrayList<>();
			    for (int j = 0; j < result.size(); j++) {
				    prev.add(new ArrayList<Integer>(result.get(j)));
			    }
		    }
 
		    //add current number to each element of the set
		    for (List<Integer> temp : prev) {
			    temp.add(0, nums[i]);
		    }
 
		    //add each single number as a set, only if current element is different with previous
		    if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
			    List<Integer> temp = new ArrayList<Integer>();
			    temp.add(nums[i]);
			    prev.add(temp);
	    	}
 
		    //add all set created in this iteration
		    for (List<Integer> temp : prev) {
			    result.add(new ArrayList<Integer>(temp));
		    }
	    }
 
	    //add empty set
	    result.add(new ArrayList<Integer>());
 
	    return result;     
    }
    
}
