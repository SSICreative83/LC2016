public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if(lower > upper) {
            return res;
        }
        if(nums == null || nums.length == 0) {
            addRange(res, lower, upper);
            return res;
        }
        

        if(nums[0] != lower) {
            addRange(res, lower, nums[0] - 1);
        }
        
        int start = nums[0];
        int end = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if(cur == end + 1 || cur == end) {
                end = cur;
                continue;
            } else {
                addRange(res, end + 1, cur - 1);
                start = cur;
                end = cur;
            }
        }
        if(end != upper) {
            addRange(res, end + 1, upper);
        }
        
        return res;
    }
    
    public void addRange(List<String> res, int start, int end) {
        if(start > end) {
            return;
        }
        String tmp = "";
        if(start == end) {
            tmp += start;
        } else {
            tmp += start + "->" + end;
        }
        res.add(tmp);
    }
}
