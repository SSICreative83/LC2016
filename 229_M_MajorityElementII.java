public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        if(nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        
        int res1 = 0;
        int count1 = 0;
        int res2 = 0;
        int count2 = 0;
        
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if(cur == res1) {
                count1++;
            } else if(cur == res2) {
                count2++;
            } else if(count1 <= 0){
                count1 = 1;
                res1 = cur;
                continue;
            } else if(count2 <= 0) {
                count2 = 1;
                res2 = cur;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if(cur == res1) {
                count1++;
            } else if(cur == res2) {
                count2++;
            }
        }

        if(count1 > nums.length / 3) {
            res.add(res1);
        }
        if(count2 > nums.length / 3) {
            res.add(res2);
        }
        return res;
    }
}
