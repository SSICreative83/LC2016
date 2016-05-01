public class Solution {
    //Note1: can't sort, since index will be out of order
    //Note2: if using i, j nested iterations, will be O(n^2), run time limit exeeded
    //Note3: current solution is O(n). If result is [0, 0], means didn't find any pair, could be input array not enough values, or after iteration no matching result. which will not happen in this particular problem, but will be useful in other places to validate result
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if(map.containsKey(cur)) {
                res[0] = map.get(cur);
                res[1] = i;
                break;
            } else {
                map.put(target - cur, i);
            }
        }
        
        return res;
    }
}
