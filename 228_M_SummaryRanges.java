public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        
        int start = nums[0];
        int end = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == end + 1) {
                end = nums[i];
            } else {
                addResult(res, start, end);
                start = nums[i];
                end = nums[i];
            }
        }
        
        addResult(res, start, end);
        return res;
    }
    
    public void addResult(List<String> res, int start, int end) {
        if(start > end) {
            return;
        }
        String tmp = "";
        if(start == end) {
            tmp += start;
        } else {
            tmp = start + "->" + end;
        }
        res.add(tmp);
    }
}
