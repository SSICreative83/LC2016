public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        
        int i = 0;
        while(i <= heights.length) {
            if(stack.isEmpty() || (i < heights.length && heights[i] >= heights[stack.peek()])) {
                stack.push(i);
                i++;
            } else {
                int h = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * width);
            }
        }
        return max;
    }
}
