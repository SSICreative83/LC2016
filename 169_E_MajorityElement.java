public class Solution {
    public int majorityElement(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        if(n == 1) return nums[0];
        for(int i = 0; i < n; i++) {
            int cur = nums[i];
            if(map.containsKey(cur)) {
                int curCt = map.get(cur);
                if(curCt >= n / 2) {
                    return cur;
                } else {
                    map.put(cur, map.get(cur) + 1);
                }
            } else {
                map.put(cur, 1);
            }
        }
        return 0;
    }
    
    //nlgn solution
    public int majorityElement(int[] nums) {
      Arrays.sort(nums);
      int len = nums.length;
      return nums[len/2];
    }
}
