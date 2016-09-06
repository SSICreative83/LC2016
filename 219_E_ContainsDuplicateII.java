public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0)    return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if(map.containsKey(cur)) {
                int pre = map.get(cur);
                if(Math.abs(pre - i) <= k) {
                    return true;
                } else {
                    map.put(cur, i);
                }
            } else {
                map.put(cur, i);
            }
        }
        return false;
    }
}
