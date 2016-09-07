public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || t < 0 || k < 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) {
                return true;
            } else {
                map.put(nums[i], i);   
            }
        }
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] - nums[i] > 0 && nums[j] - nums[i] <= t && Math.abs(map.get(nums[i]) - map.get(nums[j])) <= k) {
                    return true;
                } else if(nums[j] - nums[i] > t) {
                    break;
                }
            }
        }
        return false;
    }
}
