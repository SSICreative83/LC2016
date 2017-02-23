public class Solution {
    //clean solution using one loop
   public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum==k){
                max = Math.max(max, i+1);
            }
            int diff = sum-k;
            if(map.containsKey(diff)){
                max = Math.max(max, i-map.get(diff));
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return max;
    }
    
    
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for(int i = 0; i < sums.length; i++) {
            sums[i] = i == 0 ? nums[i] : sums[i - 1] + nums[i];
            if(!map.containsKey(sums[i])) {
                map.put(sums[i], i);
            }
        }
        
        int maxLen = 0;
        for(int i = 0; i < sums.length; i++) {
            if(map.containsKey(sums[i] - k)) {
                int j = map.get(sums[i] - k);
                maxLen = Math.max(maxLen, i - j);
            } 
        }
        
        return maxLen;
    }
}
