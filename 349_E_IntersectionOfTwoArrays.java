public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        
        Set<Integer> set1 = new HashSet<>();
        for(int i : nums1) {
            set1.add(i);
        }
        
        Set<Integer> set2 = new HashSet<>();
        for(int i : nums2) {
            if(set1.contains(i)) {
                set2.add(i);
            }
        }
        
        int[] res = new int[set2.size()];
        int i = 0;
        for(int num : set2) {
            res[i++] = num;
        }
        
        return res;
    }
}
