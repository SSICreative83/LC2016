public class Solution {

    //DFS, wrong answer on input [1,2,3,4,5,6,7,8,9,10,1,1,1,1,1]
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> tmp = new ArrayList<>();
        dfs(nums, res, tmp, 0);
        return res;
    }
    
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> tmp, int start) {
        if(start >= nums.length) {
            return;
        }
        
        for(int i = start; i < nums.length; i++) {
            while(i != start && i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
            if(i >= nums.length) {
                break;
            }
            List<Integer> ntmp = new ArrayList<>(tmp);
            if(ntmp.size() == 0 || nums[i] >= ntmp.get(ntmp.size() - 1)) {
                ntmp.add(nums[i]);
                if(ntmp.size() >= 2) {
                    res.add(ntmp);
                }
            }

            dfs(nums, res, ntmp, i + 1);
        }
    }
}
