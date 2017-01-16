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
        List<List<Integer>> res = new ArrayList<>();
	    if (nums == null || nums.length == 0)
		    return res;
 
	    Arrays.sort(nums);

        List<List<Integer>> prev = new ArrayList<>();

        
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            
            //add result set to prev
            if(i == 0 || nums[i] != nums[i - 1] || prev.size() == 0) {
                prev = new ArrayList<>();
                for(List<Integer> in : res) {
                    prev.add(new ArrayList<Integer>(in));
                }
            }
            
            //add current number to each element in prev
            for(List<Integer> list : prev) {
                list.add(cur);
            }
            
            //add current single number as a set to prev
            if(i == 0 || nums[i] != nums[i - 1]) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[i]);
                prev.add(tmp);
            }
            
            //add each set to result
            for(List<Integer> list : prev) {
                res.add(new ArrayList<Integer>(list));
            }
            
        }
        
        List<Integer> empty = new ArrayList<>();
	    res.add(empty);        

        return res;  
    }
    
}
