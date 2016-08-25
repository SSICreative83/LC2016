public class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        if(len == 0)    return 0;
            
        int l = 0;
        int r = len - 1;
        int maxArea = 0;
        while(l < r) {
            int newArea = (r - l) * Math.min(height[l], height[r]);
            if(newArea > maxArea)   maxArea = newArea;
            
            if(height[l] < height[r]) { //find smaller height and move index
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
